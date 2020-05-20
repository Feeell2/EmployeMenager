package com.company;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {

        SwingUtilities.invokeLater(
                ()->{
                    JFrame jFrame=new MyFrame();
                    jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    jFrame.setVisible(true);
                }
        );
    }
}
