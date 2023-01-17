package br.com.ficticius.usecases;

import br.com.ficticius.entities.ConsumptionResult;
import br.com.ficticius.entities.Travel;
import br.com.ficticius.entities.Vehicle;

public class Consumption {
    public ConsumptionResult calculate(Vehicle vehicle, Travel travel) {
        ConsumptionResult consumptionResult = new ConsumptionResult();
        Double fuelRequired = 0d;
        fuelRequired += travel.getCityDistance() / vehicle.getCityConsumption().getConsumption();
        fuelRequired += travel.getHighWayDistance() / vehicle.getHighWayConsumption().getConsumption();
        consumptionResult.setTotalFuelRequired(fuelRequired);
        return consumptionResult;
    }
}
