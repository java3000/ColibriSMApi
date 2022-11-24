package ru.java3000.colibrism.api.dto.entity;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.net.URL;
import java.util.List;

@SuppressWarnings("SpellCheckingInspection")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Post {
    long id;
    @SerializedName("user_id")
    long userId;
    String text;
    String type;
    @SerializedName("replys_count")
    int replysCount;
    @SerializedName("reposts_count")
    int repostsCount;
    @SerializedName("likes_count")
    int likesCount;
    String status; //?
    @SerializedName("thread_id")
    long threadId;
    String target; //"target": "publication",
    @SerializedName("og_data")
    Object ogData; //todo can be string and oject!! "og_data": "", "og_data": {"title": "...","type": "article", "image_loc": true }
    String time; //"time": "14 Ноября, 21:38",
    @SerializedName("offset_id")
    int offsetId; //?
    @SerializedName("is_repost")
    boolean isRepost;
    @SerializedName("is_reposter")
    boolean isReposter;
    String attrs;
    boolean advertising;
    @SerializedName("time_raw")
    long timeRaw;
    @SerializedName("og_text")
    String ogText;
    @SerializedName("og_image")
    String ogImage;
    URL url;
    @SerializedName("can_delete")
    boolean canDelete;
    List<Media> media;
    @SerializedName("is_owner")
    boolean isOwner;
    @SerializedName("has_liked")
    boolean hasLiked;
    @SerializedName("has_saved")
    boolean hasSaved;
    @SerializedName("has_reposted")
    boolean hasReposted;
    @SerializedName("reply_to")
    List<User> replyTo;
    List<Object> replys; //[], ????
    User owner;

    //new in rutvit
    @SerializedName("poll_data")
    PollData pollData;
    @SerializedName("priv_wcs")
    String privWcs; //? "priv_wcs": "everyone",
    @SerializedName("priv_wcr")
    String privWcr; //? "priv_wcr": "everyone",
    String edited; //"edited": "0",
    @SerializedName("is_hide")
    int isHide; // "is_hide": 0,
    @SerializedName("htags")
    List<HashTag> hashTags;
    @SerializedName("can_edit")
    boolean canEdit;
    @SerializedName("is_blocked")
    boolean isBlocked;
    @SerializedName("is_reported")
    boolean isReported;
    @SerializedName("me_blocked")
    boolean meBlocked;
    @SerializedName("can_see")
    boolean canSee;
}
