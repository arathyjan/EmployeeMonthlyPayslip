package com.myob.employeemontlypayslip;

import java.io.IOException;
import java.net.URISyntaxException;

public class Main {

    public static void main(String[] args) throws URISyntaxException, IOException {
        EmployeeMonthlyPayslip employeeMonthlyPayslip = new EmployeeMonthlyPayslip("input.txt");
        employeeMonthlyPayslip.generatePayslips();
    }
}
