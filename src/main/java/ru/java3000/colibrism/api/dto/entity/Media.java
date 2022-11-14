package ru.java3000.colibrism.api.dto.entity;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.net.URL;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Media {
    int id;
    @SerializedName("pub_id")
    int pubId;
    String type;
    String src;
    @SerializedName("json_data")
    String jsonData;
    long time;
    @SerializedName("x")
    MediaThumb thumb;

    //video
    URL source;
    URL poster;

    //image
    @SerializedName("media_id")
    int mediaId;
    URL url;
}
