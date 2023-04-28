package ru.arshuranov.collectionspringhw1.service;

import org.springframework.stereotype.Service;
import ru.arshuranov.collectionspringhw1.exception.EmployeeAlreadyAddedException;
import ru.arshuranov.collectionspringhw1.exception.EmployeeNotFoundException;

import java.util.ArrayList;
import java.util.List;


@Service
public class EmployeeServiceImpl implements EmployeeService {
    private List<Employee> employees = new ArrayList<>(List.of(
            new Employee("David", "Duchovny"),
            new Employee("Andrey", "Mironov"),
            new Employee("Ivan", "Ivanov")

    ));

    // выводит список всех сотрудников
    public String show() {
        String s = employees.toString();
        return s;
    }

    // добавляет сотрудника
    public String addEmployee(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (employees.contains(employee)) {
            throw new EmployeeAlreadyAddedException("EmployeeAlreadyAdded");
        } else {
            employees.add(employee);
            return employee.toString();
        }

    }

    // находит сотрудника
    public String findEmployee(String firstName, String lastName) {
        for (int i = 0; i < employees.size(); i++) {
            if (employees.get(i).getFirstName().equals(firstName) && employees.get(i).getLastName().equals(lastName)) {
                return employees.get(i).toString();
            }
        }
        throw new EmployeeNotFoundException("EmployeeNotFound");

    }

    // удаляет сотрудника
    public String removeEmployee(String firstName, String lastName) {
        for (int i = 0; i < employees.size(); i++) {
            if (employees.get(i).getFirstName().equals(firstName) && employees.get(i).getLastName().equals(lastName)) {
                String s = employees.get(i).toString();
                employees.remove(i);
                return s;

            }
        }
        throw new EmployeeNotFoundException("EmployeeNotFound");
    }
}
