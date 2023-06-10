package com.smart.home.service.impl;

import com.smart.home.PaymentStatus;
import com.smart.home.model.Reservation;
import com.smart.home.repository.ReservationRepository;
import com.smart.home.service.BillingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.time.temporal.Temporal;

@Service
public class BillingServiceImpl implements BillingService {

    @Autowired
    private ReservationRepository reservationRepository;

    @Override
    public BigDecimal calculateBill(Reservation reservation) {
        BigDecimal roomRate = BigDecimal.valueOf(reservation.getRoom().getPrice());
        long numberOfNights = ChronoUnit.DAYS.between(reservation.getCheckInDate().toLocalDateTime(), reservation.getChechOutDate().toLocalDateTime());
        BigDecimal subtotal = roomRate.multiply(BigDecimal.valueOf(numberOfNights));

        if (reservation.isBreakFast()) {
            BigDecimal breakfastRate = BigDecimal.valueOf(reservation.getRoom().getPrice());
            BigDecimal breakfastCharge = breakfastRate.multiply(BigDecimal.valueOf(numberOfNights));
            subtotal = subtotal.add(breakfastCharge);
        }

        if (reservation.isExtraBed()) {
            BigDecimal extraBedCharge = BigDecimal.valueOf(reservation.getRoom().getPrice());
            subtotal = subtotal.add(extraBedCharge);
        }

        return subtotal;
    }

    @Override
    public void receivePayment(Reservation reservation) {
        reservation.setPaymentStatus(PaymentStatus.PAID);

        reservationRepository.save(reservation);
    }
}
