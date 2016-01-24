package components;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ItemMouseAdapter extends MouseAdapter {

    private Item myItem;
    int previousX, previousY;

    public ItemMouseAdapter(Item item) {
        myItem = item;
    }

    @Override
    public void mousePressed(MouseEvent e) {
        super.mousePressed(e);
        previousX = e.getX();
        previousY = e.getY();
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        super.mouseDragged(e);

        System.out.println("Dragging item");

        int x = e.getX();
        int y = e.getY();


        myItem.setLocation(x,
                (int)Math.tan(Math.toRadians(myItem.angleDirecteur))*x);

    }
}
