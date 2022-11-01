package ru.java3000.colibrism.api.retrofit;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import ru.java3000.colibrism.api.dto.entity.*;
import ru.java3000.colibrism.api.dto.entity.Thread;
import ru.java3000.colibrism.api.dto.request.*;
import ru.java3000.colibrism.api.dto.response.*;

import java.util.List;

public interface ColibriSM {

    String API_PREFIX = "/mobile_api/";

    @FormUrlEncoded
    @POST(API_PREFIX + "login")
    Call<Response<User>> login(@Body LoginRequest loginRequest);

    @FormUrlEncoded
    @POST(API_PREFIX + "oauth")
    Call<Response<User>> socialLogin(@Body SocialLoginRequest login);

    @FormUrlEncoded
    @POST(API_PREFIX + "signup")
    Call<Response<List<Object>>> signup(@Body SignUpRequest signUpRequest);

    @FormUrlEncoded
    @POST(API_PREFIX + "resetpassword")
    Call<Response<List<Object>>> resetPassword(@Body ResetPasswordRequest request);

    @FormUrlEncoded
    @POST(API_PREFIX + "feeds")
    Call<Response<Feeds>> feeds(@Body FeedsRequest request);

    @FormUrlEncoded
    @POST(API_PREFIX + "profile_report")
    Call<Response<List<Object>>> reportProfile(@Body ReportUserRequest reportUserRequest);

    @FormUrlEncoded
    @POST(API_PREFIX + "block_user")
    Call<Response<List<Object>>> toggleUserBlock(@Body ToggleBlockRequest request);

    @FormUrlEncoded
    @POST(API_PREFIX + "save_pnotif_token")
    Call<Response<List<Object>>> savePushNotificationToken(@Body PushNotificationsRequest request);

    @FormUrlEncoded
    @POST(API_PREFIX + "change_password")
    Call<Response<List<Object>>> changePassword(@Body ChangePasswordRequest request);

    @FormUrlEncoded
    @POST(API_PREFIX + "refresh_access_token")
    Call<Response<Object>> refreshAccessToken(@Body RefreshAccessTokenRequest request);

    @FormUrlEncoded
    @POST(API_PREFIX + "logout")
    Call<Response<List<Object>>> logout(@Body LogoutRequest request);

    @FormUrlEncoded
    @POST(API_PREFIX + "verify_user")
    Call<Response<Verification>> verifyUser(@Body VerifyUserRequest request);

    @FormUrlEncoded
    @POST(API_PREFIX + "vote_polls")
    Call<Response<PollData>> votePoll(@Body VoteRequest request);

    @FormUrlEncoded
    @POST(API_PREFIX + "like_post")
    Call<Response<Like>> toggleLike(@Body ToggleLikeRequest request);

    @FormUrlEncoded
    @POST(API_PREFIX + "publication_report")
    Call<Response<List<Object>>> reportPost(@Body ReportPostRequest post);

    @FormUrlEncoded
    @POST(API_PREFIX + "publication_repost")
    Call<Response<Reposts>> repost(@Body RepostRequest request);

    @FormUrlEncoded
    @POST(API_PREFIX + "fetch_likes")
    Call<Response<List<User>>> fetchLikes(@Body FetchLikesRequest request);

    @FormUrlEncoded
    @POST(API_PREFIX + "delete_post")
    Call<Response<List<Object>>> deletePost(@Body DeletePostRequest request);

    @FormUrlEncoded
    @POST(API_PREFIX + "search_hashtags")
    Call<Response<List<HashTag>>> searchHashtag(@Body SearchHashtagRequest request);

    @FormUrlEncoded
    @POST(API_PREFIX + "search_people")
    Call<Response<List<User>>> searchPeople(@Body SearchPeopleRequest request);

    @FormUrlEncoded
    @POST(API_PREFIX + "search_posts")
    Call<Response<List<Post>>> searchPost(@Body SearchPostRequest request);

    @FormUrlEncoded
    @POST(API_PREFIX + "gen_settings")
    Call<Response<User>> updateProfile(@Body UpdateProfileRequest request);

    @FormUrlEncoded
    @POST(API_PREFIX + "follow")
    Call<Response<Follow>> toggleFollow(@Body ToggleFollowRequest request);

    @FormUrlEncoded
    @POST(API_PREFIX + "fetch_following")
    Call<Response<List<User>>> fetchFollowing(@Body FetchFollowingRequest request);

    @FormUrlEncoded
    @POST(API_PREFIX + "fetch_followers")
    Call<Response<List<User>>> fetchFollowers(@Body FetchFollowersRequest request);

    @FormUrlEncoded
    @POST(API_PREFIX + "get_notifications")
    Call<Response<List<Notification>>> getNotifications(@Body GetNotificationRequest request);

    @FormUrlEncoded
    @POST(API_PREFIX + "delete_notifs")
    Call<Response<List<Object>>> deleteNotifications(@Body DeleteNotificationsRequest request);

    @FormUrlEncoded
    @POST(API_PREFIX + "delete_account")
    Call<Response<List<Object>>> deleteAccount(@Body DeleteAccountRequest request);

    @FormUrlEncoded
    @POST(API_PREFIX + "language")
    //todo creat entity from objects
    Call<Response<List<Object>>> changeLanguage(@Body ChangeLanguageRequest request);

    @FormUrlEncoded
    @POST(API_PREFIX + "profile")
    Call<Response<User>> getProfile(@Body GetProfileRequest request);

