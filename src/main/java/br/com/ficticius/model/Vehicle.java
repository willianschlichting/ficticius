package br.com.ficticius.model;

import br.com.ficticius.model.core.BaseEntity;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "vehicle")
public class Vehicle extends BaseEntity {

    @Column(name = "plate", length = 8, nullable = false)
    private String plate;

    @Column(name = "brand", length = 120)
    private String brand;

    @Column(name = "model")
    private String model;

    @Column(name = "fabrication_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fabricationDate;

    @Column(name = "city_consumption", nullable = false)
    private Double cityConsumption;

    @Column(name = "highway_consumption", nullable = false)
    private Double highwayConsumption;

    @Transient
    private Double spentFuel;

    @Transient
    private Double spentValue;

    @Transient
    private Integer year;

}
