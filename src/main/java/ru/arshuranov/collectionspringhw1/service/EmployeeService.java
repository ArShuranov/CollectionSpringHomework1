package ru.arshuranov.collectionspringhw1.service;

public interface EmployeeService {

    String show();

    void addEmployee(String firstName, String lastName);
    String findEmployee (String firstName, String lastName);
    void removeEmployee (String firstName, String lastName);
}
