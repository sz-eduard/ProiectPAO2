package service;

import model.Client;
import repositories.client.ClientRepositories;

import java.util.Optional;

public class LoginService {

    private LoginService() {

    }

    public boolean login(Client user) {
        ClientRepositories userRepository = ClientRepositories.build(ClientRepositories.Type.FILE);
        Optional<Client> u = userRepository.findUserByUsername(user.getNume());

        if(u.isPresent()) {
            Client usr = u.get();
            if (usr.getParola().equals(user.getParola())) {
                return true;
            }
        }


        return false;
    }

    public static LoginService getInstance() {
        return SingletonHolder.INSTANCE;
    }

    private static class SingletonHolder {
        private static LoginService INSTANCE = new LoginService();
    }

    public void register(Client user) {
        ClientRepositories userRepository = ClientRepositories.build(ClientRepositories.Type.FILE);
        userRepository.addClient(user);
    }


}



