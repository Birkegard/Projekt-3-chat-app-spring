package se.iths.christoffer.chatapp.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import se.iths.christoffer.chatapp.model.User;
import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    @Query("SELECT u FROM User u LEFT JOIN FETCH u.messages WHERE u.username=:username AND u.password=:password")
    User findByUsernameAndPassword(@Param("username") String username, @Param("password")  String password);
}