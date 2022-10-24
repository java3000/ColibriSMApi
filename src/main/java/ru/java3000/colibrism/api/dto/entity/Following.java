package ru.java3000.colibrism.api.dto.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.net.URL;

@Data
@AllArgsConstructor
@NoArgsConstructor
//todo merge with follower?
public class Following {
    int offset_id;
    int id;
    String about;
    int followers;
    int posts;
    URL avatar;
    String last_active;
    String username;
    String fname;
    String lname;
    String email;
    String verified;
    String follow_privacy;
    String name;
    URL url;
    boolean is_following;
    boolean follow_requested;
    boolean is_user;
}
