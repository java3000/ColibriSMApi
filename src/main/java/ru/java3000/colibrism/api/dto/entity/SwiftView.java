package ru.java3000.colibrism.api.dto.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.net.URL;

@SuppressWarnings("SpellCheckingInspection")
@Data
@AllArgsConstructor
@NoArgsConstructor
class SwiftView {
    int id;
    String username;
    String fname;
    String lname;
    URL avatar;
    String name;
    URL url;
    String time;
}
