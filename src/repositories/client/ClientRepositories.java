package repositories.client;

import model.Client;

import java.util.Optional;

public interface ClientRepositories {

    void addClient(Client client);
    Optional<Client> findUserByUsername(String username);

    static ClientRepositories build(Type type) {
        switch (type) {
            //case DB: return new DBUserRepository();
            case FILE: return new FileClientRepositories();
            case ARRAY:return new ArrayClientRepositories();
        }

        throw new RuntimeException("No such type");
    }

    enum Type {
         FILE, ARRAY //,DB
    }
}