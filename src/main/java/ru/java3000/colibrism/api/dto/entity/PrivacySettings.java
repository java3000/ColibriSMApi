package ru.java3000.colibrism.api.dto.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PrivacySettings {
    String profile_visibility;
    String contact_privacy;
    String follow_privacy;
    boolean search_visibility;
}
