package br.com.ficticius.model.core;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Data
@MappedSuperclass
public class BaseEntity {

    @Id
    @Column(name = "oid", length = 38)
    private String oid;

    @Column(
            name = "created_at",
            nullable = false,
            updatable = false
    )
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

    @PrePersist
    public void prePersist() {
        this.oid = UUID.randomUUID().toString();
        this.createdAt = new Date();
    }
}
