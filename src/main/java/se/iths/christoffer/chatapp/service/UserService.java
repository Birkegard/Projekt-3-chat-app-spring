package se.iths.christoffer.chatapp.service;


import org.springframework.stereotype.Service;
import se.iths.christoffer.chatapp.model.User;
import se.iths.christoffer.chatapp.repository.UserRepository;

@Service
public class UserService {

    private final UserRepository repo;

    public UserService(UserRepository repo) {
        this.repo = repo;
    }

    public User login(String username, String password) {
        return repo.findByUsernameAndPassword(username, password);
    }

    public User register(User user) {
        return repo.save(user);
    }


}
