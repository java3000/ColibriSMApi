package ru.java3000.colibrism.api.dto.response;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.java3000.colibrism.api.dto.entity.Auth;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Response<T> {
    @SerializedName(value="code")
    int code;
    @SerializedName(value="message")
    String message;
    @SerializedName(value="data")
    T data;
    @SerializedName(value="auth")
    Auth auth;
    @SerializedName(value="count")
    int count;
}
