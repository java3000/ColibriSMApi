package ru.java3000.colibrism.api.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ChangeLanguageRequest {
    String session_id;    //Access token ID	E.g. de25cc16eb00960f076...
    String lang_name;    //E.g. One of these options (english, french, german, italian, russian, portuguese, spanish, turkish, dutch, ukraine)
}
