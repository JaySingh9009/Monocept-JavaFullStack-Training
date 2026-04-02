package com.streamApi.EmployeeAssignment.model;

import java.util.*;
import java.util.stream.*;

public class EmployeeService {

    public List<Employee> getActiveEmployees(List<Employee> list) {
        return list.stream()
                .filter(Employee::isActiveStatus)
                .collect(Collectors.toList());
    }

    public List<Employee> getHighSalaryEmployees(List<Employee> list, double threshold) {
        return list.stream()
                .filter(e -> e.getSalary() > threshold)
                .collect(Collectors.toList());
    }

    public Map<String, Long> countByDepartment(List<Employee> list) {
        return list.stream()
                .collect(Collectors.groupingBy(
                        Employee::getDepartment,
                        Collectors.counting()
                ));
    }

    public Employee getHighestPaidEmployee(List<Employee> list) {
        return list.stream()
                .max(Comparator.comparing(Employee::getSalary))
                .orElse(null);
    }

    public List<String> getNamesSortedBySalary(List<Employee> list) {
        return list.stream()
                .sorted(Comparator.comparing(Employee::getSalary).reversed())
                .map(Employee::getName)
                .collect(Collectors.toList());
    }

    public Map<String, List<Employee>> groupByDepartment(List<Employee> list) {
        return list.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment));
    }

    public Map<String, Double> averageSalaryByDepartment(List<Employee> list) {
        return list.stream()
                .collect(Collectors.groupingBy(
                        Employee::getDepartment,
                        Collectors.averagingDouble(Employee::getSalary)
                ));
    }
}