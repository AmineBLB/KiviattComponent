package components;

import controller.Controller;
import model.AxeCritere;
import model.KiviatModel;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Arc2D;
import java.util.ArrayList;

/**
 * Created by Mohamed-Amine on 26/01/2016.
 */
public class Kiviat extends JComponent {
    public static int DEF_WIDTH = 300;
    public static int DEF_HEIGTH = DEF_WIDTH;
    public static int radius = DEF_WIDTH/2;
    public static final Dimension PREFERED_SIZE = new Dimension(DEF_WIDTH, DEF_HEIGTH);
    public static final Color[] TAB_COLOR = {Color.red, Color.blue, Color.yellow, Color.DARK_GRAY, Color.yellow, Color.ORANGE};

    private KiviatModel monModel;
    private Item[] valuesItem;
    private int[][] axeCoord;
    Controller cont;

    public Kiviat() {
        this(new KiviatModel(listeDefaultCriteres()));
    }

    public Kiviat(KiviatModel model) {
        monModel = model;
        valuesItem = new Item[monModel.getRowCount()];
        axeCoord = new int[monModel.getRowCount()][2]; // tableau de coordonnees [num critere] [x -> 0/y -> 1]
        cont = new Controller(this);
        preDrawingOperations();

        setLayout(null);
        setSize(PREFERED_SIZE);
        setVisible(true);
    }


    public KiviatModel getMonModel() {
        return monModel;
    }

    @Override
    public Dimension getPreferredSize() {
        return super.getPreferredSize();
    }

    @Override
    public void setBounds(int x, int y, int width, int height) {
        super.setBounds(x, y, width, height);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        System.out.println("Painting");

        Graphics2D g2 = (Graphics2D) g;
        int x0 = radius;
        int y0 = radius;

        g2.drawLine(DEF_HEIGTH, 0, 0, 0);
        g2.drawLine(0, DEF_HEIGTH, DEF_HEIGTH, DEF_HEIGTH);
        g2.drawLine(DEF_HEIGTH, DEF_HEIGTH, DEF_WIDTH, 0);
        g2.drawLine(0, 0, 0, DEF_HEIGTH);

        for (int i =0; i<monModel.getRowCount(); i++) {
            g2.setStroke(new BasicStroke(3, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
            g2.setColor(TAB_COLOR[i]);
            g2.drawLine(x0, y0, axeCoord[i][0], axeCoord[i][1]);
        }

    }

    public void preDrawingOperations() {
        int span = 360/monModel.getRowCount();
        int angle = 0;
        int x0 = radius;
        int y0 = radius;

        Double x1, y1;

        for (int i =0; i<monModel.getRowCount(); i++) {
            axeCoord[i][0] = (int) (radius *  Math.cos(Math.toRadians(angle))) + x0;
            axeCoord[i][1] = (int) (radius *  Math.sin(Math.toRadians(angle))) + y0;
            x1 = new Double(x0 + (axeCoord[i][0] - x0) * ((new Double((Integer)monModel.getValueAt(i, 1)) / (((new Double((Integer) monModel.getValueAt(i, 3)) - (new Double((Integer) monModel.getValueAt(i, 2)))))))));
            y1 = new Double(y0 + (axeCoord[i][1] - y0) * ((new Double((Integer)monModel.getValueAt(i, 1)) / (((new Double((Integer) monModel.getValueAt(i, 3)) - (new Double((Integer) monModel.getValueAt(i, 2)))))))));

            valuesItem[i] = new Item(
                    i,
                    (Integer) monModel.getValueAt(i,1),
                    angle,
                    x1.intValue(),
                    y1.intValue(),
                    cont);


            add(valuesItem[i]);
            valuesItem[i].setVisible(true);
            angle += span;
        }
    }

    public static ArrayList<AxeCritere> listeDefaultCriteres() {
        ArrayList<AxeCritere> data = new ArrayList<AxeCritere>();

        AxeCritere ac1 = new AxeCritere("Critere 1 : Red"   , 5,0,10);
        AxeCritere ac2 = new AxeCritere("Critere 2 : Blue"  , 5,0,20);
        AxeCritere ac3 = new AxeCritere("Critere 3 : Yellow", 15,0,30);
        AxeCritere ac4 = new AxeCritere("Critere 4 : Gray"  , 24,0,40);
        AxeCritere ac5 = new AxeCritere("Critere 5 : Yellow", 50,0,50);
        AxeCritere ac6 = new AxeCritere("Critere 6 : Orange", 55,0,60);


        data.add(ac1);
        data.add(ac2);
        data.add(ac3);
        data.add(ac4);
        data.add(ac5);
        data.add(ac6);

        return data;
    }
}
