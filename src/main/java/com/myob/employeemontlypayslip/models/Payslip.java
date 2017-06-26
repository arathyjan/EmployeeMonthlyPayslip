package com.myob.employeemontlypayslip.models;

public class Payslip {
    private static final int NO_OF_MONTHS_IN_YEAR = 12;
    private String name;
    private PaymentPeriod paymentPeriod;
    private Long grossIncome;
    private Long incomeTax;
    private Long netIncome;
    private Long superannuation;

    public static Payslip createInstance(Employee employee) {
        Payslip payslip = new Payslip();
        payslip.name = getFullName(employee);
        payslip.paymentPeriod = employee.getPaymentPeriod();
        payslip.grossIncome = getGrossIncome(employee);
        payslip.incomeTax = getIncomeTax(employee);
        payslip.netIncome = payslip.grossIncome - payslip.incomeTax;
        payslip.superannuation = getSuperannuation(employee, payslip);
        return payslip;
    }

    private static long getSuperannuation(Employee employee, Payslip payslip) {
        return Math.round(payslip.grossIncome * employee.getSuperRate() / 100);
    }

    private static long getIncomeTax(Employee employee) {
        return Math.round(IncomeTax.calculateIncomeTax(employee.getAnnualSalary()) / NO_OF_MONTHS_IN_YEAR);
    }

    private static String getFullName(Employee employee) {
        return String.format("%s %s", employee.getFirstName(), employee.getLastName());
    }

    private static long getGrossIncome(Employee employee) {
        return Math.round(employee.getAnnualSalary()/ NO_OF_MONTHS_IN_YEAR);
    }

    @Override
    public String toString() {
        return name + ","
                + paymentPeriod + ","
                + grossIncome + ","
                + incomeTax + ","
                + netIncome + ","
                + superannuation;
    }
}
