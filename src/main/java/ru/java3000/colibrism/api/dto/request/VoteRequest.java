package ru.java3000.colibrism.api.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VoteRequest {
    String session_id;    //Access token ID	E.g. de25cc16eb00960f076...
    int post_id;    //Post int ID	E.g. 84
    int poll_id;    //Poll index ID (starts from 0,1,2,3 etc..)	E.g. To vote frist option of a poll send 0
}
