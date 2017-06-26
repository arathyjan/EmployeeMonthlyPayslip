package com.myob.employeemontlypayslip.models;

public class Payslip {
    private String name;
    private PaymentPeriod paymentPeriod;
    private Long grossIncome;
    private Long incomeTax;
    private Long netIncome;
    private Long superAnnuation;

    public static Payslip createInstance(Employee employee) {
        Payslip payslip = new Payslip();
        payslip.name = String.format("%s %s", employee.getFirstName(), employee.getLastName());
        payslip.paymentPeriod = employee.getPaymentPeriod();
        payslip.grossIncome = Math.round(employee.getAnnualSalary()/12);
        payslip.incomeTax = Math.round(IncomeTax.calculateIncomeTax(employee.getAnnualSalary())/12);
        payslip.netIncome = payslip.getNetIncome();
        payslip.superAnnuation = Math.round(payslip.grossIncome * employee.getSuperRate() / 100);
        return payslip;
    }

    private long getNetIncome() {
        return grossIncome - incomeTax;
    }

    @Override
    public String toString() {
        return name + ","
                + paymentPeriod + ","
                + grossIncome + ","
                + incomeTax + ","
                + netIncome + ","
                + superAnnuation;
    }
}
