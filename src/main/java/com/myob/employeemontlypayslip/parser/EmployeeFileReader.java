package com.myob.employeemontlypayslip.parser;

import com.myob.employeemontlypayslip.models.Employee;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class EmployeeFileReader {

    private static final String INPUT_FILE_NAME = "input.csv";

    public List<Employee> readFile() throws IOException, URISyntaxException {
        List<String> employeeDetails = readEmployeeDetailsFromFile(INPUT_FILE_NAME);
        return employeeDetails
                .stream()
                .map(Employee::createInstance)
                .collect(Collectors.toList());
    }

    private List<String> readEmployeeDetailsFromFile(String employeeDetailsFileName) throws URISyntaxException, IOException {
        URL classpathUrl = ClassLoader.getSystemResource(employeeDetailsFileName);
        if(classpathUrl == null)
            throw new FileNotFoundException("Cannot read file with name" + employeeDetailsFileName);
        return Files.readAllLines(Paths.get(classpathUrl.toURI()));
    }
}
