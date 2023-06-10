package com.smart.home.service.impl;

import com.smart.home.model.Reservation;
import com.smart.home.repository.ReservationRepository;
import com.smart.home.service.BillingService;
import com.smart.home.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class ReservationServiceImpl implements ReservationService {

    @Autowired
    private ReservationRepository reservationRepository;

    @Autowired
    private BillingService billingService;

    @Override
    public List<Reservation> getAllReservation() {
        return reservationRepository.findAll();
    }

    @Override
    public Reservation createReservation(Reservation reservation) {
        return reservationRepository.save(reservation);
    }

    @Override
    public BigDecimal calculateBill(Long reservationId) {
        Reservation reservation = reservationRepository.findById(reservationId).
                orElseThrow(() -> new RuntimeException("Reservation not found with id: " +reservationId));

        return billingService.calculateBill(reservation);
    }

    @Override
    public void receivePayment(Long reservationId) {
        Reservation reservation = reservationRepository.findById(reservationId)
                .orElseThrow(() -> new RuntimeException("Reservation not found with id: " + reservationId));

        billingService.receivePayment(reservation);
    }
}
