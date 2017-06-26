package com.myob.employeemontlypayslip.IOReaderWriter;

import com.myob.employeemontlypayslip.models.Employee;
import com.myob.employeemontlypayslip.parser.EmployeeFileReader;
import org.junit.Test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class EmployeeFileReaderTest {

    @Test
    public void testReadFileProperly() throws IOException, URISyntaxException {
        List<Employee> employees = new EmployeeFileReader().readFile();

        assertEquals("David", employees.get(0).getFirstName());
        assertEquals("Rudd", employees.get(0).getLastName());
        assertEquals("Ryan", employees.get(1).getFirstName());
        assertEquals("Chen", employees.get(1).getLastName());
    }
}