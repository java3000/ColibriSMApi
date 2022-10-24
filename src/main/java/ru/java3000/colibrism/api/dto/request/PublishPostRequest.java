package ru.java3000.colibrism.api.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.net.URL;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PublishPostRequest {
    String session_id;    //Access token ID	E.g. de25cc16eb00960f076...
    String post_text;    //Post text message (Max. 600 chars)	E.g. `Hello world!`
    int thread_id;    //Thered int. ID	Required only for reply
    URL gif_src;    //Gif image source URL	Only if the post does not contain other media files (Video or Image)
    String og_data;    //Extracted OG data from URL	Only if the post does not contain other media files
    // (Video or Image or GIF)
    String poll_data;    //Poll JSON data	Json array with poll option objects. E.g.
    // [{"value": "Option 1"}, {"value": "Option 2"}, {..}] From 2 to 4 options
    String privacy;    //Publication privacy settings (Ignored for replies to posts)
    // One of those values (everyone, followers, mentioned)
}
