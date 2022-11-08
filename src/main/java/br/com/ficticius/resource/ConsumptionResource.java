package br.com.ficticius.resource;

import br.com.ficticius.dto.ConsumptionDto;
import br.com.ficticius.model.Vehicle;
import br.com.ficticius.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Calendar;

@RestController
@RequestMapping("consumption")
public class ConsumptionResource {

    @Autowired
    private VehicleRepository vehicleRepository;

    @PostMapping
    public Vehicle consumption(@RequestBody ConsumptionDto consumption) {

        Vehicle vehicle = vehicleRepository.findByPlate(consumption.getPlate());

        if (vehicle != null) {
            if (vehicle.getFabricationDate() != null) {
                Calendar cal = Calendar.getInstance();
                cal.setTime(vehicle.getFabricationDate());
                vehicle.setYear(cal.get(Calendar.YEAR));
            }
            Double cityLiters = 0d;
            Double highWayLiters = 0d;
            if (validValue(consumption.getCityKm()) && validValue(vehicle.getCityConsumption())) {
                cityLiters = formatValue(consumption.getCityKm() / vehicle.getCityConsumption(), 2);
            }
            if (validValue(consumption.getHighWayKm()) && validValue(vehicle.getHighwayConsumption())) {
                highWayLiters = formatValue(consumption.getHighWayKm() / vehicle.getHighwayConsumption(), 2);
            }

            vehicle.setSpentFuel(cityLiters + highWayLiters);
            vehicle.setSpentValue(formatValue(vehicle.getSpentFuel() * consumption.getFuelPrice(), 2));
        }
        return vehicle;

    }

    private Double formatValue(double value, int decimals) {
        return new BigDecimal(value)
                .setScale(decimals, RoundingMode.HALF_EVEN).doubleValue();
    }

    private Boolean validValue(Integer value) {
        if (value != null && value > 0) {
            return true;
        }
        return false;
    }

    private Boolean validValue(Double value) {
        if (value != null && value > 0) {
            return true;
        }
        return false;
    }

}
