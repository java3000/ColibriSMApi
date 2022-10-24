package ru.java3000.colibrism.api.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PublishSwiftRequest {
    String session_id;    //Access token ID	E.g. de25cc16eb00960f076...
    String swift_text;    //Text text message (Max. 200 chars)	E.g. `Lorem ipsum`
}
