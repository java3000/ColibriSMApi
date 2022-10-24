package ru.java3000.colibrism.api.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClearChatRequest {
    String session_id;	//Access token ID	E.g. de25cc16eb00960f076...
    int user_id;	//User ID of the interlocutor	E.g. 4567
    int delete_chat;	//Delete chat after clearing	E.g. One of these options (1/0)
}
