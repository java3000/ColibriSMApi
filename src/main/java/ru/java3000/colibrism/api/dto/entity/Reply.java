package ru.java3000.colibrism.api.dto.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.net.URL;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Reply {
    int id;
    int user_id;
    String text;
    String type;
    String replys_count; //"0" //?????
    String reposts_count;
    String likes_count;
    String status;
    int thread_id;
    String target;
    String og_data;
    String time;
    List<Object> replys; //[],
    boolean advertising;
    long time_raw;
    String og_text;
    String og_image;
    URL url;
    boolean can_delete;
    List<Media> media;
    boolean is_owner;
    boolean has_liked;
    boolean has_saved;
    boolean has_reposted;
    User reply_to;
    User owner;
    int offset_id;
}
