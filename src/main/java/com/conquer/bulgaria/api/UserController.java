package com.conquer.bulgaria.api;

import com.conquer.bulgaria.model.User;
import com.conquer.bulgaria.model.UserBody;
import com.conquer.bulgaria.service.UserService;
import com.google.firebase.auth.FirebaseAuthException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.UserRecord;

import java.util.Optional;

@RestController
@RequestMapping("api/v1/user")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping
    public User getUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        String uid = authentication.getName(); // Firebase uid
        Optional<User> user = userService.getUser(uid);

        return user.orElse(null);
    }

    @PostMapping
    public void addUser(@RequestBody UserBody userBody) throws FirebaseAuthException {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        String uid = authentication.getName();
        UserRecord userRecord = FirebaseAuth.getInstance().getUser(uid);

        User user = new User(
                uid,
                userBody.username(),
                userRecord.getEmail(),
                userRecord.getUserMetadata().getLastSignInTimestamp(),
                userBody.bio());

        userService.addUser(user);
    }
}
