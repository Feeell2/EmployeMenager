package com.company;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;
import java.util.List;

public class EmployeeTableModel extends AbstractTableModel {
    private EmployeeListControler listControler;
    private final List<Employee> employeeList;
    private final String[] columnNames={"name","surname","position","seniority","salary","delete"};
    private Class[] columnClass={String.class,String.class,Position.class,Integer.class,Integer.class,JButton.class};

    public EmployeeTableModel(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }




    @Override
    public int getRowCount() {
        return employeeList.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public String getColumnName(int column) {
        if (column==5) return "";
        return columnNames[column];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Employee employee=employeeList.get(rowIndex);
         switch (columnIndex){
             case 0:
                 return employee.getName();
             case 1:
                 return employee.getSurname();
             case 2:
                 return employee.getPosition();
             case 3:
                 return employee.getSeniority();
             case 4:
                 return employee.getSalary();
             case 5:
                 return new JButton(columnNames[columnIndex]);

         }
        return null;
    }
    public void setValueAt(Object value,int row,int col){
        Employee employee=employeeList.get(row);
        switch (col){
            case 0:
                employee.setName((String) value);
                break;
            case 1:
                employee.setSurname((String) value);
                break;
            case 2:
                employee.setPosition((Position) value);
                break;
            case 3:
                employee.setSeniority((Integer) value);
                break;
            case 4:
                employee.setSalary((Integer) value);
        }
    }
}
