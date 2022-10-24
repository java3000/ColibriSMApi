package ru.java3000.colibrism.api.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ToggleFollowRequest {
    String session_id;    //Access token ID	E.g. de25cc16eb00960f076...
    int user_id;    //Followed/Unfollowed user int ID	E.g. 4567
}
