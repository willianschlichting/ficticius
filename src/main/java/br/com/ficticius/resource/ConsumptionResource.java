package br.com.ficticius.resource;

import br.com.ficticius.dto.ConsumptionDto;
import br.com.ficticius.entities.ConsumptionResult;
import br.com.ficticius.entities.Travel;
import br.com.ficticius.entities.Vehicle;
import br.com.ficticius.model.VehicleModel;
import br.com.ficticius.repository.VehicleRepository;
import br.com.ficticius.usecases.Consumption;
import br.com.ficticius.usecases.SpentValue;
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
    public ConsumptionResult consumption(@RequestBody ConsumptionDto consumptionDto) {

        ConsumptionResult consumptionResult = null;

        VehicleModel vehicleModel = vehicleRepository.findByPlate(consumptionDto.getPlate());

        if (vehicleModel != null) {
            Vehicle vehicle = new Vehicle(vehicleModel.getPlate(), vehicleModel.getFabricationDate(), vehicleModel.getCityConsumption(), vehicleModel.getHighwayConsumption());
            /*if (vehicleModel.getFabricationDate() != null) {
                Calendar cal = Calendar.getInstance();
                cal.setTime(vehicleModel.getFabricationDate());
                vehicleModel.setYear(cal.get(Calendar.YEAR));
            }
            Double cityLiters = 0d;
            Double highWayLiters = 0d;
            if (validValue(consumption.getCityKm()) && validValue(vehicleModel.getCityConsumption())) {
                cityLiters = formatValue(consumption.getCityKm() / vehicleModel.getCityConsumption(), 2);
            }
            if (validValue(consumption.getHighWayKm()) && validValue(vehicleModel.getHighwayConsumption())) {
                highWayLiters = formatValue(consumption.getHighWayKm() / vehicleModel.getHighwayConsumption(), 2);
            }

            vehicleModel.setSpentFuel(cityLiters + highWayLiters);
            vehicleModel.setSpentValue(formatValue(vehicleModel.getSpentFuel() * consumption.getFuelPrice(), 2));*/
            Consumption consumption = new Consumption();
            consumptionResult = consumption.calculate(vehicle, new Travel(consumptionDto.getCityKm(), consumptionDto.getHighWayKm()));
            Double spentValue = new SpentValue().calculate(consumptionResult.getTotalFuelRequired(), consumptionDto.getFuelPrice());
            consumptionResult.setSpentValue(spentValue);
            return consumptionResult;
        }
        return null;
    }
}
