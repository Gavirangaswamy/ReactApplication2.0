package com.dxctechnology.reactapplication.entities;

import lombok.*;

import javax.persistence.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "route")
public class Route {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(name = "busId", nullable = false)
    private Long busId;
    @Column(name = "routeName", nullable = false)
    private String routeName;
    @Column(name = "origin", nullable = false)
    private String origin;
    @Column(name = "destination", nullable = false)
    private String destination;
    @Column(name = "departureDate", nullable = false)
    private String travelDate;
    @Column(name = "departureTime", nullable = false)
    private String departureTime;
    @Column(name="fare", nullable = false)
    private  int fare;

}