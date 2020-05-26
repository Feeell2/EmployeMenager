package com.company;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileSave {
    private EmployeeTableModel employeeTableModel;


    public FileSave(EmployeeTableModel employeeTableModel) {
        this.employeeTableModel=employeeTableModel;
    }
    public void saveData(){
        File file= new File("data.txt");
        try{
            FileWriter fw=new FileWriter(file);
            BufferedWriter bw=new BufferedWriter(fw);

            for (int i = 0; i <employeeTableModel.getRowCount() ; i++) {
                for (int j = 0; j <employeeTableModel.getColumnCount()-1 ; j++) {
                    bw.write(employeeTableModel.getValueAt(i,j).toString()+" ");
                }
                bw.newLine();
            }
            bw.close();
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
