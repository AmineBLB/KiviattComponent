package controller;

import components.Kiviat;
import model.KiviatModel;

/**
 * Created by Mohamed-Amine on 26/01/2016.
 */
public class Controller {
    Kiviat kiviat;
    KiviatModel model;


    public Controller(Kiviat kiv) {
        kiviat = kiv;
        model = kiviat.getMonModel();
    }

    public void decrementerValeur(int row) {
        int temp = (Integer)model.getValueAt(row,1);
        temp--;
        model.setValueAt(temp + "", row,1);
        model.fireTableDataChanged();
    }
    public void incrementerValeur(int row) {
        int temp = (Integer)model.getValueAt(row,1);
        temp++;
        model.setValueAt(temp + "", row,1);
        model.fireTableDataChanged();
    }


}
