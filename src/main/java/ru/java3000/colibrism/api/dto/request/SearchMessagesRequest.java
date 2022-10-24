package ru.java3000.colibrism.api.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SearchMessagesRequest {
    String session_id;    //Access token ID	E.g. de25cc16eb00960f076...
    int user_id;    //User ID of the interlocutor	E.g. 4567
    String query;    //Search keyword	E.g. `Hello`
    int page_size;    //Search result rows limit	Default is (50) rows
    int offset_up;    //First message offset ID	This is only needed when loading previous messages.
    int offset_down;    //Last message offset ID	This is only needed when loading next messages.
}
