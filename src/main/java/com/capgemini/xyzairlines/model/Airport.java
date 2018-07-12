package com.capgemini.xyzairlines.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Airport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private AirportNames nameOfTheAirport;

    public Airport(){

    }

    public long getId() {
        return this.id;
    }

    public AirportNames getNameOfTheAirport() {
        return this.nameOfTheAirport;
    }

    public void setNameOfTheAirport(AirportNames nameOfTheAirport) {
        this.nameOfTheAirport = nameOfTheAirport;
    }

}
