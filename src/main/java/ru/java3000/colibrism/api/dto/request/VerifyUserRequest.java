package ru.java3000.colibrism.api.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VerifyUserRequest {
    String session_id;    //Access token ID	E.g. de25cc16eb00960f076...
    String text_message;    //Text message to the reviewer	E.g. "Please verify my account"
    String video_message; //?	//Video message to the reviewer	E.g. "video appeal.mp4"
    String full_name;    //User full name	E.g. John Smith
}
