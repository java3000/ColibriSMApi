package ru.java3000.colibrism.api.dto.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.net.URL;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserLite {
    int id;
    String about;
    int followers;
    int posts;
    URL avatar; //todo replace all string to url in other places
    String last_active; //"29 Sep, 20 11:09 AM",
    String username;
    String fname;
    String lname;
    String email;
    String verified; // "0",
    String name;
    URL url;
    boolean is_user;
    boolean is_following;
}
