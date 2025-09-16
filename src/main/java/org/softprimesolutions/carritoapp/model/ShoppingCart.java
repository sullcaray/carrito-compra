package org.softprimesolutions.carritoapp.model;

import java.util.Date;
import java.util.List;

import jakarta.persistence.*;
import lombok.Data;
import jakarta.persistence.CascadeType;

@Entity
@Data
@Table(name = "shopping_carts")
public class ShoppingCart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Date date;

    @ManyToOne
    private Client client;

    @OneToOne(mappedBy = "shoppingCart", cascade = CascadeType.ALL)
    private PaymentDetail paymentDetail;

    @OneToMany(mappedBy = "shoppingCart")
    private List<ShoppingCartDetail> details;
}
