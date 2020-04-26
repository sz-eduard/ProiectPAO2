package repositories.spectacol;

import model.Spectacol;

import java.util.List;
import java.util.Optional;

public interface SpectacolRepositories {




    void addSpectacol(Spectacol spectacol);
    Optional<Spectacol> findSpectacolByNume(String nume);
    List<Spectacol> findSpectacolById(Integer id);
    public List<Spectacol> spectacoleToate();


    static SpectacolRepositories build(SpectacolRepositories.Type type) {
        switch (type) {
            //case DB: return new DBUserRepository();
            case FILE: return new FileSpectacolRepositories();
            case ARRAY:return new ArraySpectacolRepositories();
        }

        throw new RuntimeException("No such type");
    }

    enum Type {
        FILE, ARRAY //,DB
    }


}
