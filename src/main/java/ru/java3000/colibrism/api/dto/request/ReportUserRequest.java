package ru.java3000.colibrism.api.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReportUserRequest {
    String session_id;    //Access token ID	E.g. de25cc16eb00960f076...
    int user_id;    //User int ID	E.g. 12
    int reason;    //Report reason int ID (This value must be an int number as shown on the right)
    //For example, if you want to report spam account, then this value should be 1
    //1 = This user using this account for smap
    //2 = This user pretended to be someone
    //3 = This user posting inappropriate content
    //4 = This is a fake account
    //5 = This is a fraudulent account
    //6 = Other
    String comment;    //Comment to the reviwer	`Please take some actions. Thanks!`
}
