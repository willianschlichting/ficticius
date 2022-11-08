package br.com.ficticius.dto;

import lombok.Data;

@Data
public class ConsumptionDto {
    private String plate;
    private Integer cityKm;
    private Integer highWayKm;
    private Double fuelPrice;
}
