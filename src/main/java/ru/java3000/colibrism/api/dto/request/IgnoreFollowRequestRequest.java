package ru.java3000.colibrism.api.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class IgnoreFollowRequestRequest {
    String session_id;    //Access token ID (Optional)	E.g. de25cc16eb00960f076...
    int req_id;    //Follow request int ID	E.g. 34
}
