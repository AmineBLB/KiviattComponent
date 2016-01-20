package gui;

import components.Kiviatt;

import javax.swing.*;
import java.awt.*;

public class MainFrame  extends JFrame {


    public MainFrame() throws HeadlessException {
        this("Default Frame");


    }

    public MainFrame(String title) throws HeadlessException {
        super(title);
        setSize(500, 500);
        setVisible(true);
        setLayout(null);

    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                MainFrame fenetre = new MainFrame("Test Kiviatt");
                Kiviatt km = new Kiviatt();
                fenetre.add(km);
                km.setLocation(50, 50);
                km.setVisible(true);

            }
        });
    }

}

