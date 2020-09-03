package com.example.NWM.dao.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.NWM.entity.Payment;

@Repository
public interface PaymentJpaDao extends JpaRepository<Payment, Long> {

}
