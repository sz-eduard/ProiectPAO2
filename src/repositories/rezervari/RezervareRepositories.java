package repositories.rezervari;

import model.Rezerva;
import repositories.actor.ActorRepositories;

public interface RezervareRepositories {

    void addRezervare(Rezerva rezervare);


    static RezervareRepositories build(RezervareRepositories.Type type) {
        switch (type) {
            //case DB: return new DBUserRepository();
            case FILE: return new FileRezervareRepositories();
            case ARRAY:return new ArrayRezervareRepositories();
        }

        throw new RuntimeException("No such type");
    }

    enum Type {
        FILE, ARRAY //,DB
    }


}
