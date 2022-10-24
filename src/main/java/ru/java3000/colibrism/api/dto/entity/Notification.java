package ru.java3000.colibrism.api.dto.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.net.URL;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Notification {
    int id;
    int notifier_id;
    int recipient_id;
    String status; //"0",
    String subject;
    int entry_id;
    String json; //"[]",
    String time;
    String username;
    URL avatar;
    String verified; //"1",
    String name;
    URL url;
}
