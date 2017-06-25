package com.myob.employeemontlypayslip.IOReaderWriter;

import com.myob.employeemontlypayslip.IOReaderWriter.EmployeeFileReader;
import com.myob.employeemontlypayslip.models.Employee;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class EmployeeFileReaderTest {

    @Test
    public void testReadFileProperly() {
        List<Employee> employees = new EmployeeFileReader().readFile("input.txt");

        assertEquals("David", employees.get(0).getFirstName());
        assertEquals("Rudd", employees.get(0).getLastName());
        assertEquals("Ryan", employees.get(1).getFirstName());
        assertEquals("Chen", employees.get(1).getLastName());
    }

    @Test
    public void returnNullIfFileNotFound() {
        List<Employee> employees = new EmployeeFileReader().readFile("abc.txt");

        assertNull(employees);
    }
}