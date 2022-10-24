package ru.java3000.colibrism.api.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SignUpRequest {
    String first_name;    //User first name	E.g. John
    String last_name;    //User last name	E.g. Smith
    String email;    //New user's E-mail	This field must also be unique
    String username;    //Unique username	Username without any characters other than Latin letters and numbers
    String password;    //New user's password	User password from 6-20 characters
}
