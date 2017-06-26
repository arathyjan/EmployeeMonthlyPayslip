package com.myob.employeemontlypayslip;

import com.myob.employeemontlypayslip.IOReaderWriter.EmployeeFileReader;
import com.myob.employeemontlypayslip.IOReaderWriter.PayslipFileWriter;
import com.myob.employeemontlypayslip.models.Employee;
import com.myob.employeemontlypayslip.models.PaymentPeriod;
import com.myob.employeemontlypayslip.models.Payslip;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

public class EmployeeMonthlyPayslipTest {

    @Mock
    EmployeeFileReader employeeFileReader;
    @Mock
    PayslipFileWriter payslipFileWriter;

    @Before
    public void setUp() {
        initMocks(this);
    }

    @Test
    public void testPayslipCreationForInput() throws IOException, URISyntaxException {
        PaymentPeriod paymentPeriod = new PaymentPeriod(new Date(2013, 2, 1), new Date(2013, 2, 31));
        Employee employee = new Employee("David", "Rudd", 60050.0, 9.0, paymentPeriod);

        List<Employee> employeeList = Arrays.asList(employee);
        when(employeeFileReader.readFile()).thenReturn(employeeList);
        when(payslipFileWriter.print(any(Payslip.class))).thenReturn(true);

        EmployeeMonthlyPayslip employeeMonthlyPayslip = new EmployeeMonthlyPayslip(employeeFileReader, payslipFileWriter);
        employeeMonthlyPayslip.generatePayslips();

        verify(employeeFileReader).readFile();
        ArgumentCaptor<Payslip> payslipCapture = ArgumentCaptor.forClass(Payslip.class);
        verify(payslipFileWriter).print(payslipCapture.capture());

        assertEquals("David Rudd,01 March – 31 March,5004,922,4082,450", payslipCapture.getAllValues().get(0).toString());
    }

}