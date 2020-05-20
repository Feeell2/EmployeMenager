package com.company;

public class Employee {
    private String name;
    private String surname;
    private Position position;
    private int seniority;
    private int salary;

    public Employee(String name, String surname, Position position, int seniority, int salary) {
        this.name = name;
        this.surname = surname;
        this.position = position;
        this.seniority = seniority;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public int getSeniority() {
        return seniority;
    }

    public void setSeniority(int seniority) {
        this.seniority = seniority;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", position=" + position +
                ", seniority=" + seniority +
                ", salary=" + salary +
                '}';
    }
}
