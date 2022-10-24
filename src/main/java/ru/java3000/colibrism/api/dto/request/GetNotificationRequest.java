package ru.java3000.colibrism.api.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetNotificationRequest {
    String session_id;    //Access token ID	E.g. de25cc16eb00960f076...
    String type;    //Notification type (notifs/mentions)	E.g. `notifs`
    int page_size;    //Total records limit for each request	Recommended: 20
    int offset;    //Last record offset ID	This is only needed when loading records of the pagination system.
}
