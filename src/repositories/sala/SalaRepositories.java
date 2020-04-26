package repositories.sala;

import model.Sala;

import java.util.Optional;

public interface SalaRepositories {

    void addSala(Sala sala);
    Optional<Sala> findSalaByNume(String nume);

    static SalaRepositories build(SalaRepositories.Type type) {
        switch (type) {
            //case DB: return new DBUserRepository();
            //case FILE: return new FileUserRepository();
            case ARRAY:return new ArraySalaRepositories();
        }

        throw new RuntimeException("No such type");
    }

    enum Type {
        DB, FILE, ARRAY
    }

}
