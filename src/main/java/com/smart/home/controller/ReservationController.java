package com.smart.home.controller;

import com.smart.home.model.Reservation;
import com.smart.home.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/reservations")
public class ReservationController {

    @Autowired
    private ReservationService reservationService;


    @GetMapping
    public List<Reservation> getAllReservations(){
        return reservationService.getAllReservation();
    }


    @PostMapping
    public Reservation createReservation(@RequestBody Reservation reservation){
        return reservationService.createReservation(reservation);
    }

    @GetMapping("/{reservationId}/bill")
    public ResponseEntity<BigDecimal> calculateBill(@PathVariable Long reservationId){
        BigDecimal billAmount = reservationService.calculateBill(reservationId);

        return new ResponseEntity<>(billAmount, HttpStatus.OK);
    }

    @PutMapping("/{reservationId}/payment")
    public ResponseEntity<String> receivePayment(@PathVariable Long reservationId){
        reservationService.receivePayment(reservationId);

        return new ResponseEntity<>("Payment Receive", HttpStatus.OK);
    }
}
