package components;

import model.KiviattModel;

import javax.swing.*;
import java.awt.*;

public class Kiviatt extends JComponent {
    public static int DEF_WIDTH = 300;
    public static int DEF_HEIGTH = DEF_WIDTH;
    public static int radius = DEF_WIDTH/2;
    public static final Dimension PREFERED_SIZE = new Dimension(DEF_WIDTH, DEF_HEIGTH);
    public static final Color[] TAB_COLOR = {Color.red, Color.blue, Color.yellow, Color.DARK_GRAY, Color.yellow, Color.ORANGE};



    private KiviattModel myModel;
    private int criteriaNumber;
    private int valueOnCriteria[];
    private Item[] valueDisplay;

    public Kiviatt() {
        this(new KiviattModel());

    }

    public Kiviatt(KiviattModel km) {
        myModel = km;
        criteriaNumber = km.getCriteriaNumber();
        valueOnCriteria = new int[criteriaNumber];
        valueDisplay = new Item[criteriaNumber];
        renseignerValeurAxe();
        setLayout(null);
        setSize(PREFERED_SIZE);

    }

    public void renseignerValeurAxe() {
        for (int i=0; i<criteriaNumber; i++)
        {
            valueOnCriteria[i] = (Integer) myModel.getValueAt(10000, i);
        }
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
        Graphics2D g2 = (Graphics2D) g;

        int span = 360/criteriaNumber;
        int angle = 0;

        int x0 = radius ;
        int y0 = radius;
        int x2, y2;

        g2.drawLine(0, 0, DEF_WIDTH, 0);
        g2.drawLine(0, 0, 0, DEF_HEIGTH);

        for(int i=0; i<criteriaNumber; i++)
        {
            x2 = (int) (radius *  Math.cos(Math.toRadians(angle))) + x0;
            y2 = (int) (radius *  Math.sin(Math.toRadians(angle))) + y0;

            System.out.println(i+") • ["+x0+","+y0+"] - ["+x2+","+y2+"] - angle= "+angle);

            g2.setStroke(new BasicStroke(3, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
            g2.setColor(TAB_COLOR[i]);
            g2.drawLine(x0, y0, x2, y2);

            valueDisplay[i] = new Item(valueOnCriteria[i]);
            add(valueDisplay[i]);
            valueDisplay[i].setLocation(x0 + (x2 - x0) / 2, y0 + (y2 - y0) / 2);
            valueDisplay[i].setVisible(true);


            angle += span;
        }

    }
}
