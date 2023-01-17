package br.com.ficticius.valueobjects;


import lombok.Getter;

public class Plate {

    public Plate(String value) throws IllegalArgumentException {
        if (value == null || value.length() != 7) {
            throw new IllegalArgumentException("Invalid plate");
        }
        this.value = value;
    }

    @Getter
    private String value;
}
