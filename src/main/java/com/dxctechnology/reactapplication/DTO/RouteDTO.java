package com.dxctechnology.reactapplication.DTO;

import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class RouteDTO {

    private Long id;
    private Long busId;
    private String routeName;
    private String origin;
    private String destination;
    private String travelDate;
    private String departureTime;
    private  int fare;

}