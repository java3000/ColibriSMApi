package ru.java3000.colibrism.api.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ChangePostPrivacyRequest {
    String session_id;    //Access token ID	E.g. de25cc16eb00960f076...
    int post_id;    //Publication int ID	E.g. 11
    String privacy;    //Publication privacy settings (Ignored for replies to posts)	One of those values (everyone, followers, mentioned)
}
