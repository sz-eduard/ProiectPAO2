package repositories.actor;

import model.Actor;

import java.util.List;
import java.util.Optional;

public class ArrayActorRepositories implements ActorRepositories {

    private Actor[] actori = new Actor[10];
    private int n;
    @Override
    public void addActor(Actor actor) {
            actori[n]=actor;
            n++;
    }


    @Override
    public Optional<Actor> findActorByUsername(String nume) {

        for (int i = 0; i<n; i++) {
            if (actori[i].getNume().equals(nume)) {
                return Optional.of(actori[i]);
            }
        }
        return Optional.empty();


    }


    @Override
    public Optional<Actor> findActorByCNP(String cnp) {

        for (int i = 0; i<n; i++) {
            if (actori[i].getCnp() == cnp) {
                return Optional.of(actori[i]);
            }
        }
        return Optional.empty();
    }

    @Override
    public List<Actor> intoarceActori() {
        return null;
    }
}
