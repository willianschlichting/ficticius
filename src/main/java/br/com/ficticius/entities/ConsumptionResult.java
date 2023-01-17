package br.com.ficticius.entities;

import lombok.Data;
import lombok.Getter;

@Data
public class ConsumptionResult {
    private Vehicle vehicle;
    private Travel travel;
    private Double totalFuelRequired;
    private Double spentValue;

}
