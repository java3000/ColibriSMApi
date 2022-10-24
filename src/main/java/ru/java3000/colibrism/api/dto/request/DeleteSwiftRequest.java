package ru.java3000.colibrism.api.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DeleteSwiftRequest {
    String session_id;    //Access token ID	E.g. de25cc16eb00960f076...
    String swid;    //Swift hash id	E.g. `zpad2HalsbsLGhdI`
}
