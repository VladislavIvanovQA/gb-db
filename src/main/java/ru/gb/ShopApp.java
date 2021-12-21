package ru.gb;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.gb.config.JpaConfig;
import ru.gb.entity.Buyer;
import ru.gb.entity.Order;
import ru.gb.entity.Product;
import ru.gb.service.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Random;


public class ShopApp {



    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(JpaConfig.class);
        ProductService productService = context.getBean(ProductService.class);
        ManufacturerService manufacturerService = context.getBean(ManufacturerService.class);
        BuyerService buyerService = context.getBean(BuyerService.class);
        OrderService orderService = context.getBean(OrderService.class);
        CartService cartService = context.getBean(CartService.class);

        System.out.println(buyerService.findAll());
        Buyer buyer1 = buyerService.save(Buyer.builder().name("Buyer Name").build());
        Product product1 = productService.findById(13L);
        Product product2 = productService.findById(14L);

        Product product3 = productService.findById(15L);
        Product product4 = productService.findById(16L);

        Order order1 = new Order();
        order1.setBuyer(buyer1);
        order1.addProduct(product1);
        order1.addProduct(product2);
        order1.setSum(order1.getOrderCost());

        orderService.save(order1);


        Order order2 = new Order();
        order2.setBuyer(buyer1);
        order2.addProduct(product3);
        order2.addProduct(product4);
        order2.setSum(order2.getOrderCost());

        orderService.save(order2);

        System.out.println(buyerService.findById(buyerService.count()).getOrders());
        Product product = Product.builder()
                .title("Apple Pie" + new Random().nextInt(19999))
                .cost(new BigDecimal(1000))
                .manufactureDate(LocalDate.now())
                .manufacturer(manufacturerService.findById(1L))
                .build();

        System.out.println(productService.save(product));
        System.out.println(productService.findByOrderIdAndSortByCostDesc(orderService.findById(1L)));
        System.out.println(productService.findByOrderIdAndSortByCostAsc(orderService.findById(1L)));
   }
}
