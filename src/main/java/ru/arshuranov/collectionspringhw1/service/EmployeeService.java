package ru.arshuranov.collectionspringhw1.service;

public interface EmployeeService {

    String show();

    String addEmployee(String firstName, String lastName);
    String findEmployee (String firstName, String lastName);
    String removeEmployee (String firstName, String lastName);
}
