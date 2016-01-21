package gui;

import components.Item;
import components.Kiviatt;
import model.KiviattModel;

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

                String[] DEF_CRITERES = {"c1", "c2", "c3", "c4", "c5", "c6"};
                int[][] DEF_VALEURS = {{1,0,10},{2,0,20},{3,0,30}, {4,0,40}, {5,0,10}, {6,0,10}};



                KiviattModel kmo = new KiviattModel(DEF_CRITERES.length, DEF_CRITERES, DEF_VALEURS);


                Kiviatt km = new Kiviatt(kmo);
               // Item item = new Item();

                fenetre.add(km);
                //fenetre.add(item);

                km.setLocation(50, 50);
                km.setVisible(true);
                //item.setVisible(true);

            }
        });
    }

}

