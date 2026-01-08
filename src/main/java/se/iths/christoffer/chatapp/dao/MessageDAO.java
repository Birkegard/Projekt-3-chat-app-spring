package se.iths.christoffer.chatapp.dao;

import se.iths.christoffer.chatapp.model.Message;

import java.util.List;

public interface MessageDAO {
    void saveMessage(Message message);

    List<Message> getMessagesByUserId(int userId);
}
