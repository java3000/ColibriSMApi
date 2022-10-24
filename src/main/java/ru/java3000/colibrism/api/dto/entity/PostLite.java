package ru.java3000.colibrism.api.dto.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.net.URL;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostLite {
    int id;
    int user_id;
    String text;
    String type;
    int replys_count;
    int reposts_count;
    int likes_count;
    String status;
    int thread_id;
    String target;
    String og_data;
    String time;
    boolean advertising;
    long time_raw;
    String og_text;
    String og_image;
    URL url;
    boolean can_delete;
    List<String> media; //todo propper type
    boolean is_owner;
    boolean has_liked;
    boolean has_saved;
    boolean has_reposted;
    List<String> reply_to; //todo propper type
    Owner owner;
    int offset_id;
}
