package repositories.rezervari;

import model.Rezerva;

import java.util.ArrayList;
import java.util.List;

public class ArrayRezervareRepositories implements RezervareRepositories {

    List<Rezerva> rezervari=new ArrayList<>();


    @Override
    public void addRezervare(Rezerva rezervare) {
        rezervari.add(rezervare);
    }


}
