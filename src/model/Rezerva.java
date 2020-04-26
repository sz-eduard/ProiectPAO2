package model;

public class Rezerva {

    private   Spectacol spectacol;
    private   Client client;
    private   String data;
    private   String ora;

    public Rezerva(Spectacol spectacol, Client client, String data, String ora) {
        this.spectacol = spectacol;
        this.client = client;
        this.data = data;
        this.ora = ora;
    }

    public Spectacol getSpectacol() {
        return spectacol;
    }

    public void setSpectacol(Spectacol spectacol) {
        this.spectacol = spectacol;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getOra() {
        return ora;
    }

    public void setOra(String ora) {
        this.ora = ora;
    }



}
