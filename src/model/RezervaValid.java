package model;

public class RezervaValid extends  Rezerva {

    public float getPret() {
        return pret;
    }

    public void setPret(float pret) {
        this.pret = pret;
    }

    public RezervaValid(Spectacol spectacol, Client client, String data, String ora, float pret) {
        super(spectacol, client, data, ora);
        this.pret = pret;
    }

    private   float pret;
}
