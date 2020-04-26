package repositories.rezervari;

import model.Client;
import model.Rezerva;
import model.RezervaValid;

import java.io.*;

public class FileRezervareRepositories implements RezervareRepositories {


    private File log = new File("REZERVARI.csv");

    @Override
    public void addRezervare(Rezerva rezervare) {
//        try (PrintStream out = new PrintStream(file)) {
//            out.println(user.getId()+","+user.getUsername()+","+user.getPassword());
        try{
            if(!log.exists()){
                System.out.println("We had to make a new file.");
                log.createNewFile();
            }
            FileWriter fileWriter = new FileWriter(log, true);

            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            if(rezervare instanceof  RezervaValid)
                bufferedWriter.write(rezervare.getClient()+"|"+rezervare.getSpectacol()+"|"+rezervare.getData()+"|"+rezervare.getOra()+"|"+((RezervaValid) rezervare).getPret()+"\n");
            else
            {
                bufferedWriter.write(rezervare.getClient()+"|"+rezervare.getSpectacol()+"|"+rezervare.getData()+"|"+rezervare.getOra()+"|"+"\n");


            }
            bufferedWriter.close();


        } catch (IOException e) {
            e.printStackTrace();
        }
    }






}
