package ru.java3000.colibrism.api.dto.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Thread {
    boolean can_reply;
    Post post;
    List<Post> next;
    List<Post> prev;
}
