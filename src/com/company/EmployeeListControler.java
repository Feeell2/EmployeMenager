package com.company;

import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EmployeeListControler implements TableModelListener {


    private List<Employee> employeeList;

    private EmployeeTableModel employeeTableModel;
    public EmployeeListControler() {
        this.employeeList = new ArrayList<Employee>();
        this.employeeTableModel=new EmployeeTableModel(employeeList);
        employeeTableModel.addTableModelListener(this);
    }
    public List<Employee> getEmployeeList() {

         return employeeList;
    }

    public void setEmployeeList(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }

    public EmployeeTableModel getEmployeeTableModel() {
        return employeeTableModel;
    }

    public void setEmployeeTableModel(EmployeeTableModel employeeTableModel) {
        this.employeeTableModel = employeeTableModel;
    }

    public void addEmployee(String name, String surname, Position position, int seniority, int salary){
        employeeList.add(new Employee(name, surname, position, seniority, salary));
        updateList();
        System.out.println(employeeList.size());
    }
    public void removeEmployee(int index){
        employeeList.remove(index);
        updateList();
    }
    public void clearList(){
        employeeList.clear();
        updateList();
    }
    private void updateList(){
        System.out.println(employeeTableModel==null);
        if (employeeTableModel!=null){
            employeeTableModel.fireTableDataChanged();}

    }

    @Override
    public void tableChanged(TableModelEvent e) {
        int row =e.getFirstRow();
        int column=e.getColumn();
        TableModel model=(TableModel)e.getSource();
        String columnName=model.getColumnName(column+1);
        Object date=model.getValueAt(row,column);
    }

}
