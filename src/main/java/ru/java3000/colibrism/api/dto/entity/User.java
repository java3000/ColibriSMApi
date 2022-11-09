package ru.java3000.colibrism.api.dto.entity;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.net.URL;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @SerializedName(value="id", alternate={"user_id"})
    int id;
    @SerializedName(value="first_name", alternate={"fname"})
    String firstName;
    @SerializedName(value="last_name", alternate={"lname"})
    String lastName;
    @SerializedName(value="user_name", alternate={"username", "name"})
    String userName;
    String email;
    @SerializedName(value="is_verified", alternate={"verified"})
    String isVerified;
    String website;
    @SerializedName(value="about_you", alternate={"about"})
    String about;
    String gender;
    String country;
    @SerializedName(value="post_count", alternate={"posts"})
    int postCount;
    @SerializedName(value="last_post")
    int lastPost; //?
    @SerializedName(value="last_ad")
    int lastAd; //?
    String language;
    @SerializedName(value="following_count", alternate={"followings"})
    int followingCount;
    @SerializedName(value="follower_count", alternate={"followers"})
    int followerCount;
    float wallet; //?
    @SerializedName(value="ip_address", alternate={"ipaddress"})
    String ipaddress;
    @SerializedName(value="last_active")
    String lastActive; //?
    @SerializedName(value="member_since")
    String memberSince;
    @SerializedName(value="profile_privacy")
    String profilePrivacy; //?
    Auth auth;
    URL avatar;
    URL url;
    @SerializedName(value="is_user")
    boolean isUser;
    @SerializedName(value="is_following")
    boolean isFollowing;
    List<Swift> swift;
    @SerializedName(value="chat_id")
    int chatId;
    String time;
    @SerializedName(value="last_message")
    String lastMessage;
    @SerializedName(value="new_messages")
    String newMessages;
    @SerializedName(value="chat_url")
    URL chatUrl;
    @SerializedName(value="offset_id")
    int offsetId;
    @SerializedName(value="follow_privacy")
    String followPrivacy;
    @SerializedName(value="follow_requested")
    boolean followRequested;
    @SerializedName(value="pending_req")
    boolean pendingReq;
    URL cover;
    @SerializedName(value="is_blocked_visitor")
    boolean isBlockedVisitor;
    @SerializedName(value="can_view_profile")
    boolean canViewProfile;
    @SerializedName(value="is_owner")
    boolean isOwner;
    @SerializedName(value="thread_url")
    URL threadUrl;
}
