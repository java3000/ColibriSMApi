package ru.java3000.colibrism.api.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetChatsRequest {
    String session_id;    //Access token ID	E.g. de25cc16eb00960f076...
}
