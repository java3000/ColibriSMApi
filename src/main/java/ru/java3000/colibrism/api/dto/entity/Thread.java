package ru.java3000.colibrism.api.dto.entity;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Thread {
    @SerializedName("can_reply")
    boolean canReply;
    Post post;
    List<Post> next;
    List<Post> prev;
}
