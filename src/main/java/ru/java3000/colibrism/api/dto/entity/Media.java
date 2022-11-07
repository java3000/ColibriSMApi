package ru.java3000.colibrism.api.dto.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.net.URL;

//todo refactor using gson serialization mapping fields
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Media {
    int id;
    int pub_id;
    String type;
    URL src;
    String json_data;
    long time;
    MediaThumb thumb;

    //video
    URL source;
    URL poster;

    //image
    int media_id;
    URL url;
    String type; //Image/Video"
}
