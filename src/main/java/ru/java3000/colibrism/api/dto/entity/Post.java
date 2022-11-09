package ru.java3000.colibrism.api.dto.entity;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.net.URL;
import java.util.List;
import java.util.Optional;

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
    String target;
    @SerializedName("og_data")
    String ogData;
    String time;
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
    URL ogImage;
    URL url;
    @SerializedName("can_delete")
    boolean canSelete;
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
}
