package ru.gb.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Builder
@Table(name = "BUYER")
@NoArgsConstructor
@AllArgsConstructor
public class Buyer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name")
    private String name;

    @OneToMany(fetch = FetchType.EAGER,
            cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
    @JoinTable(name = "buyer_order",
            joinColumns = @JoinColumn(name = "buyer_id"),
            inverseJoinColumns = @JoinColumn(name = "cart_id"))
    private Set<Cart> carts;

    public boolean setCart(Cart cart) {
        return setCart(Collections.singleton(cart));
    }

    public boolean setCart(Collection<Cart> carts) {
        if (carts == null) {
            carts = new HashSet<>();
        }
        return this.carts.addAll(carts);
    }

    @Override
    public String toString() {
        return "Buyer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", total_cost=" + String.format("%.2f", carts.stream()
                                        .mapToDouble(cart -> cart.getTotalCost().doubleValue()).sum()) +
                '}';
    }
}