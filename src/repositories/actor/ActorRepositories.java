package repositories.actor;

import model.Actor;

import java.util.List;
import java.util.Optional;

public interface ActorRepositories {

    void addActor(Actor actor);
    Optional<Actor> findActorByUsername(String nume);
    Optional<Actor> findActorByCNP(String cnp);
    public List<Actor> intoarceActori();

    static ActorRepositories build(ActorRepositories.Type type) {
        switch (type) {
            //case DB: return new DBUserRepository();
            case FILE: return new FileActorRepositories();
            case ARRAY:return new ArrayActorRepositories();
        }

        throw new RuntimeException("No such type");
    }

    enum Type {
        FILE, ARRAY //,DB
    }

}
