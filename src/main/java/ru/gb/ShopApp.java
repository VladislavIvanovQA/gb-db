package ru.gb;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.gb.config.HibernateConfig;
import ru.gb.dao.BuyerDao;
import ru.gb.dao.CartDao;
import ru.gb.dao.ManufacturerDao;
import ru.gb.dao.ProductDao;
import ru.gb.entity.Buyer;
import ru.gb.entity.Cart;
import ru.gb.entity.Product;

import java.util.List;

public class ShopApp {
    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(HibernateConfig.class);
        ManufacturerDao manufacturerDao = context.getBean(ManufacturerDao.class);
        ProductDao productDao = context.getBean(ProductDao.class);
        CartDao cartDao = context.getBean(CartDao.class);
        BuyerDao buyerDao = context.getBean(BuyerDao.class);

//        for (Product product : productDao.findAll()) {
//            System.out.println(product);
//        }


//        System.out.println(manufacturerDao.findNameById(3L));
//        System.out.println("-----------------------");
//        System.out.println(manufacturerDao.findById(4L).getProducts());
//        Manufacturer manufacturer = manufacturerDao.findById(4L);
        // УДАЛЕНИЕ
//        manufacturerDao.delete(manufacturer);
//        System.out.println("-----------------------");
//        for (Manufacturer manufacturer : manufacturerDao.findAll()) {
//            System.out.println(manufacturer);
//        }

//        Manufacturer testManufacturer = Manufacturer.builder()
//                .name("Company 4")
//                .products(new HashSet<Product>(((List<Product>) productDao.findAll()).subList(1, 5)))
//                .build();
//        System.out.println(testManufacturer);
//
//        manufacturerDao.save(testManufacturer);
//        System.out.println(testManufacturer);
//        Manufacturer savedManufacturer = manufacturerDao.findById(3L);
//        savedManufacturer.setName("Apple");
//        manufacturerDao.save(savedManufacturer);

//        manufacturerDao.deleteById(3L);

        List<Product> products = (List<Product>) productDao.findAll();

        Cart cart = new Cart();
        cart.addProduct(products.subList(0, 2));
        cartDao.save(cart);

        Buyer buyer = buyerDao.findById(1L);
        buyer.setCart(cart);

        buyer = buyerDao.save(buyer);
        System.out.println(buyer);

        cart = new Cart();
        cart.addProduct(products.subList(2, 4));
        cartDao.save(cart);

        buyer.setCart(cart);
        buyer = buyerDao.save(buyer);

        System.out.println(buyer);

//        for (Buyer buyer : buyerDao.findAll()) {
//            System.out.println(buyer);
//        }

    }
}
