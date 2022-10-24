package ru.java3000.colibrism.api.dto.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.net.URL;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OtherProfile {
    int id;
    String first_name;
    String last_name;
    URL avatar;
    URL cover;
    String user_name;
    String email;
    boolean is_verified;
    URL website;
    String about_you;
    String gender; //"M",
    String country;
    int post_count;
    String about;
    String ip_address;
    int following_count;
    int follower_count;
    String language;
    long last_active;
    String profile_privacy;
    String member_since;
    boolean is_blocked_visitor;
    boolean is_following;
    boolean can_view_profile;
}
