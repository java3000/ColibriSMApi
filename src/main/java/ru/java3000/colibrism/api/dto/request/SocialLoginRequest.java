package ru.java3000.colibrism.api.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SocialLoginRequest {
    String access_token;
    String type; //E.g. `facebook` or `google`
    String device_type;
}
