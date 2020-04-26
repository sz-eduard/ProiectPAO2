package main;

import model.*;
import repositories.rezervari.RezervareRepositories;
import service.ActorService;
import service.LoginService;
import service.RezervaService;
import service.SpectacoleService;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        LoginService service = LoginService.getInstance();;
        ActorService actori=new ActorService();
        SpectacoleService spectacole=new SpectacoleService();
        RezervaService rezervari=new RezervaService();

       Client c1=new Client("popescu","1234","Ion", TipClient.NORMAL);
        Client c2=new Client("popescu","12345","Ion", TipClient.NORMAL);

        Client c3=new Client("popescu1","12345","Ion", TipClient.NORMAL);
        service.register(c1); // adauga userul
        service.register(c2);
        boolean res1 = service.login(c2); // face login


        List<String> actori1=new ArrayList<>();
        actori1.add("20000000000000");

        Sala sala1=new Sala("Polivalenta;","Cladirea C2, Etajul 3;",100,20);

        SpectacolRuleaza s1=new SpectacolRuleaza(1,"Bani din cer",actori1,"12-06-2020"," ora 15:00",sala1);

        RezervaValid rezervaValid=new RezervaValid(s1,c1,s1.getData(),s1.getOra(),14);



        System.out.println(res1);

        actori.afiseazaActori();
        actori.afiseazaSpectacoleleActorului("Mihai");
        spectacole.afiseazaSpectacoleRuleaza();
        spectacole.afiseazaToateSpectacolele();
        spectacole.afiseazaActoriSpectacolului(1);
        spectacole.afiseazaSpecatoclData("12-06-2021");
        spectacole.afiseazaSpecatoclSala("Bani din cer","12-06-2020");
        rezervari.adaugaRezervare(rezervaValid);



    }
}
