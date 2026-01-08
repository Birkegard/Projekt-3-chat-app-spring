package se.iths.christoffer.chatapp.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import se.iths.christoffer.chatapp.model.Message;
import se.iths.christoffer.chatapp.model.User;
import se.iths.christoffer.chatapp.repository.MessageRepository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;

@ExtendWith(MockitoExtension.class)
class MessageServiceTest {

    @Mock
    private MessageRepository messageRepository;

    @InjectMocks
    private MessageService messageService;

    @Test
    void save() {
        User user = new User("Bert", "Karlsson");
        Message message = new Message(user, "Hur mår du?", LocalDateTime.now());

        Mockito.when(messageRepository.save(message)).thenReturn(message);

        messageService.save(message);

        assertEquals("Hur mår du?", message.getText());
    }

    @Test
    void getMessages() {
        List<Message> messageList = new ArrayList<>();
        messageList.add(new Message(new User(1L,"Johan", "Password"), "Vad gör du?", LocalDateTime.now()));
        messageList.add(new Message(new User(1L,"Johan", "Password"), "Äter mat", LocalDateTime.now()));
        messageList.add(new Message(new User(1L,"Johan", "Password"), "Dricker öl", LocalDateTime.now()));

        Mockito.when(messageRepository.findByUserId(1L)).thenReturn(messageList);

        List <Message> messages = messageService.getMessages(1L);

        assertEquals(3, messages.size());
        assertEquals("Vad gör du?", messages.get(0).getText());
        assertEquals("Äter mat", messages.get(1).getText());
        assertEquals("Dricker öl", messages.get(2).getText());

    }
}