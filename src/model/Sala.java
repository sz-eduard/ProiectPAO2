package model;

public class Sala {
    private   String numeSala;
    private   String Locatie;
    private   int nrTotalLocuri;
    private   int nrLocuriReducere;

    public int getNrTotalLocuri() {
        return nrTotalLocuri;
    }

    public Sala(String numeSala, String locatie, int nrTotalLocuri, int nrLocuriReducere) {
        this.numeSala = numeSala;
        Locatie = locatie;
        this.nrTotalLocuri = nrTotalLocuri;
        this.nrLocuriReducere = nrLocuriReducere;
    }

    public Sala() {
    }

    public String getNumeSala() {
        return numeSala;
    }

    public void setNumeSala(String numeSala) {
        this.numeSala = numeSala;
    }

    public String getLocatie() {
        return Locatie;
    }

    public void setLocatie(String locatie) {
        Locatie = locatie;
    }

    public int getNrLocuriReducere() {
        return nrLocuriReducere;
    }

    public void setNrLocuriReducere(int nrLocuriReducere) {
        this.nrLocuriReducere = nrLocuriReducere;
    }

    public void setNrTotalLocuri(int nrTotalLocuri) {
        this.nrTotalLocuri = nrTotalLocuri;
    }

    @Override
    public String toString() {
        return "Sala{" +
                "numeSala='" + numeSala + '\'' +
                ", Locatie='" + Locatie + '\'' +
                ", nrTotalLocuri=" + nrTotalLocuri +
                ", nrLocuriReducere=" + nrLocuriReducere +
                '}';
    }
}
