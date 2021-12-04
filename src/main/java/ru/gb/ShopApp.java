package ru.gb;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.gb.config.JpaConfig;
import ru.gb.dao.ManufacturerDao;
import ru.gb.entity.Manufacturer;

public class ShopApp {
    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(JpaConfig.class);
        ManufacturerDao manufacturerDao = context.getBean(ManufacturerDao.class);
//        ProductDao productDao = context.getBean(ProductDao.class);
//        CartDao cartDao = context.getBean(CartDao.class);

//        for (Product product : productDao.findAll()) {
//            System.out.println(product);
//        }


//        System.out.println(manufacturerDao.findNameById(3L));
//        System.out.println("-----------------------");
        System.out.println(manufacturerDao.findById(4L).getProducts());
        Manufacturer manufacturer = manufacturerDao.findById(4L);
        // УДАЛЕНИЕ
        manufacturerDao.delete(manufacturer);
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

//        Product product = ((List<Product>) productDao.findAll()).get(5);
//
//        Cart cart = new Cart();
//        cart.addProduct(product);
//        cartDao.save(cart);
    }
}
