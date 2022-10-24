package ru.java3000.colibrism.api.dto.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.net.URL;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Message {
    int id;
    int sent_by;
    int sent_to;
    boolean owner;
    String message; //"Image",
    URL media_file;
    String media_type;
    String seen; //"0",
    String deleted_fs1;
    String deleted_fs2;
    String time;
    String side;
    String media_name; //media_raw?????
}
