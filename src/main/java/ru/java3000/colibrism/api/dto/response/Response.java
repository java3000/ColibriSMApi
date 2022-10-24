package ru.java3000.colibrism.api.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.java3000.colibrism.api.dto.entity.Auth;

import java.util.Optional;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Response<T> {
    int code;
    String message;
    Optional<T> data;
    Optional<Auth> auth;
    Optional<Integer> count;
}
