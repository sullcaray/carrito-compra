package org.softprimesolutions.carritoapp.repository;

import org.softprimesolutions.carritoapp.model.PaymentDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentDetailRepository extends JpaRepository<PaymentDetail, Integer> {
}
