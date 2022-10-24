package ru.java3000.colibrism.api.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SearchPeopleRequest {
    String query;    //Search keywords	E.g. John Smith
    int offset;    //Last post offset ID	This is only needed when loading posts of the pagination system.
    String session_id; //(Optional)	Access token ID	E.g. de25cc16eb00960f076...
    int page_size;    //Total post limit for each request	Recommended: 20
}
