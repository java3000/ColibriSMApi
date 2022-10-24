package ru.java3000.colibrism.api.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FollowRequestsRequest {
    int offset;    //Last user offset ID	This is only needed when loading users of the pagination system.
    String session_id;    //Access token ID (Optional)	E.g. de25cc16eb00960f076...
    int page_size;    //Total users limit for each request	Recommended: 20
}
