package ru.java3000.colibrism.api.dto.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    int id;
    String first_name;
    String last_name;
    String user_name;
    String email;
    boolean is_verified;
    String website;
    String about_you;
    String gender;
    String country;
    int post_count;
    int last_post; //?
    int last_ad; //?
    String language;
    int following_count;
    int follower_count;
    float wallet; //?
    String ip_address;
    long last_active; //?
    String member_since;
    String profile_privacy; //?
}
