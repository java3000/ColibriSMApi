package ru.java3000.colibrism.api.dto.entity;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
class MediaThumb {
    @SerializedName("image_thumb")
    String imageThumb;
    @SerializedName("poster_thumb")
    String posterThumb;
}
