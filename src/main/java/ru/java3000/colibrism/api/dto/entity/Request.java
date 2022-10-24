package ru.java3000.colibrism.api.dto.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.net.URL;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Request {
    int offset_id;
    int id;
    String about;
    int posts;
    URL avatar;
    String last_active;
    String username;
    String fname;
    String lname;
    String email;
    String verified; //"0",
    String name;
    URL url;
    boolean pending_req;
}
