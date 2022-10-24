package ru.java3000.colibrism.api.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetProfileRequest {
    int user_id;    //Profile user ID	In order to get information about the profile, you must send a valid ID or username
    String username;    //Profile username	Unique username. E.g. "mansur_tl"
    String session_id;    //User auth token (Optional)	In this case, authorization is not required,
    // but it is desirable to determine whether you are subscribed to this profile or not, blocked or not, etc.
}
