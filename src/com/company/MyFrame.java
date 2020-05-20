package com.company;

import javax.swing.*;
import java.awt.*;

public class MyFrame extends JFrame {
    MyMenu menu=new MyMenu();
    MyPanel panel=new MyPanel();
    Dimension screenDim=Toolkit.getDefaultToolkit().getScreenSize();
    public MyFrame() {
        this.setJMenuBar(menu);
        this.setLayout(new BorderLayout());
        this.add(panel,BorderLayout.NORTH);
        this.setSize(screenDim.width,screenDim.height);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(panel);
        this.pack();
        this.setVisible(true);
    }

}
