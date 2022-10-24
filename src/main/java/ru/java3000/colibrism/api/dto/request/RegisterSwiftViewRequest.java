package ru.java3000.colibrism.api.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegisterSwiftViewRequest {
    String session_id;    //Access token ID	E.g. de25cc16eb00960f076...
    int user_id;    //Swift user ID	E.g. `10`
    String swid;    //Swift hash id	E.g. `zpad2HalsbsLGhdI`
}
