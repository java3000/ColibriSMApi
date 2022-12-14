package ru.java3000.colibrism.api.retrofit;

import retrofit2.Call;
import retrofit2.http.*;
import ru.java3000.colibrism.api.dto.entity.Thread;
import ru.java3000.colibrism.api.dto.entity.*;
import ru.java3000.colibrism.api.dto.response.Response;

import java.net.URL;
import java.util.List;

public interface ColibriSM {

    String API_PREFIX = "/mobile_api/";

    @FormUrlEncoded
    @POST(API_PREFIX + "login")
    Call<Response<UserWrapper>> login(@Field("email") String email,
                                      @Field("password") String password,
                                      @Field("device_type") String deviceType);

    @FormUrlEncoded
    @POST(API_PREFIX + "oauth")
    Call<Response<UserWrapper>> socialLogin(@Field("access_token") String accessToken,
                                            @Field("type") String type,
                                            @Field("device_type") String deviceType);

    @FormUrlEncoded
    @POST(API_PREFIX + "signup")
    Call<Response<Void>> signup(@Field("first_name") String firstName,
                                @Field("last_name") String lastName,
                                @Field("email") String email,
                                @Field("username") String userName,
                                @Field("password") String password);

    @FormUrlEncoded
    @POST(API_PREFIX + "resetpassword")
    Call<Response<Void>> resetPassword(@Field("email") String email);

    @GET(API_PREFIX + "feeds")
    Call<Response<Feeds>> feeds(@Query("offset") long offset,
                                @Query("session_id") String sessionId,
                                @Query("page_size") int pageSize);

    @FormUrlEncoded
    @POST(API_PREFIX + "profile_report")
    Call<Response<Void>> reportProfile(@Field("session_id") String sessionId,
                                       @Field("user_id") int userId,
                                       @Field("reason") int reason,
                                       @Field("comment") String comment);

    @FormUrlEncoded
    @POST(API_PREFIX + "block_user")
    Call<Response<Void>> toggleUserBlock(@Field("session_id") String sessionId,
                                         @Field("user_id") int userId);

    @FormUrlEncoded
    @POST(API_PREFIX + "save_pnotif_token")
    Call<Response<Void>> savePushNotificationToken(@Field("session_id") String sessionId,
                                                   @Field("token") String token,
                                                   @Field("type") String type);

    @FormUrlEncoded
    @POST(API_PREFIX + "change_password")
    Call<Response<Void>> changePassword(@Field("session_id") String sessionId,
                                        @Field("old_password") String oldPassword,
                                        @Field("new_password") String newPassword);

    @FormUrlEncoded
    @POST(API_PREFIX + "refresh_access_token")
    Call<Response<Auth>> refreshAccessToken(@Field("refresh_token") String refreshToken);

    @FormUrlEncoded
    @POST(API_PREFIX + "logout")
    Call<Response<Object>> logout(@Field("session_id") String sessionId);

    @FormUrlEncoded
    @POST(API_PREFIX + "verify_user")
    Call<Response<Verification>> verifyUser(@Field("session_id") String sessionId,
                                            @Field("text_message") String textMessage,
                                            @Field("video_message") String videoMessage,
                                            @Field("full_name") String fullName);

    @FormUrlEncoded
    @POST(API_PREFIX + "vote_polls")
    Call<Response<PollData>> votePoll(@Field("session_id") String sessionId,
                                      @Field("post_id") int postId,
                                      @Field("poll_id") int pollId);

    @FormUrlEncoded
    @POST(API_PREFIX + "like_post")
    Call<Response<Like>> toggleLike(@Field("session_id") String sessionId,
                                    @Field("post_id") int postId);

    @FormUrlEncoded
    @POST(API_PREFIX + "publication_report")
    Call<Response<Void>> reportPost(@Field("session_id") String sessionId,
                                    @Field("post_id") int postId,
                                    @Field("reason") int reason,
                                    @Field("comment") String comment);

    @FormUrlEncoded
    @POST(API_PREFIX + "publication_repost")
    Call<Response<Reposts>> repost(@Field("session_id") String sessionId,
                                   @Field("post_id") int postId);

    @GET(API_PREFIX + "fetch_likes")
    Call<Response<List<User>>> fetchLikes(@Query("session_id") String sessionId,
                                          @Query("post_id") int postId,
                                          @Query("page_size") int pageSize,
                                          @Query("offset") int offset);

    @FormUrlEncoded
    @POST(API_PREFIX + "delete_post")
    Call<Response<Void>> deletePost(@Field("session_id") String sessionId,
                                    @Field("post_id") int postId);

    @GET(API_PREFIX + "search_hashtags")
    Call<Response<List<HashTag>>> searchHashtag(@Query("session_id") String sessionId,
                                                @Query("query") String query,
                                                @Query("offset") int offset,
                                                @Query("page_size") int pageSize);

