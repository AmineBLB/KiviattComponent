package test;

import model.KiviattModel;

public class Test {
    public static void main(String[] args) {

        // Tests avec des listes renseignés
        String[] DEF_CRITERES = {"c1", "c2", "c3", "c4", "c1", "c2", "c3", "c4"};
        int[][] DEF_VALEURS = {{1,0,10},{2,0,20},{3,0,30}, {4,0,40}, {1,0,10},{2,0,20},{3,0,30}, {4,0,40}};



        KiviattModel km = new KiviattModel(DEF_CRITERES.length, DEF_CRITERES, DEF_VALEURS);
        km.setValueAt(5,20,0);
        km.showAllContent();


    }
}
