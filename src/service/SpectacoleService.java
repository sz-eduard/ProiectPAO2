package service;

import model.Actor;
import model.Spectacol;
import model.SpectacolRuleaza;
import repositories.actor.ActorRepositories;
import repositories.spectacol.SpectacolRepositories;

import java.util.*;
import java.util.stream.Collectors;

public class SpectacoleService {

   private SpectacolRepositories spectacolRepository;


   public SpectacoleService(){

       spectacolRepository = SpectacolRepositories.build(SpectacolRepositories.Type.FILE);


   }

   public void afiseazaSpectacoleRuleaza()
   {
       for(Spectacol s: spectacolRepository.spectacoleToate())
         if(s instanceof SpectacolRuleaza)
            System.out.println(s.getNumeSpectacol() + " " + "Ruleaza in data de " + ((SpectacolRuleaza) s).getData() + " la " + ((SpectacolRuleaza) s).getOra());

   }

   public void afiseazaToateSpectacolele()
   {
      for(Spectacol s: spectacolRepository.spectacoleToate())

         System.out.println(s.getNumeSpectacol());

   }

   public void afiseazaActoriSpectacolului(int id)
   {
      ActorRepositories actori;

      actori= ActorRepositories.build(ActorRepositories.Type.FILE);
      List<String> actori1=new ArrayList<>();
      for(Spectacol s: spectacolRepository.spectacoleToate()){
         if(s.getIdSpectacol()==id)
         {


       /*for(int u=0; u<s.getDistributieActori().size()-1; u++)
       {
          int k=0;
          for(int i=u+1; i<s.getDistributieActori().size(); i++)
          {
             if(s.getDistributieActori().get(u).equals(s.getDistributieActori().get(i)))
                k=1;
          }
          if(k==0)
             actori1.add(s.getDistributieActori().get(u));


       }

            actori1.add(s.getDistributieActori().get(s.getDistributieActori().size()-1));*/
               actori1=s.getDistributieActori();


         }

      }

      for(String cnp: actori1)
         System.out.println(actori.findActorByCNP(cnp).get().getNume()+" "+actori.findActorByCNP(cnp).get().getPrenume());


   }


   public void afiseazaSpecatoclData(String data)
   {int k=0;
      for(Spectacol s: spectacolRepository.spectacoleToate())
      {
         if(s instanceof SpectacolRuleaza)
         {

            if(((SpectacolRuleaza) s).getData().equals(data))
            {k=1;
               System.out.println("Ruleaza "+s.getNumeSpectacol()+"la "+((SpectacolRuleaza) s).getOra());
            }
         }


      }

      if(k==0) System.out.println("In aceasta zi nu ruleaza nici un spectacol");

   }
   public void afiseazaSpecatoclSala(String numeSpectacol,String data)
   {int k=0;
      for(Spectacol s: spectacolRepository.spectacoleToate())
      {
         if(s instanceof SpectacolRuleaza)
      {

         if(((SpectacolRuleaza) s).getNumeSpectacol().equals(numeSpectacol) && ((SpectacolRuleaza) s).getData().equals(data) )
         {k=1;
            System.out.println("Spectacolul "+s.getNumeSpectacol()+"ruleaza in sala "+((SpectacolRuleaza) s).getSala()+" la "+((SpectacolRuleaza) s).getOra());
         }
      }


      }

      if(k==0) System.out.println("Acest Spectacol nu este disponibil");

   }




}
