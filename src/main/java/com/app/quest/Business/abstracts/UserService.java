package com.app.quest.Business.abstracts;

import com.app.quest.entities.User;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();
    User createUser( User newUser);
    User getUserById( Long userId);
    User updateUser( Long userId,  User newUser);
    void deleteUser( Long userId);
}
