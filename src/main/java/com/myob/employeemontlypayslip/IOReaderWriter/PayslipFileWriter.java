package com.myob.employeemontlypayslip.IOReaderWriter;

import com.myob.employeemontlypayslip.models.Payslip;

public class PayslipFileWriter {

    public boolean print(Payslip payslip) {
        System.out.println(payslip);
        return true;
    }
}
