package gui;

import components.Kiviat;

import javax.swing.*;
import java.awt.*;

public class MainFrame  extends JFrame {


    public MainFrame() throws HeadlessException {
        this("Default Frame");


    }

    public MainFrame(String title) throws HeadlessException {
        super(title);
        setSize(900, 700);
        setVisible(true);
        setLayout(null);

    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                MainFrame fenetre = new MainFrame("Test Kiviatt");
                fenetre.setLayout(new BorderLayout());

                Kiviat monKiviat = new Kiviat();


                JTable table = new JTable(monKiviat.getMonModel());
                table.setSize(200,200);
                fenetre.add(new JScrollPane(table), BorderLayout.EAST);
                fenetre.add(monKiviat,BorderLayout.CENTER);


                /*
                String[] DEF_CRITERES = {"c1", "c2", "c3", "c4", "c5", "c6"};
                int[][] DEF_VALEURS = {{1,0,10},{2,0,20},{3,0,30}, {4,0,40}, {5,0,10}, {6,0,10}};



                Old_KiviattModel kmo = new Old_KiviattModel(DEF_CRITERES.length, DEF_CRITERES, DEF_VALEURS);
                //JTable table = new JTable(kmo);

                Kiviatt km = new Kiviatt(kmo);

               // Item item = new Item();

                //fenetre.add(new JScrollPane(table), BorderLayout.CENTER);
                fenetre.add(km, BorderLayout.NORTH);
                //table.setVisible(true);
                //fenetre.add(item);

                km.setLocation(50, 50);
                //table.setLocation(50, 400);

                km.setVisible(true);

                //item.setVisible(true);

                */

            }
        });
    }

}

