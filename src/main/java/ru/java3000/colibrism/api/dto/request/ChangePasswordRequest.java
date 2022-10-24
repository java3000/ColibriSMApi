package ru.java3000.colibrism.api.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ChangePasswordRequest {
    String session_id;    //Access token ID	E.g. de25cc16eb00960f076...
    String old_password;    //User old password	E.g. 123456
    String new_password;    //User new password	E.g. secret123
}
