package br.com.ficticius.usecases;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class SpentValue {
    public Double calculate(Double spentFuel, Double price) {
        return formatValue(spentFuel * price, 2);
    }


    private Double formatValue(double value, int decimals) {
        return new BigDecimal(value)
                .setScale(decimals, RoundingMode.HALF_EVEN).doubleValue();
    }
}
