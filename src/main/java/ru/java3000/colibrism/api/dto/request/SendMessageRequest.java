package ru.java3000.colibrism.api.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SendMessageRequest {
    String session_id; //Access token ID	E.g. de25cc16eb00960f076...
    int user_id;    //User ID of the interlocutor	E.g. 4567
    String type;    //Message type Text or Image	E.g. One of these options (text/media)
    byte[] image;    //Message image file	E.g. some-picture.jpeg
    String message;    //Message text (Max length 3000)	E.g. `Hi! How are you?`
}
