package com.smart.home.service;

import com.smart.home.model.Reservation;

import java.math.BigDecimal;

public interface BillingService {

    BigDecimal calculateBill(Reservation reservation);
    void receivePayment(Reservation reservation);
}
