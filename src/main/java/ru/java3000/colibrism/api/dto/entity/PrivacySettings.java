package ru.java3000.colibrism.api.dto.entity;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PrivacySettings {
    @SerializedName("profile_visibility")
    String profileVisibility;
    @SerializedName("contact_privacy")
    String contactPrivacy;
    @SerializedName("follow_privacy")
    String followPrivacy;
    @SerializedName("search_visibility")
    boolean searchVisibility;
}
