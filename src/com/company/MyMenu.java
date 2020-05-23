package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

public class MyMenu extends JMenuBar {
    public MyMenu() {
        this.add(setMenu());
    }

    public JMenu setMenu(){
    JMenu jMenu=new JMenu("Menu");
    JMenuItem newFileItem=new JMenuItem("New");
    newFileItem.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("clikc");
            new EmployeeListControler().clearList();
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
