package com.dxctechnology.reactapplication.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BusDTO {

    private Long id;
    private String busName;
    private String registration;
    private String type;
    private Integer noOfSeats;

}