package ru.java3000.colibrism.api.dto.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HashTag {
    int id;
    int posts;
    String tag;
    long time;
    String hashtag;
    String url;
    int total;
}
