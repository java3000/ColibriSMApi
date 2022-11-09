package ru.java3000.colibrism.api.dto.entity;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Auth {
    @SerializedName(value="auth_token")
    String authToken;
    @SerializedName(value="refresh_token")
    String refreshToken;
    @SerializedName(value="auth_token_expiry")
    long authTokenExpiry;
}
