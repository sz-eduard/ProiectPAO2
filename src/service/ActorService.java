package service;

import model.Actor;
import model.Spectacol;
import model.SpectacolRuleaza;
import repositories.actor.ActorRepositories;
import repositories.client.ClientRepositories;
import repositories.spectacol.SpectacolRepositories;

import java.nio.file.Files;
import java.util.List;
import java.util.Optional;

public class ActorService {
    private ActorRepositories actorRepository;

    public ActorService(){

        actorRepository = ActorRepositories.build(ActorRepositories.Type.FILE);


    }
    public void afiseazaActori(){
        List<Actor> actori=actorRepository.intoarceActori();
        for(Actor a: actori)
            System.out.println(a.getNume()+" "+a.getPrenume());


    }

    public void afiseazaSpectacoleleActorului(String nume)
            {
                try {
                Optional<Actor> actor= actorRepository.findActorByUsername(nume);

                SpectacolRepositories spectacoleRepository;

                spectacoleRepository = SpectacolRepositories.build(SpectacolRepositories.Type.FILE);

                Optional<List <Integer>>idSpecatcole= Optional.ofNullable(actor.get().getSpectacolsJuacte());

                for(int u: idSpecatcole.get()){


                    for(Spectacol s: spectacoleRepository.findSpectacolById(u)){
                      if(s instanceof SpectacolRuleaza)  System.out.println(s.getNumeSpectacol() + " " + "Ruleaza in data de " + ((SpectacolRuleaza) s).getData() + " la " + ((SpectacolRuleaza) s).getOra());
                       else  System.out.println(s.getNumeSpectacol());

                    }


                }
                } catch (NullPointerException e)
                {
                    System.out.println("Actorul nu a jucat in niciun spectacol");


                }




            }


}
