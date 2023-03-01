package com.spyrosoft.kotlinboot2.java;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import java.util.Optional;
import org.jetbrains.annotations.Nullable;

@Entity(name = "app_user2") //This will break
public class UserEntityJ {

    private String lastname;
    private String firstname;
    @Nullable
    private String address;
    private String email;
    @GeneratedValue(
        strategy = GenerationType.SEQUENCE,
        generator = "app_user_id_seq"
    )
    @SequenceGenerator(
        name = "app_user_id_seq",
        sequenceName = "app_user_id_seq",
        allocationSize = 1
    )
    @Id
    private Integer id;

    protected UserEntityJ() {
    }

    public UserEntityJ(String lastname, String firstname, @Nullable String address, String email) {
        this.lastname = lastname;
        this.firstname = firstname;
        this.address = address;
        this.email = email;
    }

    //Not mine code, dont shout at me
    private static String upperEven(String s) {
        char[] c = s.toCharArray();
        boolean t = false;
        for (int i = 0; i < c.length; i++)
            if (Character.isLetter(c[i]))
                c[i] = ((t = ! t) ? Character.toLowerCase(c[i]) : Character.toUpperCase(c[i]));
        return new String(c);
    }

    public Optional<String> getAddressButCooler() {
        return getAddress().map(UserEntityJ::upperEven);
    }

    public String getLastname() {
        return lastname;
    }

    public Optional<Integer> getId() {
        return Optional.of(id);
    }

    public String getFirstname() {
        return firstname;
    }

    public Optional<String> getAddress() {
        return Optional.of(address);
    }

    public String getEmail() {
        return email;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
