package se.iths.christoffer.chatapp.dao;

import se.iths.christoffer.chatapp.model.User;

public interface UserDAO {
    User login(String username, String password);

    User register(User user);
}
