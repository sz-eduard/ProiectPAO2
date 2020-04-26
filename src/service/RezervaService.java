package service;

import model.Rezerva;
import repositories.client.ClientRepositories;
import repositories.rezervari.RezervareRepositories;

public class RezervaService
{
    RezervareRepositories rezervareRepository = RezervareRepositories.build(RezervareRepositories.Type.FILE);

    public void adaugaRezervare(Rezerva rezervare)
    {
            rezervareRepository.addRezervare(rezervare);

    }


}
