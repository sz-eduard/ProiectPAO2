package repositories.spectacol;

import exceptii.InexistentFileException;
import model.Actor;
import model.Spectacol;
import model.SpectacolRuleaza;

import java.io.IOException;
import java.io.PrintStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class FileSpectacolRepositories implements SpectacolRepositories {

    private final String file = "SPECTACOLE";
    @Override
    public void addSpectacol(Spectacol spectacol) {


        try (PrintStream out = new PrintStream(file)) {
            if(spectacol instanceof SpectacolRuleaza)
            out.println(spectacol.getNumeSpectacol()+","+((SpectacolRuleaza) spectacol).getOra()+","+((SpectacolRuleaza) spectacol).getData()+","+((SpectacolRuleaza) spectacol).getSala()+","+spectacol.getDistributieActori());
            else
            {
                out.println(spectacol.getNumeSpectacol()+","+spectacol.getDistributieActori());

            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }






    @Override
    public Optional<Spectacol> findSpectacolByNume(String nume) {
        return Optional.empty();
    }



    @Override
    public List<Spectacol> spectacoleToate() {
        Path path = Paths.get(file);
        SpectacolRuleaza spectacolRuleaza = null;
        Spectacol spectacol=null;
        List<Spectacol> spectacole = new ArrayList<>();

        try {
            if (!Files.exists(path)) {
                throw new InexistentFileException();
            }


            var list = Files.readAllLines(path);
            for (String u : list) {
                String [] attr = u.split(";"); // 1,john,12345,1;2;3;4;5

                    if(attr[3].equals("-")) {

                        spectacol=new Spectacol();
                        spectacol.setId(Integer.parseInt(attr[0]));
                        spectacol.setNumeSpectacol(attr[1]);
                        String[] idActori=attr[2].split(",");

                        List<String> actori=new ArrayList<>();

                        for(String i:idActori){

                            actori.add(i);


                        }
                        spectacol.setDistributieActori(actori);
                        spectacole.add(spectacol);

                    }
                    else
                    {

                        spectacolRuleaza = new SpectacolRuleaza();
                        spectacolRuleaza.setId(Integer.parseInt(attr[0]));
                        spectacolRuleaza.setNumeSpectacol(attr[1]);
                        spectacolRuleaza.setData(attr[4]);
                        spectacolRuleaza.setOra(attr[5]);

                        String[] idActori = attr[2].split(",");

                        List<String> actori = new ArrayList<>();

                        for (String i : idActori) {

                            actori.add(i);


                        }

                        spectacolRuleaza.setDistributieActori(actori);
                        spectacole.add(spectacolRuleaza);


                    }


            }
        } catch (IOException e) {
            e.printStackTrace();
        }


        return spectacole ;
    }





    @Override
    public List<Spectacol> findSpectacolById(Integer id) {
        Path path = Paths.get(file);
        SpectacolRuleaza spectacolRuleaza = null;
        Spectacol spectacol=null;
        List<Spectacol> spectacole = new ArrayList<>();

        try {
            if (!Files.exists(path)) {
                throw new InexistentFileException();
            }


            var list = Files.readAllLines(path);
            for (String u : list) {
                String [] attr = u.split(";"); // 1,john,12345,1;2;3;4;5
                if (Integer.parseInt(attr[0])==id) {
                    if(attr[3].equals("-")) {

                        spectacol=new Spectacol();
                        spectacol.setId(Integer.parseInt(attr[0]));
                        spectacol.setNumeSpectacol(attr[1]);
                        String[] idActori=attr[2].split(",");

                        List<String> actori=new ArrayList<>();

                        for(String i:idActori){

                            actori.add(i);


                        }
                        spectacol.setDistributieActori(actori);
                        spectacole.add(spectacol);

                    }
                    else
                    {

                        spectacolRuleaza = new SpectacolRuleaza();
                        spectacolRuleaza.setId(Integer.parseInt(attr[0]));
                        spectacolRuleaza.setNumeSpectacol(attr[1]);
                        spectacolRuleaza.setData(attr[4]);
                        spectacolRuleaza.setOra(attr[5]);

                        String[] idActori = attr[2].split(",");

                        List<String> actori = new ArrayList<>();

                        for (String i : idActori) {

                            actori.add(i);


                        }

                        spectacolRuleaza.setDistributieActori(actori);
                        spectacole.add(spectacolRuleaza);


                    }

                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


        return spectacole ;
    }

}
