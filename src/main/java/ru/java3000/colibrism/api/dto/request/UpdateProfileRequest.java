package ru.java3000.colibrism.api.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.net.URL;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateProfileRequest {
    String session_id;    //Access token ID	E.g. de25cc16eb00960f076...
    String first_name;    //User user first name	E.g. Mansur
    String last_name;    //User user last name	E.g. ATL
    String about;    //User bio (Max 140 chars.)	E.g. ATL
    String gender;    //User gender (M/F/O/T)	E.g. M
    String email;    //User email address	E.g. email@email.com
    String username;    //User new username	E.g. mansurTL
    URL website;    //User website URL	E.g. https://www.csm-demo.ru/
    int country_id;    //User country ID	E.g. 1 (United States)
}
