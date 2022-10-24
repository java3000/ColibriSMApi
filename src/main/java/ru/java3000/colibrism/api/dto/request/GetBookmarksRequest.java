package ru.java3000.colibrism.api.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetBookmarksRequest {
    String session_id;    //Access token ID	E.g. de25cc16eb00960f076...
    int page_size;    //Total post limit for each request	Recommended: 20
    int offset;    //Last post offset ID	This is only needed when loading posts of the pagination system.
}
