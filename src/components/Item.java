package components;


import javax.swing.*;
import java.awt.*;

public class Item extends JComponent {
    public static int DEF_WIDTH = 10;
    public static int DEF_HEIGTH = DEF_WIDTH;
    public static final Dimension PREFERED_SIZE = new Dimension(DEF_WIDTH, DEF_HEIGTH);

    private int valeur;
    public int angleDirecteur;
    public int coordX, coordY;
    private ItemMouseAdapter myAdapter;

    public Item(int val, int angle, int x2, int y2) {
        super();
        setSize(PREFERED_SIZE);
        setLayout(null);

        valeur = val;
        angleDirecteur = angle;
        coordX = x2;
        coordY = y2;

        myAdapter = new ItemMouseAdapter(this);
        addMouseListener(myAdapter);
        addMouseMotionListener(myAdapter);
        setLocation(coordX, coordY);

    }

    public int getValeur() {
        return valeur;
    }

    public void setCoord(int x, int y) {
        coordX = x;
        coordY = y;
    }

    public void decrementerX() {
        coordX --;
    }
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.fillOval(0, 0, DEF_WIDTH, DEF_HEIGTH);
    }

    @Override
    public void setBounds(int x, int y, int width, int height) {
        super.setBounds(x, y, width, height);
    }

    @Override
    public Dimension getPreferredSize() {
        return PREFERED_SIZE;
    }

    @Override
    public void setLocation(int x, int y) {
        x -= DEF_WIDTH/2;
        y -= DEF_HEIGTH/2;
        super.setLocation(x, y);

    }

    public void setCoordY(int i) {
        coordY = i;
    }
}
