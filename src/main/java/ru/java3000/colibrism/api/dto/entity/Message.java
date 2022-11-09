package ru.java3000.colibrism.api.dto.entity;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.net.URL;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Message {
    int id;
    @SerializedName("sent_by")
    int sentBy;
    @SerializedName("sent_to")
    int sentTo;
    boolean owner;
    String message; //"Image",
    @SerializedName("media_file")
    URL mediaFile;
    @SerializedName("media_type")
    String mediaType;
    String seen; //"0",
    @SerializedName("deleted_fs1")
    String deletedFs1;
    @SerializedName("deleted_fs2")
    String deletedFs2;
    String time;
    String side;
    @SerializedName("media_name")
    String mediaName; //media_raw?????
}
