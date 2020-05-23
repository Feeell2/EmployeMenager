package com.company;

import javax.swing.*;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.util.List;

public class MyPanel extends JPanel{
    private EmployeeTableModel employeeTableModel;
    private EmployeeListControler listControler;

    public MyPanel() {
        this.listControler=new EmployeeListControler();
        this.employeeTableModel=new EmployeeTableModel(listControler.getEmployeeList());
        listControler.setEmployeeTableModel(employeeTableModel);
        this.employeeTableModel.setListControler(listControler);
        JTable employeeTable=new JTable(employeeTableModel);

        employeeTable.addMouseListener(new JTableButtonMouseListener(employeeTable));
        TableColumn positonColumn=employeeTable.getColumnModel().getColumn(2);
        JComboBox<Position> comboBox=new JComboBox<>();
        comboBox.setModel(new DefaultComboBoxModel<>(Position.values()));
        positonColumn.setCellEditor(new DefaultCellEditor(comboBox));
        TableColumn buttonsColumn=employeeTable.getColumnModel().getColumn(5);
        buttonsColumn.setCellRenderer(new JTableButtonRenderer());

        this.setLayout(new BorderLayout());
        this.add(addSortPanel(),BorderLayout.PAGE_START);
        this.add(new JScrollPane(employeeTable),BorderLayout.CENTER);
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
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                listControler.addEmployee("","",Position.Lead,0,0);
            }
        });
        return btn;
    }
    private JTextField sortEmployee(){
        JTextField sortInput=new JTextField();
        sortInput.setPreferredSize(new Dimension(300,30));
        return sortInput;
    }
    public JMenuBar initMenuBar(){
        JMenuBar menuBar=new JMenuBar();
        menuBar.add(setMenu());
        return menuBar;
    }
    public JMenu setMenu(){
        JMenu jMenu=new JMenu("Menu");
        JMenuItem newFileItem=new JMenuItem("New");
        newFileItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("clikc");
                listControler.clearList();
            }
        });
        JMenuItem openFileItem=new JMenuItem("Open");
//    openFileItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, ActionEvent.CTRL_MASK));
        JMenuItem saveFile=new JMenuItem("Save");
        jMenu.add(openFileItem);
        jMenu.add(newFileItem);
        jMenu.add(saveFile);
        return jMenu;
    };

}
