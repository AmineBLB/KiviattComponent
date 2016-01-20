package model;

import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

public class KiviattModel implements TableModel {
    public static int N_DEF_CRITERES = 4;
    public static String[] DEF_CRITERES = {"c1", "c2", "c3", "c4"};
    public static int[][] DEF_VALEURS = {{1,0,10},{2,0,20},{3,0,30}, {4,0,40}}; // {valeur, vmin, vmax}

    String[] tab_criteres;
    int[][] valeur;


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
        return 0;
    }

    /**
     *
     * @param rowIndex le critere concerne
     * @param columnIndex ne sert à rien, on prend la premiere case qui correspond à la valeur
     * @return
     */
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return valeur[rowIndex][0];
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        valeur[columnIndex][0] = (Integer)aValue; // On utilise pas rowIndex
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
