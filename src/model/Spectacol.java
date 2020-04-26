package model;

import java.util.List;

public class Spectacol {
    private int idSpectacol;
    private   String numeSpectacol;
    private List<String> distributieActori;



    public Spectacol() {
    }

    public int getIdSpectacol() {
        return idSpectacol;
    }

    public void setId(int id) {
        this.idSpectacol
                    = id;
    }

    public String getNumeSpectacol() {
        return numeSpectacol;
    }



    public void setNumeSpectacol(String numeSpectacol) {
        this.numeSpectacol = numeSpectacol;
    }

    public void setIdSpectacol(int idSpectacol) {
        this.idSpectacol = idSpectacol;
    }

    public Spectacol(int idSpectacol, String numeSpectacol, List<String> distributieActori) {
        this.idSpectacol = idSpectacol;
        this.numeSpectacol = numeSpectacol;
        this.distributieActori = distributieActori;
    }

    public List<String> getDistributieActori() {
        return distributieActori;
    }

    public void setDistributieActori(List<String> distributieActori) {
        this.distributieActori = distributieActori;
    }
}
