package ru.java3000.colibrism.api.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetProfilePostsRequest {
    int user_id;    //Profile user ID	In order to get information about the profile, you must send a valid ID
    String type;    //Profile posts type (posts/media/liked)	E.g. `posts` in order to get user publications
    String session_id;    //User auth token (Optional)	In this case, authorization is not required, but it is desirable to determine whether you are subscribed to this profile or not, blocked or not, etc.
    int offset;    //Last post offset ID	This is only needed when loading posts of the pagination system.
    int page_size;    //Total post limit for each request	Recommended: 20
}
