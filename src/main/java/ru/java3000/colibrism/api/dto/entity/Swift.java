package ru.java3000.colibrism.api.dto.entity;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
class Swift {
    Map<String, SwiftView> views;
    String time;
    String type;
    String status;
    SwiftMediaLink media;
    @SerializedName("exp_time")
    long expTime;
    String text;
    int seen;
    @SuppressWarnings("SpellCheckingInspection")
    String swid;
}
