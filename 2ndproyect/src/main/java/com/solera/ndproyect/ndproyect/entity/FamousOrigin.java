package com.solera.ndproyect.ndproyect.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Table(name="famousorigins")
public class FamousOrigin implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "ID_FO")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idFO;

    @Column(name = "NAME")
    @NotNull
    private String name;

    @Column(name = "TIMES")
    @NotNull
    private Integer times;

    public FamousOrigin(long idFO, String name, Integer times) {
        this.idFO = idFO;
        this.name = name;
        this.times = times;
    }

    public FamousOrigin() {
    }

    public long getIdFO() {
        return idFO;
    }

    public String getName() {
        return name;
    }

    public Integer getTimes() {
        return times;
    }
}
