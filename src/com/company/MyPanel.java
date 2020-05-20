package com.company;

import javax.swing.*;
import javax.swing.table.TableModel;
import java.awt.*;
import java.util.List;

public class MyPanel extends JPanel {
    private JTable employeeTable;
    private EmployeeTableModel employeeTableModel;
    private EmployeeListControler listControler;

    public MyPanel() {

        this.setLayout(new BorderLayout());
        this.add(addSortPanel(),BorderLayout.PAGE_START);
        this.add(employeeTable(),BorderLayout.CENTER);
    }
    private JPanel addSortPanel(){
        JPanel addSortEmployees=new JPanel();
        addSortEmployees.setLayout(new FlowLayout());
        addSortEmployees.setPreferredSize(new Dimension(300,30));
        addSortEmployees.setMaximumSize(new Dimension(300,30));
        addSortEmployees.add(addEmployeeBtn());
        addSortEmployees.add(new JLabel("Sort:  "));
        addSortEmployees.add(sortEmployee());
        return addSortEmployees;
    }

    private JButton addEmployeeBtn(){
        JButton btn=new JButton("Add Employee");
        btn.setSize(50,30);
        return btn;
    }
    private JTextField sortEmployee(){
        JTextField sortInput=new JTextField();
        sortInput.setPreferredSize(new Dimension(300,30));
        return sortInput;
    }
    private JScrollPane employeeTable(){
        employeeTable=new JTable(new EmployeeTableModel(new EmployeeListControler().getEmployeeList()));
        JScrollPane scrollPane=new JScrollPane(employeeTable);
        return scrollPane;
    }



}
