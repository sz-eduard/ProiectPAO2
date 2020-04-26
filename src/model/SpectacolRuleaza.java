package model;

import java.util.List;

public class SpectacolRuleaza extends Spectacol {

    private   String data;
    private   String ora;
    private   Sala sala;

    public SpectacolRuleaza() {

    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public Sala getSala() {
        return sala;
    }

    public void setSala(Sala sala) {
        this.sala = sala;
    }

    public String getOra() {
        return ora;
    }

    public SpectacolRuleaza(String data, String ora, Sala sala) {
        this.data = data;
        this.ora = ora;
        this.sala = sala;
    }

    public SpectacolRuleaza(int idSpectacol, String numeSpectacol, List<String> distributieActori, String data, String ora, Sala sala) {
        super(idSpectacol, numeSpectacol, distributieActori);
        this.data = data;
        this.ora = ora;
        this.sala = sala;
    }

    @Override
    public String toString() {
        return "SpectacolRuleaza{" +
                "data='" + data + '\'' +
                ", ora='" + ora + '\'' +
                ", sala=" + sala +
                '}';
    }

    public void setOra(String ora) {
        this.ora = ora;
    }


}
