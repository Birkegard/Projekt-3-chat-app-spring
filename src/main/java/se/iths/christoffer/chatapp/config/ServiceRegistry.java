package se.iths.christoffer.chatapp.config;


import org.springframework.stereotype.Component;
import se.iths.christoffer.chatapp.service.UserService;
import se.iths.christoffer.chatapp.service.MessageService;

@Component
public class ServiceRegistry {

    public static UserService userService;
    public static MessageService messageService;

    public ServiceRegistry(UserService userService, MessageService messageService) {
        ServiceRegistry.userService = userService;
        ServiceRegistry.messageService = messageService;
    }
}

