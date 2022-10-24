package ru.java3000.colibrism.api.dto.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.net.URL;
import java.util.List;
import java.util.Optional;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    Optional<Integer> id;
    Optional<String> first_name;
    Optional<String> last_name;
    Optional<String> user_name;
    Optional<String> email;
    Optional<Boolean> is_verified;
    Optional<String> website;
    Optional<String> about_you;
    Optional<String> gender;
    Optional<String> country;
    Optional<Integer> post_count;
    Optional<Integer> last_post; //?
    Optional<Integer> last_ad; //?
    Optional<String> language;
    Optional<Integer> following_count;
    Optional<Integer> follower_count;
    Optional<Float> wallet; //?
    Optional<String> ip_address;
    Optional<String> last_active; //?
    Optional<String> member_since;
    Optional<String> profile_privacy; //?

    ////Auth
    Optional<String> auth_token;
    Optional<String> refresh_token;
    Optional<Long> auth_token_expiry;

    ////
    Optional<String> about;
    Optional<Integer> followers;
    Optional<Integer> posts;
    Optional<URL> avatar; //todo replace all string to url in other places
    Optional<String> username;
    Optional<String> fname;
    Optional<String> lname;
    Optional<String> verified; // "0",
    Optional<String> name;
    Optional<URL> url;
    Optional<Boolean> is_user;
    Optional<Boolean> is_following;

    ////
    Optional<List<Swift>> swift;

    ////
    Optional<Integer> user_id;
    Optional<Integer> chat_id;
    Optional<String> time;
    Optional<String> last_message;
    Optional<String> new_messages;
    Optional<URL> chat_url;

    ////
    Optional<Integer> offset_id;
    Optional<String> follow_privacy;
    Optional<Boolean> follow_requested;

    ////
    Optional<Boolean> pending_req;

    ////
    Optional<URL> cover;
    Optional<Boolean> is_blocked_visitor;
    Optional<Boolean> can_view_profile;

    ////
    Optional<Boolean> is_owner;
    Optional<URL> thread_url;
}
