package com.example.carshop.controller.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CarDto {
    private String name;
    private Integer year;
    private Long manufacturerId;
    private Double ratingValue;
}
