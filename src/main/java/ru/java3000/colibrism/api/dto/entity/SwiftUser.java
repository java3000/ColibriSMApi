package ru.java3000.colibrism.api.dto.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.net.URL;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SwiftUser {
    int id;
    String username;
    String fname;
    String lname;
    URL avatar;
    List<Swift> swift;
}