    @GET(API_PREFIX + "search_people")
    Call<Response<List<User>>> searchPeople(@Query("session_id") String sessionId,
                                            @Query("query") String query,
                                            @Query("offset") int offset,
                                            @Query("page_size") int pageSize);

    @GET(API_PREFIX + "search_posts")
    Call<Response<List<Post>>> searchPost(@Query("session_id") String sessionId,
                                          @Query("query") String query,
                                          @Query("offset") int offset,
                                          @Query("page_size") int pageSize);

    @FormUrlEncoded
    @POST(API_PREFIX + "gen_settings")
    Call<Response<User>> updateProfile(@Field("session_id") String sessionId,
                                       @Field("first_name") String firstName,
                                       @Field("last_name") String lastName,
                                       @Field("about") String about,
                                       @Field("gender") String gender,
                                       @Field("email") String email,
                                       @Field("username") String username,
                                       @Field("website") URL website,
                                       @Field("country_id") int countryId);

    @FormUrlEncoded
    @POST(API_PREFIX + "follow")
    Call<Response<Follow>> toggleFollow(@Field("session_id") String sessionId,
                                        @Field("user_id") int userId);

    @GET(API_PREFIX + "fetch_following")
    Call<Response<List<User>>> fetchFollowing(@Query("session_id") String sessionId,
                                              @Query("user_id") int userId,
                                              @Query("offset") int offset,
                                              @Query("page_size") int pageSize);

    @GET(API_PREFIX + "fetch_followers")
    Call<Response<List<User>>> fetchFollowers(@Query("session_id") String sessionId,
                                              @Query("user_id") int userId,
                                              @Query("offset") int offset,
                                              @Query("page_size") int pageSize);

    @GET(API_PREFIX + "get_notifications")
    Call<Response<List<Notification>>> getNotifications(@Query("session_id") String sessionId,
                                                        @Query("type") String type,
                                                        @Query("page_size") int pageSize,
                                                        @Query("offset") int offset);

    @FormUrlEncoded
    @POST(API_PREFIX + "delete_notifs")
    Call<Response<Void>> deleteNotifications(@Field("session_id") String sessionId,
                                             @Field("scope") int[] scope);

    @FormUrlEncoded
    @POST(API_PREFIX + "delete_account")
    Call<Response<Void>> deleteAccount(@Field("session_id") String sessionId,
                                       @Field("password") String password);

    @FormUrlEncoded
    @POST(API_PREFIX + "language")
    Call<Response<Void>> changeLanguage(@Field("session_id") String sessionId,
                                        @Field("lang_name") String langName);

    @GET(API_PREFIX + "profile")
    Call<Response<User>> getProfile(@Query("session_id") String sessionId,
                                    @Query("user_id") int userId,
                                    @Query("username") String username);

    @GET(API_PREFIX + "profile_posts")
    Call<Response<Posts>> getProfilePosts(@Query("session_id") String sessionId,
                                          @Query("user_id") int userId,
                                          @Query("type") String type,
                                          @Query("offset") int offset,
                                          @Query("page_size") int pageSize);

    @FormUrlEncoded
    @POST(API_PREFIX + "upload_post_media")
    Call<Response<Media>> uploadPostMedia(@Field("session_id") String sessionId,
                                          @Field("type") String type,
                                          @Field("file") byte[] file);

    @FormUrlEncoded
    @POST(API_PREFIX + "delete_post_media")
    Call<Response<Void>> deletePostMedia(@Field("session_id") String sessionId,
                                         @Field("type") String type,
                                         @Field("media_id") int mediaId);

    @FormUrlEncoded
    @POST(API_PREFIX + "publish_post")
    Call<Response<Post>> publishPost(@Field("session_id") String sessionId,
                                     @Field("post_text") String postText,
                                     @Field("thread_id") int threadId,
                                     @Field("gif_src") URL gifSrc,
                                     @Field("og_data") String ogData,
                                     @Field("poll_data") String pollData,
                                     @Field("privacy") String privacy);

    @FormUrlEncoded
    @POST(API_PREFIX + "change_post_privacy")
    Call<Response<Void>> changePostPrivacy(@Field("privacy") String sessionId,
                                           @Field("privacy") int postId,
                                           @Field("privacy") String privacy);

    //TODO this, upload video and upload image - one and only method! Refactor this!
    @FormUrlEncoded
    @POST(API_PREFIX + "upload_swift_media")
    Call<Response<SwiftMedia>> uploadSwiftMedia(@Field("session_id") String sessionId,
                                                @Field("type") String type,
                                                @Field("file") byte[] file);

    @FormUrlEncoded
    @POST(API_PREFIX + "delete_swift_media")
    Call<Response<Void>> deleteSwiftMedia(@Field("session_id") String sessionId);

    @FormUrlEncoded
    @POST(API_PREFIX + "publish_swift")
    Call<Response<Void>> publishSwift(@Field("session_id") String sessionId,
                                      @Field("swift_text") String swiftText);

