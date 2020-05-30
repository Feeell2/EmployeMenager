package com.company;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class ReadFile {
    private EmployeeListControler employeeListControler;

    public ReadFile(EmployeeListControler employeeListControler) {
        this.employeeListControler = employeeListControler;
    }
    public void readFile(String filePatch){
        try {
            FileReader fr=new FileReader(filePatch);
            BufferedReader br=new BufferedReader(fr);
            Object[] lines=br.lines().toArray();
            for (int i = 0; i <lines.length ; i++) {
                   String[] row= lines[i].toString().split(" ");
                   employeeListControler.addEmployee(row[0],row[1],Position.valueOf(row[2]),Integer.parseInt(row[3]),Integer.parseInt(row[4]));
            }

        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(new JFrame(),
                    "The file contains an error",
                    "Error",
                    JOptionPane.YES_OPTION);
            e.printStackTrace();
        }
    }

}
