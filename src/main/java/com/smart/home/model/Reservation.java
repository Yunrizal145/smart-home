package com.smart.home.model;

import com.smart.home.PaymentStatus;
import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "reservations")
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "room_id")
    private Room room;

    private Timestamp checkInDate;

    private Timestamp chechOutDate;

    private boolean breakFast;

    private boolean extraBed;

    private BigDecimal billAmount;

    private PaymentStatus paymentStatus;

    @ManyToOne
    private Employee employee;
}
