package br.com.ficticius;

import br.com.ficticius.entities.Travel;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.fail;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class TravelTest {

    @Test
    public void validTravel() {
        new Travel(4d, 8d);
    }

    @Test
    public void validTravel1() {
        new Travel(null, 8d);
    }

    @Test
    public void validTravel2() {
        new Travel(4d, null);
    }

    @Test
    public void invalidTravel() {
        try {
            new Travel(null, null);
            fail();
        } catch (Exception e) {
            assertNotNull(e);
        }
    }


    @Test
    public void invalidTravel1() {
        try{
            new Travel(0d, null);
            fail();
        } catch (Exception e) {
            assertNotNull(e);
        }
    }


    @Test
    public void invalidTravel2() {
        try {
            new Travel(-3d, 400d);
            fail();
        } catch (Exception e) {
            assertNotNull(e);
        }
    }

}
