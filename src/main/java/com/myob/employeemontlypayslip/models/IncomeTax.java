package com.myob.employeemontlypayslip.models;

public class IncomeTax {
    public static Double calculateIncomeTax(Double income) {
        if(income <= 18200)
            return  0.0;
        else if(income <= 37000)
            return  (income - 18200) * 0.19;
        else if(income <= 80000)
            return  3572 + (income - 37000) * 0.325;
        else if(income <= 180000)
            return 17547 + (income - 80000) * 0.37;
        else
            return 54547 + (income - 180000) * 0.45;
    }
}
