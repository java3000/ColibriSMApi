package ru.java3000.colibrism.api.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UploadSwiftMediaRequest {
    String session_id;    //Access token ID	E.g. de25cc16eb00960f076...
    String type;    //Media file type (image/video)	E.g. image
    byte[] file;    //Media file (Image/Video)	E.g. some-selfy-picture.jpeg
}
