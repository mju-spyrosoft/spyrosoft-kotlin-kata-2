package com.spyrosoft.kotlinboot2.java;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;

@Service
public class GuestServiceJ {

    private final Set<String> guestbook = new HashSet<>();

    public String greetAndAddToGuestBook(String name){
        guestbook.add(name);
        return "hello kata: " + name;
    }

    public Set<String> listGuests(){
        return guestbook.stream()
            .map(String::toLowerCase)
            .collect(Collectors.toSet());
    }
}

