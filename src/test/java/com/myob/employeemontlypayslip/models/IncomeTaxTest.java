package com.myob.employeemontlypayslip.models;

import org.junit.Test;

import static org.junit.Assert.*;

public class IncomeTaxTest {

    @Test
    public void calculateIncomeTax() {
        assertEquals(0, IncomeTax.calculateIncomeTax(18000.0), 0);
        assertEquals(2242, IncomeTax.calculateIncomeTax(30000.0), 0);
        assertEquals(11063.25, IncomeTax.calculateIncomeTax(60050.0), 0);
        assertEquals(24947, IncomeTax.calculateIncomeTax(100000.0), 0);
        assertEquals(63547, IncomeTax.calculateIncomeTax(200000.0), 0);
    }
}