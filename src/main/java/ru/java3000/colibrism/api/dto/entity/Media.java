package ru.java3000.colibrism.api.dto.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.net.URL;

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
    MediaX x;
}
