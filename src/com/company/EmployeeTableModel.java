package com.company;

import javax.swing.*;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

public class EmployeeTableModel extends AbstractTableModel{
    private EmployeeListControler listControler;
    private final List<Employee> employeeList;
    private final String[] columnNames = {"name", "surname", "position", "seniority", "salary", "delete"};
    private Class[] columnClass = {String.class, String.class, Position.class, Integer.class, Integer.class,JButton.class};

    public void setListControler(EmployeeListControler listControler) {
        this.listControler = listControler;
    }

    public EmployeeTableModel(List<Employee> employeeList) {
        this.employeeList = employeeList;


    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        if (columnIndex == 5) {
            return false;
        } else return true;
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
        if (column == 5) return "";
        return columnNames[column];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        if (employeeList.size()==0) return null;
        Employee employee = employeeList.get(rowIndex);
        switch (columnIndex) {
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
                JButton button=new JButton("delete");
                button.getActionListeners();
                button.addActionListener(arg-> {
                    listControler.removeEmployee(rowIndex);
                });
            return button;
        }
        return null;
    }
    public Class<?> getColumnClass(int column) {
        return columnClass[column];
    }

    public void setValueAt(Object value, int row, int col) {

        Employee employee = employeeList.get(row);
        switch (col) {
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
                employee.setSeniority(Integer.parseInt(value.toString()));
                break;
            case 4:
                employee.setSalary(Integer.parseInt(value.toString()));
        }

    }
}
class JTableButtonRenderer implements TableCellRenderer {
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        return (JButton) value;
    }
}
class JTableButtonMouseListener extends MouseAdapter {
    private final JTable table;

    public JTableButtonMouseListener(JTable table) {
        this.table = table;
    }

    public void mouseClicked(MouseEvent e) {
        int column = table.getColumnModel().getColumnIndexAtX(e.getX());
        int row = e.getY() / table.getRowHeight();
            Object value = table.getValueAt(row, column);
            if (value instanceof JButton) {
                ((JButton) value).doClick();
            }
        }
}


