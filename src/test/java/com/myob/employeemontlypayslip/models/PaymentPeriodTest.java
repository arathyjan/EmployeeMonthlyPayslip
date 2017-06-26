package com.myob.employeemontlypayslip.models;

import com.myob.employeemontlypayslip.exceptions.BadInputException;
import org.junit.Test;

import java.text.ParseException;

import static org.junit.Assert.assertEquals;

public class PaymentPeriodTest {

    @Test
    public void parsePaymentperiodStringToInstance() {
        PaymentPeriod paymentPeriod = PaymentPeriod.createInstance("01 March – 31 March");

        assertEquals(2013, paymentPeriod.getStartDate().getYear());
        assertEquals(2, paymentPeriod.getStartDate().getMonth());
        assertEquals(1, paymentPeriod.getStartDate().getDate());

        assertEquals(2013, paymentPeriod.getEndDate().getYear());
        assertEquals(2, paymentPeriod.getEndDate().getMonth());
        assertEquals(31, paymentPeriod.getEndDate().getDate());
    }

    @Test
    public void parsePaymentperiodStringToInstanceWithYear2012IfBetweenJulytoDecember() {
        PaymentPeriod paymentPeriod = PaymentPeriod.createInstance("01 July – 31 July");

        assertEquals(2012, paymentPeriod.getStartDate().getYear());
        assertEquals(2012, paymentPeriod.getEndDate().getYear());
    }

    @Test
    public void parsePaymentperiodStringToInstanceWithYear2013IfBetweenJantoJune() {
        PaymentPeriod paymentPeriod = PaymentPeriod.createInstance("01 Jan – 31 Jan");

        assertEquals(2013, paymentPeriod.getStartDate().getYear());
        assertEquals(2013, paymentPeriod.getEndDate().getYear());
    }

    @Test(expected = BadInputException.class)
    public void throwExceptionWhenDatesAreNotSeparatedByCorrectDelimiter() {
        PaymentPeriod.createInstance("01 Jan/31 Jan");
    }

    @Test(expected = BadInputException.class)
    public void throwExceptionWhenDateFormatIsWrong() {
        PaymentPeriod.createInstance("01/Jan – 31/Jan");
    }
}