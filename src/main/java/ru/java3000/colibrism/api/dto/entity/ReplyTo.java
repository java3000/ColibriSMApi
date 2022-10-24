package ru.java3000.colibrism.api.dto.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.net.URL;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReplyTo {
    int id;
    URL url;
    URL avatar;
    String username;
    String name;
    String gender;
    boolean is_owner;
    URL thread_url;
}
