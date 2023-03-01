package com.spyrosoft.kotlinboot2.java;

import java.util.Optional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/users")
public class UserControllerJ {

    private final UserRepositoryJ userRepositoryJ;

    public UserControllerJ(UserRepositoryJ userRepositoryJ) {
        this.userRepositoryJ = userRepositoryJ;
    }

    @PostMapping()
    public UserEntityJ createUser(@RequestBody CreateUserBody user){
        var entity = new UserEntityJ(user.firstname, user.lastname, user.address, user.email);
        return userRepositoryJ.save(entity);
    }

    @GetMapping("/{id}")
    public Optional<UserEntityJ> getUser(@PathVariable String id){
        return userRepositoryJ.findById(Integer.valueOf(id));
    }

    record CreateUserBody(String firstname, String lastname, String address, String email){}
}
