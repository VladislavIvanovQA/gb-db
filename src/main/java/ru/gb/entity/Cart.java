package ru.gb.entity;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@ToString
@Table(name = "cart")
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "status")
    private String status = "not empty";

    @Column(name = "total_cost")
    private BigDecimal totalCost;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
    @JoinTable(name = "cart_product",
    joinColumns = @JoinColumn(name = "cart_id"),
    inverseJoinColumns = @JoinColumn(name = "product_id"))
    @ToString.Exclude
    private Set<Product> products = new HashSet<>();

    public boolean addProduct(Product product) {
        return addProduct(Collections.singletonList(product));
    }

    public boolean addProduct(Collection<Product> products) {
        if (products == null) {
            products = new HashSet<>();
        }
        BigDecimal totalCost = new BigDecimal(0);
        for (Product product : products) {
            totalCost = totalCost.add(product.getCost());
        }
        this.totalCost = totalCost;
        return this.products.addAll(products);
    }
}
