package ru.java3000.colibrism.api.dto.entity;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.net.URL;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Notification {
    int id;
    @SerializedName("notifier_id")
    int notifierId;
    @SerializedName("recipient_id")
    int recipientId;
    String status; //"0",
    String subject;
    @SerializedName("entry_id")
    int entryId;
    String json; //"[]",
    String time;
    String username;
    URL avatar;
    String verified; //"1",
    String name;
    URL url;
}
