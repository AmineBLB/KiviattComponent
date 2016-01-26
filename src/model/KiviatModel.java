package model;

import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;
import java.util.Vector;

/**
 * Created by Mohamed-Amine on 26/01/2016.
 */
public class KiviatModel extends DefaultTableModel {
    public ArrayList<AxeCritere> data;
    public String[] columnNames = {"Critere", "Valeur", "Valeur Min","Valeur Max"};

    public KiviatModel(ArrayList<AxeCritere> list) {
        data = list;
    }

    @Override
    public int getRowCount() {
        if(data != null)
            return data.size();
        else
            return 0;
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }

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

    @Override
    public void setValueAt(Object aValue, int row, int column) {
        switch (column) {
            case 0: data.get(row).setNom((String)aValue); break;
            case 1: data.get(row).setValeur(Integer.parseInt((String)aValue)); break;
            case 2: data.get(row).setValeurMin(Integer.parseInt((String)aValue)); break;
            case 3: data.get(row).setValeurMax(Integer.parseInt((String)aValue)); break;
        }
    }

    @Override
    public boolean isCellEditable(int row, int column) {
        switch (column) {
            case 0 : return false;
            default: return true;
        }
    }

    public void ajoutCritere(AxeCritere rowData) {
        data.add(rowData);
    }

}
