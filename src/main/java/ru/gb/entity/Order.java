package ru.gb.entity;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @ManyToOne()
    @JoinColumn(name = "buyer_id")
    private Buyer buyer;
    @Column(name = "sum")
    private BigDecimal sum;


    @ManyToMany(cascade = {CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH}, fetch = FetchType.EAGER)
    @JoinTable(name = "order_product",
            joinColumns = @JoinColumn(name = "order_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id"))
    private Set<Product> products = new HashSet<>();

    public boolean addProduct(Product product) {
        if (products == null) {
            products = new HashSet<>();
        }
        return products.add(product);
    }

    public BigDecimal getOrderCost() {
        BigDecimal sum = BigDecimal.ZERO;
        for (Product product : products) {
            sum = sum.add(product.getCost());
        }
        return sum;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", buyer=" + buyer +
                ", products==" + products +
                ", fullCost=" + sum +
                '}';
    }
}
