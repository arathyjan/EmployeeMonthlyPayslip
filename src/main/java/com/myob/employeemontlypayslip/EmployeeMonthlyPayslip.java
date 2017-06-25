package com.myob.employeemontlypayslip;

import com.myob.employeemontlypayslip.IOReaderWriter.EmployeeFileReader;
import com.myob.employeemontlypayslip.IOReaderWriter.PayslipFileWriter;
import com.myob.employeemontlypayslip.models.Employee;
import com.myob.employeemontlypayslip.models.Payslip;

import java.util.List;

class EmployeeMonthlyPayslip {
    private String employeeDetailsFileName;
    private EmployeeFileReader employeeFileReader;
    private PayslipFileWriter payslipFileWriter;

    EmployeeMonthlyPayslip(String employeeDetailsFile) {
        this(employeeDetailsFile, new EmployeeFileReader(), new PayslipFileWriter());
    }

    EmployeeMonthlyPayslip(String employeeDetailsFile, EmployeeFileReader employeeFileReader, PayslipFileWriter payslipFileWriter) {
        this.employeeDetailsFileName = employeeDetailsFile;
        this.employeeFileReader = employeeFileReader;
        this.payslipFileWriter = payslipFileWriter;
    }

    void generatePayslips() {
        List<Employee> employees = employeeFileReader.readFile(employeeDetailsFileName);

        for (Employee employee : employees) {
            payslipFileWriter.write(Payslip.create(employee));
        }
    }
}
