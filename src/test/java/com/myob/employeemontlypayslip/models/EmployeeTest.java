package com.myob.employeemontlypayslip.models;

import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.*;

public class EmployeeTest {

    @Test
    public void createEmployeeFromString() {
        PaymentPeriod paymentPeriod = new PaymentPeriod(new Date(2013, 2, 1), new Date(2013, 2, 31));
        Employee expectedEmployee = new Employee("David", "Rudd", 60050.0, 9.0, paymentPeriod);

        Employee employee = Employee.createInstance("David,Rudd,60050,9%,01 March – 31 March");

        assertEquals(expectedEmployee.toString(), employee.toString());
    }

}