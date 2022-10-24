package ru.java3000.colibrism.api.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DeletePostMediaRequest {
    String session_id;    //Access token ID	E.g. de25cc16eb00960f076...
    String type;    //Media file type (Image/Video)	E.g. image
    int media_id;    //Media file ID	E.g. 45
}
