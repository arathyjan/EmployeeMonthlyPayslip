package com.myob.employeemontlypayslip.models;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PaymentPeriodTest {

    @Test
    public void parsePaymentperiodStringToInstance() {
        PaymentPeriod paymentPeriod = PaymentPeriod.createInstance("01 March – 31 March");

        assertEquals(2013, paymentPeriod.startDate.getYear());
        assertEquals(2, paymentPeriod.startDate.getMonth());
        assertEquals(1, paymentPeriod.startDate.getDate());

        assertEquals(2013, paymentPeriod.endDate.getYear());
        assertEquals(2, paymentPeriod.endDate.getMonth());
        assertEquals(31, paymentPeriod.endDate.getDate());
    }

    @Test
    public void parsePaymentperiodStringToInstanceWithYear2012IfBetweenJulytoDecember() {
        PaymentPeriod paymentPeriod = PaymentPeriod.createInstance("01 July – 31 July");

        assertEquals(2012, paymentPeriod.startDate.getYear());
        assertEquals(2012, paymentPeriod.endDate.getYear());
    }

    @Test
    public void parsePaymentperiodStringToInstanceWithYear2013IfBetweenJantoJune() {
        PaymentPeriod paymentPeriod = PaymentPeriod.createInstance("01 Jan – 31 Jan");

        assertEquals(2013, paymentPeriod.startDate.getYear());
        assertEquals(2013, paymentPeriod.endDate.getYear());
    }
}