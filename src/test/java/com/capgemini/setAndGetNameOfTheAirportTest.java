package com.capgemini;

import com.capgemini.xyzairlines.model.Airport;
import com.capgemini.xyzairlines.model.AirportNames;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class setAndGetNameOfTheAirportTest {

    private Airport airport;

    @Before
    public void setUp(){
        this.airport = new Airport();
    }

    @Test
    public void testSetNameOfTheAirport(){
        this.airport.setNameOfTheAirport(AirportNames.AMSTERDAM);
        Assert.assertEquals(AirportNames.AMSTERDAM, this.airport.getNameOfTheAirport())  ;
    }

}
