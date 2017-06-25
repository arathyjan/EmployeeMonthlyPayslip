package com.myob.employeemontlypayslip.IOReaderWriter;

import com.myob.employeemontlypayslip.models.Employee;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class EmployeeFileReader {
     public List<Employee> readFile(String employeeDetailsFileName) {
        try {
            List<String> employeeDetails = Files.readAllLines(Paths.get(ClassLoader.getSystemResource(employeeDetailsFileName).toURI()));
            return employeeDetails
                    .stream()
                    .map(Employee::createInstance)
                    .collect(Collectors.toList());

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
