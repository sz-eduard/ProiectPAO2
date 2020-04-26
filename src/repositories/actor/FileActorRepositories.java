package repositories.actor;


import exceptii.InexistentFileException;
import model.Actor;
import model.Spectacol;
import repositories.spectacol.SpectacolRepositories;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class FileActorRepositories implements ActorRepositories {
    private final String file = "ACTORI";
    @Override
    public void addActor(Actor actor) {

        try (PrintStream out = new PrintStream(file)) {
            out.println(actor.getNume()+","+actor.getPrenume()+","+actor.getCnp()+","+actor.getSpectacolsJuacte());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Actor> intoarceActori(){
        Path path = Paths.get(file);
        Actor actor = null;
        List<Actor> actori=new ArrayList<>();
        try {
            if (!Files.exists(path)) {
                throw new InexistentFileException();
            }
            var list = Files.readAllLines(path);

            for (String u : list) {

                String [] attr = u.split(";"); // 1,john,12345,1;2;3;4;5

                    actor = new  Actor();
                    actor.setNume(attr[0]);
                    actor.setPrenume(attr[1]);
                    actor.setCnp(attr[2]);
                    String[] idSpectacole=attr[3].split(",");//1;2;3;4
                    List<Integer> spectacole=new ArrayList<>();
                    for(String id: idSpectacole){

                        spectacole.add(Integer.parseInt(id));
                    }
                    actor.setSpectacolsJuacte(spectacole);


                actori.add(actor);


            }




        } catch (IOException e) {
            e.printStackTrace();
        }


        return actori;


    }

    public Optional<Actor> findActorByUsername(String nume) {
        Path path = Paths.get(file);
        Actor actor = null;

        try {
            if (!Files.exists(path)) {
                throw new InexistentFileException();
            }
            var list = Files.readAllLines(path);
            for (String u : list) {
                String [] attr = u.split(";"); // 1,john,12345,1;2;3;4;5
                if (attr[0].equals(nume)) {
                    actor = new  Actor();
                    actor.setNume(attr[0]);
                    actor.setPrenume(attr[1]);
                    actor.setCnp(attr[2]);
                    String[] idSpectacole=attr[3].split(",");//1;2;3;4
                    List<Integer> spectacole=new ArrayList<>();
                    for(String id: idSpectacole){

                        spectacole.add(Integer.parseInt(id));
                }
                    actor.setSpectacolsJuacte(spectacole);

                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return Optional.ofNullable(actor);
    }

    @Override
    public Optional<Actor> findActorByCNP(String cnp) {


        Path path = Paths.get(file);
        Actor actor = null;

        try {
            if (!Files.exists(path)) {
                throw new InexistentFileException();
            }
            var list = Files.readAllLines(path);
            for (String u : list) {
                String [] attr = u.split(";"); // 1,john,12345,1;2;3;4;5
                if (attr[2].equals(cnp)) {

                    actor = new  Actor();
                    actor.setNume(attr[0]);
                    actor.setPrenume(attr[1]);
                    actor.setCnp(attr[2]);
                    String[] idSpectacole=attr[3].split(",");//1;2;3;4
                    List<Integer> spectacole=new ArrayList<>();
                    for(String id: idSpectacole){

                        spectacole.add(Integer.parseInt(id));
                    }
                    actor.setSpectacolsJuacte(spectacole);

                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return Optional.ofNullable(actor);

    }
}
