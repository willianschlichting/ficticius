package br.com.ficticius.entities;

import lombok.Getter;

public class Travel {

    public Travel(Double cityDistance, Double highWayDistance) {
        if (!validDouble(cityDistance) && !validDouble(highWayDistance)) {
            throw new IllegalArgumentException("one distance is mandatory");
        }
        if (cityDistance != null && cityDistance < 0) {
            throw new IllegalArgumentException("city distance can't be smaller than zero");
        }
        if (highWayDistance != null && highWayDistance < 0) {
            throw new IllegalArgumentException("highway distance can't be smaller than zero");
        }
        this.cityDistance = cityDistance;
        this.highWayDistance = highWayDistance;
    }

    private Boolean validDouble(Double value) {
        return value != null && value > 0;
    }

    @Getter
    private Double cityDistance;
    @Getter
    private Double highWayDistance;
}
