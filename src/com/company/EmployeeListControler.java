package com.company;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeListControler {


    private List<Employee> employeeList;

    public EmployeeListControler() {
        this.employeeList = new ArrayList<Employee>();
    }
    public List<Employee> getEmployeeList() {
        return employeeList;
    }
    public void addEmployee(String name,String surname,Position position,int seniority,int salary){
        employeeList.add(new Employee(name, surname, position, seniority, salary));
    }
    public void removeEmployee(int index){
        employeeList.remove(index);
    }
}
