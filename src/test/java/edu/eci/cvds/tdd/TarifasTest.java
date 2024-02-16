package edu.eci.cvds.tdd;

import org.junit.Assert;
import org.junit.Test;
import edu.eci.cvds.tdd.aerodescuentos.CalculadorDescuentos;

public class TarifasTest {
    @Test(expected = IllegalArgumentException.class)
    public void Should_ThrowException_When_BaseRateLessThanOne() {
        CalculadorDescuentos.calculoTarifa(0, 10, 18);
    }

    @Test
    public void Should_CalculateRate_When_BaseRateEqualToOne(){
        double rate = CalculadorDescuentos.calculoTarifa(1, 10, 18);
        Assert.assertEquals(1, rate, 0.0001);
    }

    @Test
    public void Should_CalculateRate_When_BaseRateGraterThanOne(){
        double rate = CalculadorDescuentos.calculoTarifa(2, 10, 18);
        Assert.assertEquals(2, rate, 0.0001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void Should_ThrowException_When_DaysInAdvanceLessThanZero() {
        CalculadorDescuentos.calculoTarifa(1, -1, 18);
    }

    @Test
    public void Should_CalculateRate_When_DaysInAdvanceEqualToZero(){
        double rate = CalculadorDescuentos.calculoTarifa(1, 0, 18);
        Assert.assertEquals(1, rate, 0.0001);
    }

    @Test
    public void Should_CalculateRate_When_DaysInAdvanceGraterThanZero(){
        double rate = CalculadorDescuentos.calculoTarifa(1, 1, 18);
        Assert.assertEquals(1, rate, 0.0001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void Should_ThrowException_When_AgeLessThanZero() {
        CalculadorDescuentos.calculoTarifa(1, 1, -1);
    }
}
