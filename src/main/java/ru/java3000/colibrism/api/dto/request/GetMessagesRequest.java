package ru.java3000.colibrism.api.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetMessagesRequest {
    String session_id;    //Access token ID	E.g. de25cc16eb00960f076...
    int user_id;    //User ID of the interlocutor	E.g. 4567
    int offset_up;    //First message offset ID	This is only needed when loading old messages from the current chat.
    int offset_down;    //Last message offset ID	This is only needed when loading new messages from the current chat.
    int page_size;    //Total message limit for each request	Recommended: 20
}
