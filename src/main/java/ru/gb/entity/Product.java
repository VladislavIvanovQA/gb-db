package ru.gb.entity;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "PRODUCT")
@NamedQueries({
        @NamedQuery(name = "Product.findTitleById",
                query = "select p.title from Product p where p.id = :id"),
        @NamedQuery(name = "Product.findById",
                query = "select p from Product p where p.id = :id")
})
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "ID")
    private Long id;
    @Column(name = "TITLE")
    private String title;
    @Column(name = "COST")
    private BigDecimal cost;
    @Column(name = "MANUFACTURE_DATE")
    private LocalDate manufactureDate;

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", cost=" + cost +
                ", manufactureDate=" + manufactureDate +
                '}';
    }
}
