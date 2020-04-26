package repositories.client;

import exceptii.InexistentFileException;
import model.Client;
import model.TipClient;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;

public class FileClientRepositories implements ClientRepositories {

    private final String file = "CLIENTI";
    private File log = new File("CLIENTI.csv");



    @Override

    public void addClient(Client user) {
//        try (PrintStream out = new PrintStream(file)) {
//            out.println(user.getId()+","+user.getUsername()+","+user.getPassword());
        try{
            if(!log.exists()){
                System.out.println("We had to make a new file.");
                log.createNewFile();
            }
            FileWriter fileWriter = new FileWriter(log, true);

            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(user.getNume()+","+user.getPrenume()+","+user.getParola()+","+user.getTipClient()+"\n");
            bufferedWriter.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Optional<Client> findUserByUsername(String username) {
        Path path = Paths.get(file);
        Client user = null;

        try {
            if (!Files.exists(path)) {
                throw new InexistentFileException();
            }
            var list = Files.readAllLines(path);
            for (String u : list) {
                String [] attr = u.split(","); // 1,john,12345
                if (attr[0].equals(username)) {

                    user = new Client();
                    user.setNume(attr[0]);
                    user.setPrenume(attr[1]);
                    user.setParola(attr[2]);

                    user.setTipClient(TipClient.valueOf(attr[3]));

                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


        return Optional.ofNullable(user);
    }


}


