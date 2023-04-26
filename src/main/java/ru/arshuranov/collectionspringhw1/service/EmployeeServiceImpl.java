package ru.arshuranov.collectionspringhw1.service;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private List<Employee> employees = new ArrayList<>(Arrays.asList());

    @Override
    public String show() {
        String s = employees.toString();
        return s;
    }

    @Override
    public void addEmployee(Employee employee) {
        employees.add(employee);
    }

    public void removeEmployee(String firstName, String lastName) {
        for (int i = 0; i < employees.size(); i++) {
            if (employees.get(i).getFirstName().equals(firstName) && employees.get(i).getLastName().equals(lastName)) {
                employees.remove(i);
                System.out.println("Сотрудник успешно удален");
            }
        }


    }

    public void findEmployee(String firstName, String lastName) {
        for (int i = 0; i < employees.size(); i++) {
            if (employees.get(i).getFirstName().equals(firstName) && employees.get(i).getLastName().equals(lastName)) {
                System.out.println("Сотрудник успешно найден");
            }
        }

    }
}
