package com.smart.home.service;

import com.smart.home.model.Reservation;

import java.math.BigDecimal;
import java.util.List;

public interface ReservationService {

    List<Reservation> getAllReservation();
    Reservation createReservation(Reservation reservation);
    BigDecimal calculateBill(Long reservationId);
    void receivePayment(Long reservationId);
}