    @FormUrlEncoded
    @POST(API_PREFIX + "delete_swift")
    Call<Response<Void>> deleteSwift(@Field("session_id") String sessionId,
                                     @Field("swid") String swiftId);

    @GET(API_PREFIX + "get_swifts")
    Call<Response<List<User>>> getSwifts(@Query("session_id") String sessionId);

    @FormUrlEncoded
    @POST(API_PREFIX + "reg_swift_view")
    Call<Response<Void>> registerSwiftView(@Field("session_id") String sessionId,
                                           @Field("user_id") int userId,
                                           @Field("username") String swiftId);

    @GET(API_PREFIX + "thread_data")
    Call<Response<Thread>> fetchThreadData(@Query("session_id") String sessionId,
                                           @Query("thread_id") int threadId);

    @GET(API_PREFIX + "thread_replys")
    Call<Response<List<Post>>> fetchThreadReplies(@Query("session_id") String sessionId,
                                                  @Query("thread_id") int threadId,
                                                  @Query("page_size") int pageSize,
                                                  @Query("offset") int offset);

    @GET(API_PREFIX + "get_bookmarks")
    Call<Response<List<Post>>> getBookmarks(@Query("session_id") String sessionId,
                                            @Query("page_size") int pageSize,
                                            @Query("offset") int offset);

    @FormUrlEncoded
    @POST(API_PREFIX + "add_bookmark")
    Call<Response<Bookmark>> toggleBookmark(@Field("session_id") String sessionId,
                                            @Field("post_id") int postId);

    @FormUrlEncoded
    @POST(API_PREFIX + "avatar")
    Call<Response<Avatar>> changeAvatar(@Field("session_id") String sessionId,
                                        @Field("avatar") byte[] avatar);

    @FormUrlEncoded
    @POST(API_PREFIX + "cover")
    Call<Response<Cover>> changeCover(@Field("session_id") String sessionId,
                                      @Field("cover") byte[] cover);

    @FormUrlEncoded
    @POST(API_PREFIX + "cover_reposition")
    Call<Response<Cover>> coverReposition(@Field("session_id") String sessionId,
                                          @Field("cover_position") int coverPosition);

    @GET(API_PREFIX + "get_priv_settings")
    Call<Response<PrivacySettings>> getPrivacySettings(@Query("session_id") String sessionId);

    @FormUrlEncoded
    @POST(API_PREFIX + "set_priv_settings")
    Call<Response<Void>> setPrivacySettings(@Field("session_id") String sessionId,
                                            @Field("profile_visibility") String profileVisibility,
                                            @Field("contact_privacy") String contactPrivacy,
                                            @Field("follow_privacy") String followPrivacy,
                                            @Field("search_visibility") String searchVisibility);

    @GET(API_PREFIX + "follow_requests")
    Call<Response<List<User>>> followRequests(@Query("session_id") String sessionId,
                                              @Query("offset") int offset,
                                              @Query("page_size") int pageSize);

    @FormUrlEncoded
    @POST(API_PREFIX + "accept_follow")
    Call<Response<ApprovedRequests>> approveFollowRequest(@Field("session_id") String sessionId,
                                                          @Field("req_id") int requestId);

    @FormUrlEncoded
    @POST(API_PREFIX + "ignore_follow")
    Call<Response<ApprovedRequests>> ignoreFollowRequest(@Field("session_id") String sessionId,
                                                         @Field("req_id") int requestId);

    @FormUrlEncoded
    @POST(API_PREFIX + "send_message")
    Call<Response<Message>> sendMessage(@Field("session_id") String sessionId,
                                        @Field("user_id") int userId,
                                        @Field("type") String type,
                                        @Field("image") byte[] image,
                                        @Field("message") String message);

    @GET(API_PREFIX + "get_chats")
    Call<Response<List<User>>> getChats(@Query("session_id") String sessionId);

    @GET(API_PREFIX + "get_messages")
    Call<Response<List<Message>>> getMessages(@Query("session_id") String sessionId,
                                              @Query("user_id") int userId,
                                              @Query("offset_up") int offsetUp,
                                              @Query("offset_down") int offsetDown,
                                              @Query("page_size") int pageSize);

    @GET(API_PREFIX + "search_messages")
    Call<Response<List<Message>>> searchMessages(@Query("session_id") String sessionId,
                                                 @Query("user_id") int userId,
                                                 @Query("query") String query,
                                                 @Query("offset_up") int offsetUp,
                                                 @Query("offset_down") int offsetDown,
                                                 @Query("page_size") int pageSize);

    @FormUrlEncoded
    @POST(API_PREFIX + "delete_message")
    Call<Response<Void>> deleteMessage(@Field("session_id") String sessionId,
                                       @Field("message_id") int messageId);

    @FormUrlEncoded
    @POST(API_PREFIX + "clear_chat")
    Call<Response<Void>> clearChat(@Field("session_id") String sessionId,
                                   @Field("user_id") int userId,
                                   @Field("delete_chat") int deleteChat);

}
