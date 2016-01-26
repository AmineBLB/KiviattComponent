package test;

import model.AxeCritere;
import model.Old_KiviattModel;

import java.util.ArrayList;

public class Test {



    public ArrayList<AxeCritere> preparerListeCriteres() {
        ArrayList<AxeCritere> data = new ArrayList<AxeCritere>();

        AxeCritere ac1 = new AxeCritere("Critere 1", 1,0,10);
        AxeCritere ac2 = new AxeCritere("Critere 2", 2,0,20);
        AxeCritere ac3 = new AxeCritere("Critere 3", 3,0,30);
        AxeCritere ac4 = new AxeCritere("Critere 4", 4,0,40);
        AxeCritere ac5 = new AxeCritere("Critere 5", 5,0,50);
        AxeCritere ac6 = new AxeCritere("Critere 6", 6,0,60);


        data.add(ac1);
        data.add(ac2);
        data.add(ac3);
        data.add(ac4);
        data.add(ac5);
        data.add(ac6);

        return data;
    }

    public static void main(String[] args) {

        // Tests avec des listes renseignés
        String[] DEF_CRITERES = {"c1", "c2", "c3", "c4", "c1", "c2", "c3", "c4"};
        int[][] DEF_VALEURS = {{1,0,10},{2,0,20},{3,0,30}, {4,0,40}, {1,0,10},{2,0,20},{3,0,30}, {4,0,40}};



        Old_KiviattModel km = new Old_KiviattModel(DEF_CRITERES.length, DEF_CRITERES, DEF_VALEURS);
        km.setValueAt(5,20,0);
        km.showAllContent();


    }
}
