package ru.java3000.colibrism.api.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FetchLikesRequest {
    String session_id;    //Access token ID (Optional)	E.g. de25cc16eb00960f076...
    int post_id;     //Liked/Unliked post int ID	E.g. 4567
    int page_size;    //Total records limit for each request	Recommended: 20
    int offset;    //Last post offset ID	This is only needed when loading records of the pagination system.
}
