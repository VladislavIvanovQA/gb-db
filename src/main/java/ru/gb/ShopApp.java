package ru.gb;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.gb.config.HibernateConfig;
import ru.gb.dao.ManufacturerDao;
import ru.gb.dao.ProductDao;
import ru.gb.entity.Manufacturer;
import ru.gb.entity.Product;

public class ShopApp {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(HibernateConfig.class);
//        ManufacturerDao manufacturerDao = context.getBean(ManufacturerDao.class);
//        System.out.println(manufacturerDao.findNameById(3L));
//        System.out.println("-----------------------");
//        System.out.println(manufacturerDao.findById(3L));
//        System.out.println("-----------------------");
//        for (Manufacturer manufacturer : manufacturerDao.findAll()) {
//            System.out.println(manufacturer);
//        }

        ProductDao productDao = context.getBean(ProductDao.class);
        System.out.println(productDao.findTitleById(1L));
        System.out.println(productDao.findById(1L));
        for (Product product : productDao.findAll()) {
            System.out.println(product);
        }
    }
}
