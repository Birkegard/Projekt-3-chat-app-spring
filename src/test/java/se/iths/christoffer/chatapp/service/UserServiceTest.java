package se.iths.christoffer.chatapp.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import se.iths.christoffer.chatapp.model.User;
import se.iths.christoffer.chatapp.repository.UserRepository;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    @Test
    void login() {
        User user = new User(1L, "Christoffer", "Password");

        Mockito.when(userRepository.findByUsernameAndPassword(user.getUsername(), user.getPassword())).thenReturn(user);

        User userLogIn = userService.login(user.getUsername(), user.getPassword());

        assertNotNull(userLogIn);
        verify(userRepository).findByUsernameAndPassword(userLogIn.getUsername(), userLogIn.getPassword());

    }

    @Test
    void register() {
        User user = new User(1L, "Christoffer", "Password");

        Mockito.when(userRepository.save(user)).thenReturn(user);

        User userRegister = userService.register(user);

        assertEquals("Christoffer", userRegister.getUsername());
        assertEquals("Password", userRegister.getPassword());
    }

    @Test
    void userNotExists(){
        User user = new User("Christoffer", "Lösenord");
        Mockito.when(userRepository.findByUsernameAndPassword(user.getUsername(), user.getPassword())).thenReturn(null);
        userService.login(user.getUsername(), user.getPassword());
        assertNull(user.getId());
        System.out.println(user.getId());
        verify(userRepository).findByUsernameAndPassword(user.getUsername(), user.getPassword());
    }
}