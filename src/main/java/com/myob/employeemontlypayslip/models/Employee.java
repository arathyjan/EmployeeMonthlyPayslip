package com.myob.employeemontlypayslip.models;

import com.myob.employeemontlypayslip.exceptions.BadInputException;

public class Employee {
    private static final String CSV_SEPARATOR = ",";
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
        String[] details = employee.split(CSV_SEPARATOR);
        String firstName = details[0];
        String lastName = details[1];
        double annualSalary = parseAnnualSalary(details[2]);
        double superRate = parseSuperRate(details[3]);
        PaymentPeriod paymentPeriod = PaymentPeriod.createInstance(details[4]);

        validateInputValues(annualSalary, superRate);

        return new Employee(firstName, lastName, annualSalary, superRate, paymentPeriod);
    }

    private static void validateInputValues(double annualSalary, double superRate) {
        if(invalidInput(annualSalary, superRate)) {
            String exceptionMessage = annualSalary < 0 ? "annual salary is less than 0" : "super rate should be between 0 and 50 inclusive";
            throw new BadInputException("Bad input " + exceptionMessage);
        }
    }

    private static boolean invalidInput(double annualSalary, double superRate) {
        return annualSalary < 0 || superRate < 0 || superRate > 50;
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
