package com.myob.employeemontlypayslip.models;

import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.*;

public class PayslipTest {

    @Test
    public void testCreationOfPayslip() {
        PaymentPeriod paymentPeriod = new PaymentPeriod(new Date(2013, 2, 1), new Date(2013, 2, 31));
        Employee employee = new Employee("David", "Rudd", 60050.0, 9.0, paymentPeriod);

        Payslip payslip = Payslip.createInstance(employee);

        assertEquals("David Rudd,01 March - 31 March,5004,922,4082,450", payslip.toString());
    }

}