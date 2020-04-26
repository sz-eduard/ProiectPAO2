package model;

import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.Optional;

public class Actor {
    private String cnp;
    private String nume;
    private String prenume;
    private List<Integer> spectacolsJuacte;

    public Actor(String cnp, String nume, String prenume, List<Integer> spectacolsJuacte) {
        this.cnp = cnp;
        this.nume = nume;
        this.prenume = prenume;
        this.spectacolsJuacte = spectacolsJuacte;
    }

    public String getCnp() {
        return cnp;
    }

    public Actor() {
    }

    public void setCnp(String cnp) {
        this.cnp = cnp;
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

    public List<Integer> getSpectacolsJuacte() {
        return spectacolsJuacte;
    }

    public void setSpectacolsJuacte(List<Integer> spectacolsJuacte) {
        this.spectacolsJuacte = spectacolsJuacte;
    }
}
