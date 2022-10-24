package ru.java3000.colibrism.api.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ChangeAvatarRequest {
    String session_id;    //Access token ID	E.g. de25cc16eb00960f076...
    byte[] avatar;    //Image format file (jpg,png,jpeg,gif)	image.jpeg
}