    @FormUrlEncoded
    @POST(API_PREFIX + "profile_posts")
    Call<Response<Posts>> getProfilePosts(@Body GetProfilePostsRequest request);

    @FormUrlEncoded
    @POST(API_PREFIX + "upload_post_media")
    Call<Response<Image>> uploadPostImageMedia(@Body UploadPostMediaRequest request);

    @FormUrlEncoded
    @POST(API_PREFIX + "upload_post_media")
    Call<Response<Video>> uploadPostVideoMedia(@Body UploadPostMediaRequest request);

    @FormUrlEncoded
    @POST(API_PREFIX + "delete_post_media")
    Call<Response<List<Object>>> deletePostMedia(@Body DeletePostMediaRequest request);

    @FormUrlEncoded
    @POST(API_PREFIX + "publish_post")
    Call<Response<Post>> publishPost(@Body PublishPostRequest request);

    @FormUrlEncoded
    @POST(API_PREFIX + "change_post_privacy")
    Call<Response<List<Object>>> changePostPrivacy(@Body ChangePostPrivacyRequest request);

    @FormUrlEncoded
    @POST(API_PREFIX + "upload_swift_media")
    Call<Response<SwiftMedia>> uploadSwiftMedia(@Body UploadSwiftMediaRequest request);

    @FormUrlEncoded
    @POST(API_PREFIX + "delete_swift_media")
    Call<Response<List<Object>>> deleteSwiftMedia(@Body DeleteSwiftMediaRequest request);

    @FormUrlEncoded
    @POST(API_PREFIX + "publish_swift")
    Call<Response<List<Object>>> publishSwift(@Body PublishSwiftRequest request);

    @FormUrlEncoded
    @POST(API_PREFIX + "delete_swift")
    Call<Response<List<Object>>> deleteSwift(@Body DeleteSwiftRequest request);

    @FormUrlEncoded
    @POST(API_PREFIX + "get_swifts")
    Call<Response<List<User>>> getSwifts(@Body GetSwiftsRequest request);

    @FormUrlEncoded
    @POST(API_PREFIX + "reg_swift_view")
    Call<Response<List<Object>>> registerSwiftView(@Body RegisterSwiftViewRequest request);

    @FormUrlEncoded
    @POST(API_PREFIX + "thread_data")
    Call<Response<Thread>> fetchThreadData(@Body FetchThreadDataRequest request);

    @FormUrlEncoded
    @POST(API_PREFIX + "thread_replys")
    Call<Response<List<Reply>>> fetchThreadReplies(@Body FetchThreadRepliesRequest request);

    @FormUrlEncoded
    @POST(API_PREFIX + "get_bookmarks")
    Call<Response<List<Post>>> getBookmarks(@Body GetBookmarksRequest request);

    @FormUrlEncoded
    @POST(API_PREFIX + "add_bookmark")
    Call<Response<Bookmark>> toggleBookmark(@Body AddBookmarkRequest request);

    @FormUrlEncoded
    @POST(API_PREFIX + "avatar")
    Call<Response<Avatar>> changeAvatar(@Body ChangeAvatarRequest request);

    @FormUrlEncoded
    @POST(API_PREFIX + "cover")
    Call<Response<Cover>> changeCover(@Body ChangeCoverRequest request);

    @FormUrlEncoded
    @POST(API_PREFIX + "cover_reposition")
    Call<Response<Cover>> coverReposition(@Body CoverRepositionRequest request);

    @FormUrlEncoded
    @POST(API_PREFIX + "get_priv_settings")
    Call<Response<PrivacySettings>> getPrivacySettings(@Body GetPrivacySettingsRequest request);

    @FormUrlEncoded
    @POST(API_PREFIX + "set_priv_settings")
    Call<Response<List<Object>>> setPrivacySettings(@Body SetPrivacySettingsRequest request);

    @FormUrlEncoded
    @POST(API_PREFIX + "follow_requests")
    Call<Response<List<User>>> followRequests(@Body FollowRequestsRequest request);

    @FormUrlEncoded
    @POST(API_PREFIX + "accept_follow")
    Call<Response<ApprovedRequests>> approveFollowRequest(@Body ApproveFollowRequestRequest request);

    @FormUrlEncoded
    @POST(API_PREFIX + "ignore_follow")
    Call<Response<ApprovedRequests>> ignoreFollowRequest(@Body IgnoreFollowRequestRequest request);

    @FormUrlEncoded
    @POST(API_PREFIX + "send_message")
    Call<Response<Message>> sendMessage(@Body SendMessageRequest request);

    @FormUrlEncoded
    @POST(API_PREFIX + "get_chats")
    Call<Response<List<User>>> getChats(@Body GetChatsRequest request);

    @FormUrlEncoded
    @POST(API_PREFIX + "get_messages")
    Call<Response<List<Message>>> getMessages(@Body GetMessagesRequest request);

    @FormUrlEncoded
    @POST(API_PREFIX + "search_messages")
    Call<Response<List<Message>>> searchMessages(@Body SearchMessagesRequest request);

    @FormUrlEncoded
    @POST(API_PREFIX + "delete_message")
    Call<Response<List<Object>>> deleteMessage(@Body DeleteMessageRequest request);

    @FormUrlEncoded
    @POST(API_PREFIX + "clear_chat")
    Call<Response<List<Object>>> clearChat(@Body ClearChatRequest request);

}
