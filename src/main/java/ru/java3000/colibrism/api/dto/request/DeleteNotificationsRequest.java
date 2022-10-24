package ru.java3000.colibrism.api.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DeleteNotificationsRequest {
    String session_id;    //Access token ID	E.g. de25cc16eb00960f076...
    int[] scope;    //Array of notification ID (Integer)	E.g. [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, ...]
}
