package org.softprimesolutions.carritoapp.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@Table(name = "payment_details")
@EqualsAndHashCode(callSuper = true)
public class PaymentDetail extends EntityAudit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "cardholder", nullable = false, length = 100)
    private String cardholder;

    @Column(name = "card_number", nullable = false, length = 20)
    private String cardNumber;

    @Column(name = "expire_date", nullable = false, length = 7)
    private String expireDate;

    @Column(name = "security_code", nullable = false, length = 4)
    private String securityCode;

    @Column(name = "payment_method", length = 50)
    private String paymentMethod = "CREDIT_CARD";

    @Column(name = "payment_status", length = 20)
    private String paymentStatus = "PENDING";

    @Column(name = "transaction_id", length = 100)
    private String transactionId;

    @OneToOne
    @JoinColumn(name = "shopping_cart_id", nullable = false, unique = true)
    private ShoppingCart shoppingCart;
}
