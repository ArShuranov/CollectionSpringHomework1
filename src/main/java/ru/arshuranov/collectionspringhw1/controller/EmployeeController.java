package ru.arshuranov.collectionspringhw1.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.arshuranov.collectionspringhw1.service.Employee;
import ru.arshuranov.collectionspringhw1.service.EmployeeService;

@RestController

public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping(path = "/employee")
    public String greeting() {
        return "Hello";
    }

    @GetMapping(path = "/employee/add")
    public String addNewEmployee (@RequestParam(value = "firstName") String firstName,
                                  @RequestParam(value = "secondName") String secondName)  {

        Employee employee = new Employee(firstName, secondName);
        employeeService.addEmployee(employee);

        return "Сотрудник успешно добавлен! \n" + employeeService.show();
    }


}