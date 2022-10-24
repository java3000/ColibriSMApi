package ru.java3000.colibrism.api.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.java3000.colibrism.api.dto.entity.User;

import java.util.Optional;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Response<T> {
    int code;
    String message;
    Optional<T> data;
    Optional<User> auth;
    Optional<Integer> count;
}
