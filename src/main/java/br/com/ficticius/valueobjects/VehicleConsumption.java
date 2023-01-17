package br.com.ficticius.valueobjects;

import lombok.Getter;

public class VehicleConsumption {
    public VehicleConsumption(Double consumption) {
        if (consumption == null || consumption <= 0) {
            throw new IllegalArgumentException("consumption invalid");
        }
        this.consumption = consumption;
    }

    @Getter
    private Double consumption;
}
