package br.com.ficticius;

import br.com.ficticius.valueobjects.Plate;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PlateTest {
    @Test
    public void testInvalidPlate() {
        try {
            new Plate("AAA123");
            fail();
        }catch(Exception e) {
            assertNotNull(e);
        }
    }

    @Test
    public void testValidPlate() {
            new Plate("AAA1234");
    }

    @Test
    public void testValidPlateValue() {
        String value = "AAA1234";
        Plate plate = new Plate(value);
        assertEquals(value, plate.getValue());

    }
}
