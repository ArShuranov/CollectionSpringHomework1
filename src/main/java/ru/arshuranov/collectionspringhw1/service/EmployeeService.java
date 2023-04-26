package ru.arshuranov.collectionspringhw1.service;

public interface EmployeeService {

    String show();

    void addEmployee(Employee employee);
    void removeEmployee (String firstName, String lastName);
    void findEmployee (String firstName, String lastName);

}
