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
    int lastPost; //?
    int lastAd; //?
    String language;
    @SerializedName(value="following_count", alternate={"followings"})
    int followingCount;
    @SerializedName(value="follower_count", alternate={"followers"})
    int followerCount;
    float wallet; //?
    @SerializedName(value="ip_address", alternate={"ipaddress"})
    String ipaddress;
    String lastActive; //?
    String memberSince;
    String profilePrivacy; //?
    String authToken;
    String refreshToken;
    long authTokenExpiry;
    URL avatar; //todo replace all string to url in other places
    URL url;
    boolean isUser;
    boolean isFollowing;
    List<Swift> swift;
    int chatId;
    String time;
    String lastMessage;
    String newMessages;
    URL chatUrl;
    int offsetId;
    String followPrivacy;
    boolean followRequested;
    boolean pendingReq;
    URL cover;
    boolean isBlockedVisitor;
    boolean canViewProfile;
    boolean isOwner;
    URL threadUrl;
}
