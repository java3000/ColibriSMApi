package ru.java3000.colibrism.api.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReportPostRequest {
    String session_id;    //ccess token ID	E.g. de25cc16eb00960f076...
    int post_id;    //Post int ID	E.g. 4567
    int reason;    //Report reason int ID (This value must be an int number as shown on the right)
    //For example, if you want to report spam, then this value should be 1
    //1 = This is spam
    //2 = Misleading or fraudulent
    //3 = Publication of private information
    //4 = Threats of violence or physical harm
    //5 = I am not interested in this post
    //6 = Other
    String comment; //Comment to the reviwer	`Please take some actions. Thanks!`
}
