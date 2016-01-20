package model;

import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

/**
 * Le model decrit les axes de criteres du composant
 * Chaque critere a 3 valeurs : valeur - Vmin - Vmax
 *
 */
public class KiviattModel implements TableModel {
    public static int N_DEF_CRITERES = 4;
    public static String[] DEF_CRITERES = {"c1", "c2", "c3", "c4"};
    public static int[][] DEF_VALEURS = {{1,0,10},{2,0,20},{3,0,30}, {4,0,40}}; // {valeur, vmin, vmax}

    String[] tab_criteres;
    int[][] valeur; // Exemple : valeur[0][] -> est le tableau des 3 valeurs qui correspondent au critère[0]


    public KiviattModel() {
        this(N_DEF_CRITERES, DEF_CRITERES, DEF_VALEURS);
    }

    public KiviattModel(int n_criteres, String[] criteres, int[][] tab_valeurs) {
        tab_criteres = new String[n_criteres];
        valeur = new int[n_criteres][3];

        // Renseignement
        tab_criteres = criteres;
        valeur = tab_valeurs; // 3 lignes de valeurs ; nombre de colonnes : n_criteres // Normalement int[][3]
    }

    public void showAllContent() {
        for(int i=0; i< tab_criteres.length; i++)
        {
            System.out.println("• "+tab_criteres[i]+":\n\tValeur= "+valeur[i][0]+ " Vmin= "+valeur[i][1]+
                    " Vmax= "+valeur[i][2] );
        }
    }

    public int getCriteriaNumber() {
        return tab_criteres.length;
    }

    @Override
    public int getRowCount() {
        return 3;
    }

    @Override
    public int getColumnCount() {
        return tab_criteres.length;
    }

    /**
     *
     * @param rowIndex On ne s'en sert pas, on prend la premiere case qui correspond à la valeur
     * @param columnIndex  le critere concerne
     * @return int valeur de l'axe
     */
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return valeur[columnIndex][0]; // On n'utilise pas rowIndex
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        valeur[columnIndex][0] = (Integer)aValue; // On n'utilise pas rowIndex
    }


    @Override
    public String getColumnName(int columnIndex) {
        return tab_criteres[columnIndex];
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return null;
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

    @Override
    public void addTableModelListener(TableModelListener l) {

    }

    @Override
    public void removeTableModelListener(TableModelListener l) {

    }
}
