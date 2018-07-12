package com.capgemini;

import com.capgemini.xyzairlines.model.Airplaine;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class setAndGetModelTest {

    private Airplaine airplaine;

    @Before
    public void setUp(){
        this.airplaine = new Airplaine();
    }

    @Test
    public void testSetModelAirplaine(){
        this.airplaine.setModel("Boeing 747-400");
        Assert.assertEquals("Boeing 747-400", this.airplaine.getModel())  ;
    }


}
