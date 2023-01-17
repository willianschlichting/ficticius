package br.com.ficticius;

import br.com.ficticius.entities.ConsumptionResult;
import br.com.ficticius.entities.Travel;
import br.com.ficticius.entities.Vehicle;
import br.com.ficticius.usecases.Consumption;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ConsumptionTest {

    @Test
    public void consumption() {
        Consumption consumption = new Consumption();

        ConsumptionResult consumptionResult = consumption.calculate(
                new Vehicle("AAA1234", new Date(), 4d, 8d)
                , new Travel(100d, 900d));
        assertEquals(137.5, consumptionResult.getTotalFuelRequired());

    }
}
