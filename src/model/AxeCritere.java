package model;

/**
 * Created by Mohamed-Amine on 26/01/2016.
 */
public class AxeCritere {
    private String nom;
    private int valeur;
    private int valeurMin;
    private int valeurMax;


    public AxeCritere(String nom, int valeur, int valeurMin, int valeurMax) {
        this.nom = nom;
        this.valeur = valeur;
        this.valeurMin = valeurMin;
        this.valeurMax = valeurMax;
    }

    public String getNom() {
        return nom;
    }

    public int getValeur() {
        return valeur;
    }

    public int getValeurMin() {
        return valeurMin;
    }

    public int getValeurMax() {
        return valeurMax;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setValeur(int valeur) {
        this.valeur = valeur;
    }

    public void setValeurMin(int valeurMin) {
        this.valeurMin = valeurMin;
    }

    public void setValeurMax(int valeurMax) {
        this.valeurMax = valeurMax;
    }
}
