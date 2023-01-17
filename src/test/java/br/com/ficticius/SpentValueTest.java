package br.com.ficticius;

import br.com.ficticius.usecases.SpentValue;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.math.BigDecimal;
import java.math.RoundingMode;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SpentValueTest {

    @Test
    public void validSpent() {
        SpentValue spentValue = new SpentValue();
        assertEquals(new Double(808.36), spentValue.calculate(137.5, 5.879));
    }

    @Test
    public void validSpent1() {
        SpentValue spentValue = new SpentValue();
        assertEquals(new Double(884.2), spentValue.calculate(150.4, 5.879));
    }

}
