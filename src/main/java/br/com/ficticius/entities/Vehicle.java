package br.com.ficticius.entities;

import br.com.ficticius.valueobjects.Plate;
import br.com.ficticius.valueobjects.VehicleConsumption;
import lombok.Data;
import lombok.Getter;

import java.util.Date;

public class Vehicle {
    public Vehicle(String plate, Date fabricationDate, Double cityConsumption, Double highWayConsumption) {
        this.plate = new Plate(plate);
        this.fabricationDate = fabricationDate;
        this.cityConsumption = new VehicleConsumption(cityConsumption);
        this.highWayConsumption = new VehicleConsumption(highWayConsumption);
    }

    @Getter
    private Plate plate;
    @Getter
    private Date fabricationDate;
    @Getter
    private VehicleConsumption cityConsumption;
    @Getter
    private VehicleConsumption highWayConsumption;

}
