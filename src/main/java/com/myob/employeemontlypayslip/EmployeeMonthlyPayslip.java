package com.myob.employeemontlypayslip;

import com.myob.employeemontlypayslip.parser.EmployeeFileReader;
import com.myob.employeemontlypayslip.parser.PayslipFileWriter;
import com.myob.employeemontlypayslip.models.Employee;
import com.myob.employeemontlypayslip.models.Payslip;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

class EmployeeMonthlyPayslip {
    private EmployeeFileReader employeeFileReader = new EmployeeFileReader();
    private PayslipFileWriter payslipFileWriter = new PayslipFileWriter();

    EmployeeMonthlyPayslip() {
    }

    EmployeeMonthlyPayslip(EmployeeFileReader employeeFileReader, PayslipFileWriter payslipFileWriter) {
        this.employeeFileReader = employeeFileReader;
        this.payslipFileWriter = payslipFileWriter;
    }

    void generatePayslips() throws IOException, URISyntaxException {
        List<Employee> employees = employeeFileReader.readFile();
        employees.forEach(employee -> payslipFileWriter.print(Payslip.createInstance(employee)));
    }
}
