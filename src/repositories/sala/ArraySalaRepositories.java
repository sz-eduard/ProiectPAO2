package repositories.sala;

import model.Sala;

import java.util.Optional;

public class ArraySalaRepositories implements SalaRepositories {

    private Sala[] sali = new Sala[10];
    private int n;

    @Override
    public void addSala(Sala sala) {
        sali[n] = sala;
        n++;
    }

    @Override
    public Optional<Sala> findSalaByNume(String nume) {
        for (int i = 0; i<n; i++) {
            if (sali[i].getNumeSala().equals(nume)) {
                return Optional.of(sali[i]);
            }
        }
        return Optional.empty();
    }


}
