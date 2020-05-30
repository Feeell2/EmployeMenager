package com.company;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

public class MyPanel extends JPanel{
    private EmployeeTableModel employeeTableModel;
    private EmployeeListControler listControler;
    private FileSave fileSave;
    private ReadFile readFile;
    private TableRowSorter<EmployeeTableModel> tableRowSorter;
    private JTable employeeTable;

    public MyPanel() {
        initTable();
        initHandlingFile();
        employeeTable.setAutoCreateRowSorter(true);
        tableRowSorter=new TableRowSorter<EmployeeTableModel>(employeeTableModel);
        employeeTable.setRowSorter(tableRowSorter);

        this.setLayout(new BorderLayout());
        this.add(addSortPanel(),BorderLayout.PAGE_START);
        this.add(new JScrollPane(employeeTable),BorderLayout.CENTER);
    }
    private void initTable(){
        this.listControler=new EmployeeListControler();
        this.employeeTableModel=new EmployeeTableModel(listControler.getEmployeeList());
        listControler.setEmployeeTableModel(employeeTableModel);
        this.employeeTableModel.setListControler(listControler);
        this.employeeTable=new JTable(employeeTableModel);


        // adding comboBox
        TableColumn positonColumn=employeeTable.getColumnModel().getColumn(2);
        JComboBox<Position> comboBox=new JComboBox<>();
        comboBox.setModel(new DefaultComboBoxModel<>(Position.values()));
        positonColumn.setCellEditor(new DefaultCellEditor(comboBox));
        //add delete buttons
        employeeTable.addMouseListener(new JTableButtonMouseListener(employeeTable));
        TableColumn buttonsColumn=employeeTable.getColumnModel().getColumn(5);
        buttonsColumn.setCellRenderer(new JTableButtonRenderer());

    }
    private void initHandlingFile(){
        this.fileSave=new FileSave(employeeTableModel);
        this.readFile=new ReadFile(listControler);
    }
    private JPanel addSortPanel(){
        JPanel addSortEmployees=new JPanel();
        addSortEmployees.setLayout(new FlowLayout());
        addSortEmployees.setPreferredSize(new Dimension(300,30));
        addSortEmployees.setMaximumSize(new Dimension(300,30));
        addSortEmployees.add(addEmployeeBtn());
        addSortEmployees.add(new JLabel("Sort:  "));
        addSortEmployees.add(filterField());
        return addSortEmployees;
    }

    private JButton addEmployeeBtn(){
        JButton btn=new JButton("Add Employee");
        btn.setSize(50,30);
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                listControler.addEmployee("","",Position.Intern,0,0);
            }
        });
        return btn;
    }
    private JTextField filterField(){
        JTextField textField=new JTextField();
        textField.setPreferredSize(new Dimension(300,20));
        textField.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                System.out.println(textField.getText());
                newFilter(textField.getText());
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                newFilter(textField.getText());

            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                newFilter(textField.getText());

            }
        });

        return textField;
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
//        JMenuItem openFileItem=new JMenuItem("Open");
////    openFileItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, ActionEvent.CTRL_MASK));
        JMenuItem saveFile=new JMenuItem("Save");
        saveFile.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fileSave.saveData();

            }
        });
        jMenu.add(openFile());
        jMenu.add(newFileItem);
        jMenu.add(saveFile);
        return jMenu;
    };
    public JMenuItem openFile(){
        JMenuItem item=new JMenuItem("Open");
        JFileChooser fileChooser=new JFileChooser();
        item.addActionListener(event->{
            int code=fileChooser.showOpenDialog(new MyPanel() );
            if(code==JFileChooser.APPROVE_OPTION){
                String path=fileChooser.getSelectedFile().getPath();
                readFile.readFile(path);
            }
        });
        return item;
    }
    private void newFilter(String text){
    RowFilter<EmployeeTableModel,Object> rf=null;
        if(text.length()==0){
            tableRowSorter.setRowFilter(null);
        }
        else if (text.charAt(0)=='<'){
                int number=Integer.parseInt(text.replaceFirst("<","0"));
                rf=RowFilter.numberFilter(RowFilter.ComparisonType.AFTER,number,4);

        }
        else if (text.charAt(0)=='>'){
            int number=Integer.parseInt(text.replaceFirst(">","0"));
            rf=RowFilter.numberFilter(RowFilter.ComparisonType.BEFORE,number,4);

        }else {
            rf=RowFilter.regexFilter(text,0,1,2,3,4);
        }


    tableRowSorter.setRowFilter(rf);
    }
}
