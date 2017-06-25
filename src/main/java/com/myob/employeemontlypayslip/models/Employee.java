package com.myob.employeemontlypayslip.models;

public class Employee {
    private String firstName;
    private String lastName;
    private Double annualSalary;
    private Double superRate;
    private PaymentPeriod paymentPeriod;

    public Employee(String firstName, String lastName, Double annualSalary, Double superRate, PaymentPeriod paymentPeriod) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.annualSalary = annualSalary;
        this.superRate = superRate;
        this.paymentPeriod = paymentPeriod;
    }

    public static Employee createInstance(String employee) {
        String[] details = employee.split(",");
        String firstName = details[0];
        String lastName = details[1];
        double annualSalary = parseAnnualSalary(details[2]);
        double superRate = parseSuperRate(details[3]);
        PaymentPeriod paymentPeriod = PaymentPeriod.createInstance(details[4]);

        return new Employee(firstName, lastName, annualSalary, superRate, paymentPeriod);
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Double getAnnualSalary() {
        return annualSalary;
    }

    public Double getSuperRate() {
        return superRate;
    }

    public PaymentPeriod getPaymentPeriod() {
        return paymentPeriod;
    }

    private static double parseAnnualSalary(String detail) {
        return Double.parseDouble(detail);
    }

    private static double parseSuperRate(String detail) {
        return parseAnnualSalary(detail.replace("%", ""));
    }

    @Override
    public String toString() {
        return "Employee{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", annualSalary=" + annualSalary +
                ", superRate=" + superRate +
                ", paymentPeriod=" + paymentPeriod +
                '}';
    }
}
