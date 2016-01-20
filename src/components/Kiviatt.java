package components;

import model.KiviattModel;

import javax.swing.*;
import java.awt.*;

public class Kiviatt extends JComponent {
    public static int DEF_WIDTH = 300;
    public static int DEF_HEIGTH = DEF_WIDTH;
    public static int radius = DEF_WIDTH/2;
    public static final Dimension PREFERED_SIZE = new Dimension(DEF_WIDTH, DEF_HEIGTH);
    public static final Color[] TAB_COLOR = {Color.red, Color.blue, Color.yellow, Color.DARK_GRAY, Color.yellow};



    private KiviattModel myModel;
    private int criteriaNumber;
    private int valueOnCriteria[];

    public Kiviatt() {
        this(new KiviattModel());

    }

    public Kiviatt(KiviattModel km) {
        myModel = km;
        criteriaNumber = km.getCriteriaNumber();
        valueOnCriteria = new int[criteriaNumber];
        renseignerValeurAxe();
        setLayout(null);
        setSize(PREFERED_SIZE);

    }

    public void renseignerValeurAxe() {
        for (int i=0; i<criteriaNumber; i++)
        {
            valueOnCriteria[i] = (Integer) myModel.getValueAt(i, 10000);
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
            x2 = radius * (int) (Math.cos(Math.toRadians(angle))) + x0 ;
            y2 = radius * (int) (Math.sin(Math.toRadians(angle))) + y0 ;

            System.out.println("[0,0] - ["+x2+","+y2+"]");

            g2.setStroke(new BasicStroke(3, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
            g2.setColor(TAB_COLOR[i]);
            g2.drawLine(x0, y0, x2, y2);


            System.out.println("Angle=" + angle + " Span=" +span);

            angle += span;
        }

    }
}
