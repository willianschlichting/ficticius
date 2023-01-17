package br.com.ficticius;

import br.com.ficticius.valueobjects.VehicleConsumption;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.fail;

public class VehicleConsumptionTest {
    @Test
    public void validConsumption() {
        new VehicleConsumption(3.5);
    }

    @ParameterizedTest
    @ValueSource(doubles = {0d, -3d})
    public void invalidConsumption(Double value) {
        try {
            new VehicleConsumption(value);
            fail();
        }catch(Exception e) {
            assertNotNull(e);
        }
    }

    @Test
    public void invalidConsumption() {
        try {
            new VehicleConsumption(null);
            fail();
        }catch(Exception e) {
            assertNotNull(e);
        }
    }
}
