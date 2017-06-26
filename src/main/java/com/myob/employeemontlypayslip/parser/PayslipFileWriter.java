package com.myob.employeemontlypayslip.parser;

import com.myob.employeemontlypayslip.models.Payslip;

public class PayslipFileWriter {

    public boolean print(Payslip payslip) {
        System.out.println(payslip);
        return true;
    }
}
