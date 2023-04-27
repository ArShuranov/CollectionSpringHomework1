package ru.arshuranov.collectionspringhw1.service;

import org.springframework.stereotype.Service;
import ru.arshuranov.collectionspringhw1.exception.EmployeeNotFoundException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@Service
public class EmployeeServiceImpl implements EmployeeService {
    private List<Employee> employees = new ArrayList<>(Arrays.asList(
            new Employee("David", "Duchovny"),
            new Employee("Andrey", "Mironov")

    ));

    // показывает список сотрудников для тестов
    public String show() {
        String s = employees.toString();
        return s;
    }

    // добавляет сотрудника
    public void addEmployee(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        employees.add(employee);
    }

    // находит сотрудника
    public String findEmployee(String firstName, String lastName) {
        for (int i = 0; i < employees.size(); i++) {
            if (employees.get(i).getFirstName().equals(firstName) && employees.get(i).getLastName().equals(lastName)) {
                return employees.get(i).toString();
            }
        } throw new EmployeeNotFoundException("EmployeeNotFound");

    }

    // удаляет сотрудника
    public void removeEmployee(String firstName, String lastName) {
        for (int i = 0; i < employees.size(); i++) {
            if (employees.get(i).getFirstName().equals(firstName) && employees.get(i).getLastName().equals(lastName)) {
                employees.remove(i);
                return;
            }
        }
    }
}
