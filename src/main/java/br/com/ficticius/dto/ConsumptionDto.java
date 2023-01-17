package br.com.ficticius.dto;

import lombok.Data;

@Data
public class ConsumptionDto {
    private String plate;
    private Double cityKm;
    private Double highWayKm;
    private Double fuelPrice;
}
