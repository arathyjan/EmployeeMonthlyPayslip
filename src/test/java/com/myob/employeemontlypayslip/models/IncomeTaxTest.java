package com.myob.employeemontlypayslip.models;

import org.junit.Test;

import static org.junit.Assert.*;

public class IncomeTaxTest {

    @Test
    public void calculateIncomeTax() {
        assertEquals(0, new IncomeTax().calculateIncomeTax(18000.0), 0);
        assertEquals(2242, new IncomeTax().calculateIncomeTax(30000.0), 0);
        assertEquals(11063.25, new IncomeTax().calculateIncomeTax(60050.0), 0);
        assertEquals(24947, new IncomeTax().calculateIncomeTax(100000.0), 0);
        assertEquals(63547, new IncomeTax().calculateIncomeTax(200000.0), 0);
    }
}