package com.company;

import javax.swing.*;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

public class EmployeeTableSorter extends TableRowSorter {
    private JTable jTable;
    private EmployeeTableModel employeeTableModel;

    public EmployeeTableSorter(JTable jTable, EmployeeTableModel employeeTableModel) {
        this.jTable = jTable;
        this.employeeTableModel = employeeTableModel;
    }
}
