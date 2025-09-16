package org.softprimesolutions.carritoapp.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "paymentdetail")
public class PaymentDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String cardholder;
    private String cardnumber;
    private String expire;
    private String code;

    @OneToOne
    @JoinColumn(name = "shopping_cart_id")
    private ShoppingCart shoppingCart;
}
