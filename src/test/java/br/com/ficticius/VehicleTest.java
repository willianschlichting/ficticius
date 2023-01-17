package br.com.ficticius;

import br.com.ficticius.entities.Vehicle;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import java.util.Date;

public class VehicleTest {

    @Test
    public void testValues() {
        Vehicle vehicle = new Vehicle("AAA1234", new Date(), 3.5, 8.4);
        assertEquals("AAA1234", vehicle.getPlate().getValue());
        assertEquals(3.5, vehicle.getCityConsumption().getConsumption());
        assertEquals(8.4, vehicle.getHighWayConsumption().getConsumption());
    }

}
