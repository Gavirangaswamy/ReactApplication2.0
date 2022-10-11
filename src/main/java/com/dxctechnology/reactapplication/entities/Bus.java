package com.dxctechnology.reactapplication.entities;

import lombok.*;

import javax.persistence.*;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "bus")
public class Bus {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(name = "busName", nullable = false)
    private String busName;
    @Column(name = "registration", nullable = false)
    private String registration;
    @Column(name = "type", nullable = false)
    private String type;
    @Column(name = "no_of_seats", nullable = false)
    private Integer noOfSeats;

}