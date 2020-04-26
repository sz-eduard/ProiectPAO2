package repositories.sala;

import exceptii.InexistentFileException;
import model.Sala;

import java.io.IOException;
import java.io.PrintStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;

public class FileSalaRepositories implements SalaRepositories {

    private final String file = "SALI";

    @Override
    public void addSala(Sala sala) {

            try (PrintStream out = new PrintStream(file)) {
                out.println(sala.getNumeSala()+","+sala.getNrTotalLocuri()+","+sala.getNrLocuriReducere()+","+sala.getLocatie());
            } catch (IOException e) {
                e.printStackTrace();
            }

    }

    public Optional<Sala> findSalaByNume(String numeSala) {
        Path path = Paths.get(file);
        Sala sala = null;

        try {
            if (!Files.exists(path)) {
                throw new InexistentFileException();
            }
            var list = Files.readAllLines(path);
            for (String u : list) {
                String [] attr = u.split(","); // 1,john,12345
                if (attr[1].equals(numeSala)) {
                    sala = new Sala();
                    sala.setNumeSala(attr[0]);
                    sala.setNrTotalLocuri(Integer.parseInt(attr[1]));
                    sala.setNrLocuriReducere(Integer.parseInt(attr[2]));
                    sala.setLocatie(attr[3]);
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return Optional.ofNullable(sala);
    }
}
