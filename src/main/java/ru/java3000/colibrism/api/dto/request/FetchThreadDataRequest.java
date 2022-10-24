package ru.java3000.colibrism.api.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FetchThreadDataRequest {
    String session_id;    //Access token ID	E.g. de25cc16eb00960f076...
    int thread_id;    //Thread int ID	E.g. 123456 (ID of any post to view replies and all details)
}
