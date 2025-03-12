package com.example.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
//Ref.url:-https://www.javaguides.net/2018/09/spring-boot-2-jpa-mysql-crud-example.html
//Ref.frontend.url:- https://www.javaguides.net/2021/08/angular-crud-example-with-spring-boot.html
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="product")
public class ProductsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name ="product_name")
    private String productName;
    @Column(name ="product_price")
    private String productPrice;
}
