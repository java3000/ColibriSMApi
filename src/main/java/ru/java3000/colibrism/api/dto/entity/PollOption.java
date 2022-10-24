package ru.java3000.colibrism.api.dto.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PollOption {
    int percentage;
    int total;
    String option;
}
