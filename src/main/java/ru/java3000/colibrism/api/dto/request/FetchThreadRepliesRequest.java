package ru.java3000.colibrism.api.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FetchThreadRepliesRequest {
    String session_id;    //Access token ID	E.g. de25cc16eb00960f076...
    int thread_id;    //Thread int ID	E.g. 123456 (ID of any post to view replies and all details)
    int page_size;    //Total post limit for each request (Optional)	Recommended: 20
    int offset;    //Last post offset ID	This variable must be the id of the last post (Reply)
    // object in the `next` array (see above)
}
