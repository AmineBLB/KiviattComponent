package components;

import controller.Controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ItemMouseAdapter extends MouseAdapter {

    private Item myItem;
    int previousX, previousY;
    Controller controller;

    public ItemMouseAdapter(Item item, Controller cont) {
        myItem = item;
        controller = cont;
    }

    @Override
    public void mousePressed(MouseEvent e) {
        super.mousePressed(e);
        previousX = e.getX();
        previousY = e.getY();

        System.out.println("> Previous coordinates :"+previousX+", "+previousY);
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        super.mouseDragged(e);


        int x = e.getX();
        int y = e.getY();
        System.out.println("----------------------------");
        System.out.println("Dragging item : X="+myItem.coordX+", y="+myItem.coordY);
        System.out.println("Angle : "+myItem.angleDirecteur);
        System.out.println("----------------------------");

        //myItem.setCoord(x,
        //        (int)Math.tan(Math.toRadians(myItem.angleDirecteur))*x);

        if(x < previousX)
        {
            myItem.coordX --;
            controller.decrementerValeur(myItem.getIdAxe());

        }
        else
        {
            myItem.coordX ++;
            controller.incrementerValeur((myItem.getIdAxe()));
        }


        myItem.coordY = ((int)Math.tan(Math.toRadians(myItem.angleDirecteur))*myItem.coordX) + Kiviat.radius;
        myItem.setLocation(myItem.coordX, myItem.coordY);

        //myItem.setLocation(x,
        //        (int)Math.tan(Math.toRadians(myItem.angleDirecteur))*x);

    }
}
