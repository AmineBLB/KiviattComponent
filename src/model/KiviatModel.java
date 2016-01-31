package model;

import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;


public class KiviatModel extends DefaultTableModel {
    private ArrayList<AxeCritere> data; // Liste des valeurs
    private String[] columnNames = {"Critere", "Valeur", "Valeur Min","Valeur Max"}; // Intitule des colonnes

    private KiviatModel(ArrayList<AxeCritere> list) {
        data = list;
    }

    /**
     * Compte le nombre de criteres renseignes
     *
     * @return le nombre de criteres renseignes
     */
    @Override
    public int getRowCount() {
        if(data != null)
            return data.size();
        else
            return 0;
    }

    /**
     * Compte le <b>nombre de colonne</b>
     *
     * @return le nombre de colonne
     */
    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    /**
     * Recupere l'intitule d'une colonne
     *
     * @param column la position de la colonne
     * @return l'intitule de la colonne
     */
    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }

    /**
     * Interroge un champs d'un critere donne
     *
     * @param rowIndex    la position dans la liste du critere concerne
     * @param columnIndex le champs concerne [O: Nom, 1: Valeur, 2: Valeur Minimum, 3: Valeur Maximum]
     * @return objet correspondant a la ligne et la colonne passe en parametres
     */
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0: return data.get(rowIndex).getNom();
            case 1: return data.get(rowIndex).getValeur();
            case 2: return data.get(rowIndex).getValeurMin();
            case 3: return data.get(rowIndex).getValeurMax();
            default: return null;
        }

    }

    /**
     * Modifie un champs d'un critere donne
     *
     * @param row    la position dans la liste du critere concerne
     * @param column le champs concerne [O: Nom, 1: Valeur, 2: Valeur Minimum, 3: Valeur Maximum]
     */
    @Override
    public void setValueAt(Object aValue, int row, int column) {
        switch (column) {
            case 0: data.get(row).setNom((String)aValue); break;
            case 1: data.get(row).setValeur(Integer.parseInt((String)aValue)); break;
            case 2: data.get(row).setValeurMin(Integer.parseInt((String)aValue)); break;
            case 3: data.get(row).setValeurMax(Integer.parseInt((String)aValue)); break;
        }
    }

    /**
     * Verifier si le champs est modifiable
     * @param row la position dans la liste du critere concerne
     * @param column le champs concerne [O: Nom, 1: Valeur, 2: Valeur Minimum, 3: Valeur Maximum]
     * @return true si le champs est modifiable
     */
    @Override
    public boolean isCellEditable(int row, int column) {
        switch (column) {
            case 0 : return false;
            default: return true;
        }
    }

    /**
     * Ajouter un critere
     *
     * @param rowData nouveau critere a ajouter a la liste
     */
    public void ajoutCritere(AxeCritere rowData) {
        data.add(rowData);
    }

}
