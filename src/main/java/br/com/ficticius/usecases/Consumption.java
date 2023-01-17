package br.com.ficticius.usecases;

import br.com.ficticius.entities.ConsumptionResult;
import br.com.ficticius.entities.Travel;
import br.com.ficticius.entities.Vehicle;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Consumption {
    public ConsumptionResult calculate(Vehicle vehicle, Travel travel) {
        ConsumptionResult consumptionResult = new ConsumptionResult();
        Double fuelRequired = 0d;
        fuelRequired += travel.getCityDistance() / vehicle.getCityConsumption().getConsumption();
        fuelRequired += travel.getHighWayDistance() / vehicle.getHighWayConsumption().getConsumption();
        consumptionResult.setTotalFuelRequired(formatValue(fuelRequired, 2));
        consumptionResult.setTravel(travel);
        consumptionResult.setVehicle(vehicle);
        return consumptionResult;
    }

    private Double formatValue(double value, int decimals) {
        return new BigDecimal(value)
                .setScale(decimals, RoundingMode.HALF_EVEN).doubleValue();
    }
}
