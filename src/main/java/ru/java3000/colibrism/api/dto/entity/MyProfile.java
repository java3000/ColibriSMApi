package ru.java3000.colibrism.api.dto.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.net.URL;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MyProfile {
    int id;
    String first_name;
    String last_name;
    String user_name;
    String email;
    boolean is_verified;
    URL website;
    String about_you;
    String gender;
    String country;
    int post_count;
    String ip_address;
    int following_count;
    int follower_count;
    String language;
    String last_active;
    String member_since;
}
