package repositories.spectacol;

import model.Spectacol;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ArraySpectacolRepositories implements SpectacolRepositories {
    private Spectacol[] spectacole = new Spectacol[10];
    private int n;

    @Override
    public void addSpectacol(Spectacol spectacol) {

        spectacole[n] = spectacol;
        n++;

    }

    @Override
    public List<Spectacol> findSpectacolById(Integer id) {
        for (int i = 0; i<n; i++) {
            if (spectacole[i].getIdSpectacol()==id) {
                return (List<Spectacol>) spectacole[i];
            }
        }
        return null;
    }



    @Override
    public Optional<Spectacol> findSpectacolByNume(String nume) {
        for (int i = 0; i<n; i++) {
            if (spectacole[i].getNumeSpectacol().equals(nume)) {
                return Optional.of(spectacole[i]);
            }
        }
        return Optional.empty();
    }

    public List<Spectacol> spectacoleToate(){

        List<Spectacol> spc =new ArrayList<>();

        for(Spectacol s: spectacole)
            spc.add(s);
        return spc;


    }


}



