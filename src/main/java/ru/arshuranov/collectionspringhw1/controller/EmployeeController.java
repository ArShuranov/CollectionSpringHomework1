package ru.arshuranov.collectionspringhw1.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.arshuranov.collectionspringhw1.exception.EmployeeNotFoundException;
import ru.arshuranov.collectionspringhw1.service.Employee;
import ru.arshuranov.collectionspringhw1.service.EmployeeService;


@RequestMapping("/employee")
@RestController

public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    public String greeting() {
        return "Hello";
    }

    @GetMapping(path = "/add")
    public String addEmployee(@RequestParam(value = "firstName") String firstName,
                              @RequestParam(value = "lastName") String lastName) {

        employeeService.addEmployee(firstName, lastName);

        return "Сотрудник успешно добавлен! \n" + employeeService.show();
    }

    @GetMapping("/find")
    public String findEmployee(@RequestParam("firstName") String firstName,
                               @RequestParam("lastName") String lastName) {
        try {
            return employeeService.findEmployee(firstName, lastName);
        } catch (EmployeeNotFoundException e) {
            return "EmployeeNotFound";
        }
    }


    @GetMapping("/remove")
    public String removeEmployee(@RequestParam("firstName") String firstName,
                                 @RequestParam("lastName") String lastName) {

        employeeService.removeEmployee(firstName, lastName);

        return "Сотрудник удален" + employeeService.show();
    }


}