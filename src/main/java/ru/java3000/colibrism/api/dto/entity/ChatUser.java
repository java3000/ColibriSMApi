package ru.java3000.colibrism.api.dto.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.net.URL;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ChatUser {
    int user_id;
    String username;
    String name;
    URL avatar;
    String verified;
    int chat_id;
    String time;
    String last_message;
    String new_messages;
    URL chat_url;
}
