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
public class Post {
    long id;
    long user_id;
    String text;
    String type;
    int replys_count;
    int reposts_count;
    int likes_count;
    String status; //?
    long thread_id;
    String target;
    String og_data;
    String time;
    int offset_id; //?
    Optional<Boolean> is_repost;
    Optional<Boolean> is_reposter;
    Optional<String> attrs;
    boolean advertising;
    long time_raw;
    String og_text;
    URL og_image;
    URL url;
    boolean can_delete;
    List<Media> media;
    boolean is_owner;
    boolean has_liked;
    boolean has_saved;
    boolean has_reposted;
    List<User> reply_to;
    List<Object> replys; //[], ????
    User owner;
}
