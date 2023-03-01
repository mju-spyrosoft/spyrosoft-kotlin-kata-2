package com.spyrosoft.kotlinboot2.java;

import com.spyrosoft.kotlinboot2.GuestService;
import java.util.Set;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/kata")
public class GreetingControllerJ {

    private final GuestService userService;

    public GreetingControllerJ(GuestService userService) {
        this.userService = userService;
    }

    @GetMapping("/hey")
    public String helloKata(@RequestParam(required = false) String name){
        return userService.greetAndAddToGuestBook(name);
    }

    @GetMapping("/guestbook")
    public Set<String> showGuests() {
        return userService.listGuests();
    }
}


