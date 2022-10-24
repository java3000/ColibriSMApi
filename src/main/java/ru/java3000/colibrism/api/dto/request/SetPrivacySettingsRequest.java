package ru.java3000.colibrism.api.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SetPrivacySettingsRequest {
    String session_id;    //Access token ID	E.g. de25cc16eb00960f076...
    String profile_visibility;    //Profile access privacy	E.g. One of these options (followers/everyone)
    String contact_privacy;    //Direct message privacy	E.g. One of these options (followed/everyone)
    String follow_privacy;    //Follow request privacy	E.g. One of these options (approved/everyone)
    String search_visibility;    //Profile search indexing privacy	E.g. One of these options (Y/N)
}
