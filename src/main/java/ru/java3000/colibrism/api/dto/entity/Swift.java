package ru.java3000.colibrism.api.dto.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Swift {
    Map<String, SwiftView> views;
    String time;
    String type;
    String status;
    SwiftMediaLink media;
    long exp_time;
    String text;
    int seen;
    String swid;
}
