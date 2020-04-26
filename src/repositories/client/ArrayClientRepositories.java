package repositories.client;


import model.Client;

import java.util.Optional;

public class ArrayClientRepositories implements ClientRepositories {

    private Client[] users = new Client[10];
    private int n;

    @Override
    public void addClient(Client client) {
        users[n] = client;
        n++;
    }

    @Override
    public Optional<Client> findUserByUsername(String nume) {
        for (int i = 0; i<n; i++) {
            if (users[i].getNume().equals(nume)) {
                return Optional.of(users[i]);
            }
        }
        return Optional.empty();
    }
}