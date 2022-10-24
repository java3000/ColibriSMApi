package ru.java3000.colibrism.api.dto.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
//todo is this identical UserLite??
public class Liker {
    int offset_id;
    int id;
    String about;
    int followers;
    int posts;
    String avatar;
    String last_active;
    String username;
    String fname;
    String lname;
    String email;
    String verified; // "2",
    String name;
    String url;
    boolean is_following;
    boolean is_user;
}
