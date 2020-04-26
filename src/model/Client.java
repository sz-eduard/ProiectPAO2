package model;

public class Client {
    private   String nume;
    private   String prenume;
    private  String parola;
    private   TipClient tipClient;

    public Client() {
    }

    public String getParola() {
        return parola;
    }

    public void setParola(String parola) {
        this.parola = parola;
    }

    public Client(String nume, String parola, String prenume, TipClient tipClient) {
        this.nume = nume;
        this.parola = parola;
        this.prenume = prenume;
        this.tipClient = tipClient;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getPrenume() {
        return prenume;
    }

    public void setPrenume(String prenume) {
        this.prenume = prenume;
    }

    public TipClient getTipClient() {
        return tipClient;
    }

   // public void setTipClient(String tipClient) {
    //     //   this.tipClient = tipClient;
    //    //}


    public void setTipClient(TipClient tipClient) {
        this.tipClient = tipClient;
    }

    @Override
    public String toString() {
        return "Client{" +
                "nume='" + nume + '\'' +
                ", prenume='" + prenume + '\'' +
                ", parola='" + parola + '\'' +
                ", tipClient=" + tipClient +
                '}';
    }
}

