package com.capgemini.xyzairlines.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Airplaine implements Flyable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String model;
    private FuelStatus statusOfFuel;

    public Airplaine(){

    }

    public long getId() {
        return this.id;
    }

    public String getModel() {
        return this.model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public FuelStatus getStatusOfFuel() {
        return this.statusOfFuel;
    }

    public void setStatusOfFuel(FuelStatus statusOfFuel) {
        this.statusOfFuel = statusOfFuel;
    }
}
