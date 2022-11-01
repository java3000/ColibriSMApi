package ru.java3000.colibrism.api;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import ru.java3000.colibrism.api.retrofit.ColibriSM;
import ru.java3000.colibrism.api.dto.entity.Thread;
import ru.java3000.colibrism.api.dto.entity.*;
import ru.java3000.colibrism.api.dto.request.*;
import ru.java3000.colibrism.api.dto.response.*;
import ru.java3000.colibrism.api.exception.*;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.logging.Logger;

public class ApiClient {
    private final ColibriSM service;

    private static final Logger logger = Logger.getLogger("ApiClient");
    private HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();


    public ApiClient(String server) {
        this(server, HttpLoggingInterceptor.Level.NONE);
    }

    public ApiClient(String server, HttpLoggingInterceptor.Level logLevel) {

        interceptor.setLevel(logLevel);
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();
        
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(server)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        service = retrofit.create(ColibriSM.class);
    }

    public Response<User> login(String email, String password) throws ApiException {
        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setEmail(email);
        loginRequest.setPassword(password);
        loginRequest.setDevice_type("android");

        Call<Response<User>> request = service.login(loginRequest);

        return callService(request);
    }

    public Response<List<Object>> logout(String session_id) throws ApiException {
        LogoutRequest request = new LogoutRequest(session_id);

        Call<Response<List<Object>>> logoutResponse = service.logout(request);

        return callService(logoutResponse);
    }

    public Response<User> socialLogin(String token, String type) throws ApiException {
        SocialLoginRequest loginRequest = new SocialLoginRequest();
        loginRequest.setAccess_token(token);
        loginRequest.setType(type);
        loginRequest.setDevice_type("android");

        Call<Response<User>> request = service.socialLogin(loginRequest);

        return callService(request);
    }

    public Response<List<Object>> signUp(String email, String username, String password, String firstName, String lastName) throws ApiException {
        SignUpRequest signUpRequest = new SignUpRequest();
        signUpRequest.setEmail(email);
        signUpRequest.setPassword(password);
        signUpRequest.setUsername(username);
        signUpRequest.setLast_name(lastName);
        signUpRequest.setFirst_name(firstName);

        Call<Response<List<Object>>> signup = service.signup(signUpRequest);

        return callService(signup);
    }

    public Response<List<Object>> resetPassword(String email) throws ApiException {
        ResetPasswordRequest resetPasswordRequest = new ResetPasswordRequest();
        resetPasswordRequest.setEmail(email);

        Call<Response<List<Object>>> resetPasswordResponseCall = service.resetPassword(resetPasswordRequest);

        return callService(resetPasswordResponseCall);
    }

    public Response<Feeds> feeds(String sessionId, int offset, int pageSize) throws ApiException {
        FeedsRequest feedsRequest = new FeedsRequest();
        feedsRequest.setSession_id(sessionId);
        feedsRequest.setOffset(offset);
        feedsRequest.setPage_size(pageSize);

        Call<Response<Feeds>> feeds = service.feeds(feedsRequest);

        return callService(feeds);
    }

    public Response<List<Object>> reportUser(int userId, String sessionId, int reason, String comment) throws ApiException {
        ReportUserRequest reportUserRequest = new ReportUserRequest();
        reportUserRequest.setUser_id(userId);
        reportUserRequest.setSession_id(sessionId);
        reportUserRequest.setReason(reason);
        reportUserRequest.setComment(comment);

        Call<Response<List<Object>>> reportUserResponseCall = service.reportProfile(reportUserRequest);

        return callService(reportUserResponseCall);
    }

    public Response<List<Object>> toggleBlockUser(int userId, String sessionId) throws ApiException {
        ToggleBlockRequest toggleBlockRequest = new ToggleBlockRequest();
        toggleBlockRequest.setUser_id(userId);
        toggleBlockRequest.setSession_id(sessionId);

        Call<Response<List<Object>>> toggleBlockResponseCall = service.toggleUserBlock(toggleBlockRequest);

        return callService(toggleBlockResponseCall);
    }

    public Response<List<Object>> savePushNotificationToken(String sessionId, String type, String token) throws ApiException {
        PushNotificationsRequest pushNotificationsRequest = new PushNotificationsRequest();
        pushNotificationsRequest.setSession_id(sessionId);
        pushNotificationsRequest.setType(type);
        pushNotificationsRequest.setToken(token);

        Call<Response<List<Object>>> pushNotificationResponseCall = service.savePushNotificationToken(pushNotificationsRequest);

        return callService(pushNotificationResponseCall);
    }

    public Response<List<Object>> changePassword(String sessionId, String newPassword, String oldPassword) throws ApiException {
        ChangePasswordRequest request = new ChangePasswordRequest();
        request.setSession_id(sessionId);
        request.setNew_password(newPassword);
        request.setOld_password(oldPassword);

        Call<Response<List<Object>>> changePasswordResponseCall = service.changePassword(request);

        return callService(changePasswordResponseCall);
    }

    public Response<Object> refreshAccessToken(String token) throws ApiException {
        RefreshAccessTokenRequest request = new RefreshAccessTokenRequest();
        request.setRefresh_token(token);

        Call<Response<Object>> refreshAccessTokenResponseCall = service.refreshAccessToken(request);

        return callService(refreshAccessTokenResponseCall);
    }

    public Response<Verification> verifyUser(String sessionId, String fullName, String message, String video) throws ApiException {
        VerifyUserRequest request = new VerifyUserRequest();
        request.setSession_id(sessionId);
        request.setFull_name(fullName);
        request.setText_message(message);
        request.setVideo_message(video);

        Call<Response<Verification>> verifyUserResponseCall = service.verifyUser(request);

        return callService(verifyUserResponseCall);
    }

    public Response<PollData> votePoll(String token, int postId, int pollId) throws ApiException {
        VoteRequest request = new VoteRequest();
        request.setSession_id(token);
        request.setPost_id(postId);
        request.setPoll_id(pollId);

        Call<Response<PollData>> voteResponseCall = service.votePoll(request);

        return callService(voteResponseCall);
    }

    public Response<Like> toggleLike(String sessionId, int postId) throws ApiException {
        ToggleLikeRequest request = new ToggleLikeRequest();
        request.setSession_id(sessionId);
        request.setPost_id(postId);

        Call<Response<Like>> toggleLikeResponseCall = service.toggleLike(request);

        return callService(toggleLikeResponseCall);
    }

    public Response<List<Object>> reportPost(String sessionId, int postId, int reason, String comment) throws ApiException {
        ReportPostRequest request = new ReportPostRequest();
        request.setSession_id(sessionId);
        request.setPost_id(postId);
        request.setReason(reason);
        request.setComment(comment);

        Call<Response<List<Object>>> reportPostResponseCall = service.reportPost(request);

        return callService(reportPostResponseCall);
    }

    public Response<Reposts> repost(String sessionId, int postId) throws ApiException {
        RepostRequest request = new RepostRequest();
        request.setSession_id(sessionId);
        request.setPost_id(postId);

        Call<Response<Reposts>> repost = service.repost(request);

        return callService(repost);
    }

    public Response<List<User>> fetchLikes(String sessionId, int postId, int offset, int pageSize) throws ApiException {
        FetchLikesRequest request = new FetchLikesRequest();
        request.setSession_id(sessionId);
        request.setPost_id(postId);
        request.setOffset(offset);
        request.setPage_size(pageSize);

        Call<Response<List<User>>> fetchLikesResponseCall = service.fetchLikes(request);

        return callService(fetchLikesResponseCall);
    }

    public Response<List<Object>> deletePost(String sessionId, int postId) throws ApiException {
        DeletePostRequest request = new DeletePostRequest();
        request.setSession_id(sessionId);
        request.setPost_id(postId);

        Call<Response<List<Object>>> deletePostResponseCall = service.deletePost(request);

        return callService(deletePostResponseCall);
    }

    public Response<List<HashTag>> searchHashtag(String sessionId, String query, int offset, int pageSize) throws ApiException {
        SearchHashtagRequest request = new SearchHashtagRequest();
        request.setSession_id(sessionId);
        request.setQuery(query);
        request.setOffset(offset);
        request.setPage_size(pageSize);

        Call<Response<List<HashTag>>> searchHashtagResponseCall = service.searchHashtag(request);

        return callService(searchHashtagResponseCall);
    }

    public Response<List<User>> searchPeople(String sessionId, String query, int offset, int pageSize) throws ApiException {
        SearchPeopleRequest request = new SearchPeopleRequest();
        request.setSession_id(sessionId);
        request.setQuery(query);
        request.setOffset(offset);
        request.setPage_size(pageSize);

        Call<Response<List<User>>> searchPeopleResponseCall = service.searchPeople(request);

        return callService(searchPeopleResponseCall);
    }

    public Response<List<Post>> searchPost(String sessionId, String query, int offset, int pageSize) throws ApiException {
        SearchPostRequest request = new SearchPostRequest();
        request.setSession_id(sessionId);
        request.setQuery(query);
        request.setOffset(offset);
        request.setPage_size(pageSize);

        Call<Response<List<Post>>> searchPeopleResponseCall = service.searchPost(request);

        return callService(searchPeopleResponseCall);
    }

    public Response<User> updateProfile(String sessionId, String about, String userName,
                                                         String gender, String email, String firstName, String lastName, int countryId, URL website) throws ApiException {
        UpdateProfileRequest request = new UpdateProfileRequest();
        request.setSession_id(sessionId);
        request.setAbout(about);
        request.setUsername(userName);
        request.setGender(gender);
        request.setEmail(email);
        request.setFirst_name(firstName);
        request.setLast_name(lastName);
        request.setCountry_id(countryId);
        request.setWebsite(website);

        Call<Response<User>> updateProfileResponseCall = service.updateProfile(request);

        return callService(updateProfileResponseCall);
    }

    public Response<Follow> toggleFollow(String sessionId, int userId) throws ApiException {
        ToggleFollowRequest request = new ToggleFollowRequest();
        request.setSession_id(sessionId);
        request.setUser_id(userId);

        Call<Response<Follow>> toggleFollowResponseCall = service.toggleFollow(request);

        return callService(toggleFollowResponseCall);
    }

    public Response<List<User>> fetchFollowing(String sessionId, int userId, int offset, int pageSize) throws ApiException {
        FetchFollowingRequest request = new FetchFollowingRequest();
        request.setSession_id(sessionId);
        request.setUser_id(userId);
        request.setOffset(offset);
        request.setPage_size(pageSize);

        Call<Response<List<User>>> fetchFollowingResponseCall = service.fetchFollowing(request);

        return callService(fetchFollowingResponseCall);
    }

    public Response<List<User>> fetchFollowers(String sessionId, int userId, int offset, int pageSize) throws ApiException {
        FetchFollowersRequest request = new FetchFollowersRequest();
        request.setSession_id(sessionId);
        request.setUser_id(userId);
        request.setOffset(offset);
        request.setPage_size(pageSize);

        Call<Response<List<User>>> fetchFollowersResponseCall = service.fetchFollowers(request);

        return callService(fetchFollowersResponseCall);
    }

    public Response<List<Notification>> getNotifications(String sessionId, String type, int offset, int pageSize) throws ApiException {
        GetNotificationRequest request = new GetNotificationRequest();
        request.setSession_id(sessionId);
        request.setType(type);
        request.setOffset(offset);
        request.setPage_size(pageSize);

        Call<Response<List<Notification>>> notifications = service.getNotifications(request);

        return callService(notifications);
    }

    public Response<List<Object>> deleteNotifications(String sessionId, int... scope) throws ApiException {
        DeleteNotificationsRequest request = new DeleteNotificationsRequest();
        request.setSession_id(sessionId);
        request.setScope(scope);

        Call<Response<List<Object>>> deleteNotificationsResponseCall = service.deleteNotifications(request);

        return callService(deleteNotificationsResponseCall);
    }

    public Response<List<Object>> deleteAccount(String sessionId, String password) throws ApiException {
        DeleteAccountRequest request = new DeleteAccountRequest();
        request.setSession_id(sessionId);
        request.setPassword(password);

        Call<Response<List<Object>>> deleteAccountResponseCall = service.deleteAccount(request);

        return callService(deleteAccountResponseCall);
    }

    public Response<List<Object>> changeLanguage(String sessionId, String language) throws ApiException {
        ChangeLanguageRequest request = new ChangeLanguageRequest();
        request.setSession_id(sessionId);
        request.setLang_name(language);

        Call<Response<List<Object>>> changeLanguageResponseCall = service.changeLanguage(request);

        return callService(changeLanguageResponseCall);
    }

    public Response<User> getProfile(String sessionId, String userName, int userId) throws ApiException {
        GetProfileRequest request = new GetProfileRequest();
        request.setSession_id(sessionId);
        request.setUsername(userName);
        request.setUser_id(userId);

        Call<Response<User>> profile = service.getProfile(request);

        return callService(profile);
    }

    public Response<Posts> getProfilePosts(String sessionId, int userId, String type, int offset, int pageSize) throws ApiException {
        GetProfilePostsRequest request = new GetProfilePostsRequest();
        request.setSession_id(sessionId);
        request.setUser_id(userId);
        request.setType(type);
        request.setOffset(offset);
        request.setPage_size(pageSize);

        Call<Response<Posts>> profilePosts = service.getProfilePosts(request);

        return callService(profilePosts);
    }

    public Response<Image> uploadPostImageMedia(String sessionId, String type, byte[] file) throws ApiException {
        UploadPostMediaRequest request = new UploadPostMediaRequest();
        request.setSession_id(sessionId);
        request.setType(type);
        request.setFile(file);

        Call<Response<Image>> uploadPostMediaImageResponseCall = service.uploadPostImageMedia(request);

        return callService(uploadPostMediaImageResponseCall);
    }

    public Response<Video> uploadPostVideoMedia(String sessionId, String type, byte[] file) throws ApiException {
        UploadPostMediaRequest request = new UploadPostMediaRequest();
        request.setSession_id(sessionId);
        request.setType(type);
        request.setFile(file);

        Call<Response<Video>> uploadPostMediaVideoResponseCall = service.uploadPostVideoMedia(request);

        return callService(uploadPostMediaVideoResponseCall);
    }

    public Response<List<Object>> deletePostMedia(String sessionId, String type, int mediaId) throws ApiException {
        DeletePostMediaRequest request = new DeletePostMediaRequest();
        request.setSession_id(sessionId);
        request.setMedia_id(mediaId);
        request.setType(type);

        Call<Response<List<Object>>> deletePostMediaResponseCall = service.deletePostMedia(request);

        return callService(deletePostMediaResponseCall);
    }

    public Response<Post> publishPost(String sessionId, String text, String privacy, URL gif,
                                                       String og, String poll, int threadId) throws ApiException {
        PublishPostRequest request = new PublishPostRequest();
        request.setSession_id(sessionId);
        request.setPost_text(text);
        request.setPrivacy(privacy);
        request.setGif_src(gif);
        request.setOg_data(og);
        request.setPoll_data(poll);
        request.setThread_id(threadId);

        Call<Response<Post>> publishPostResponseCall = service.publishPost(request);

        return callService(publishPostResponseCall);
    }

    public Response<List<Object>> changePostPrivacy(String sessionId, int postId, String privacy) throws ApiException {
        ChangePostPrivacyRequest request = new ChangePostPrivacyRequest();
        request.setSession_id(sessionId);
        request.setPost_id(postId);
        request.setPrivacy(privacy);

        Call<Response<List<Object>>> changePostPrivacyResponseCall = service.changePostPrivacy(request);

        return callService(changePostPrivacyResponseCall);
    }

    public Response<SwiftMedia> uploadSwiftMedia(String sessionId, String type, byte[] file) throws ApiException {
        UploadSwiftMediaRequest request = new UploadSwiftMediaRequest();
        request.setSession_id(sessionId);
        request.setType(type);
        request.setFile(file);

        Call<Response<SwiftMedia>> uploadSwiftMediaResponseCall = service.uploadSwiftMedia(request);

        return callService(uploadSwiftMediaResponseCall);
    }

    public Response<List<Object>> deleteSwiftMedia(String sessionId) throws ApiException {
        DeleteSwiftMediaRequest request = new DeleteSwiftMediaRequest();
        request.setSession_id(sessionId);

        Call<Response<List<Object>>> deleteSwiftMediaResponseCall = service.deleteSwiftMedia(request);

        return callService(deleteSwiftMediaResponseCall);
    }

    public Response<List<Object>> publishSwift(String sessionId, String text) throws ApiException {
        PublishSwiftRequest request = new PublishSwiftRequest();
        request.setSession_id(sessionId);
        request.setSwift_text(text);

        Call<Response<List<Object>>> publishSwiftResponseCall = service.publishSwift(request);

        return callService(publishSwiftResponseCall);
    }

    public Response<List<Object>> deleteSwift(String sessionId, String swiftId) throws ApiException {
        DeleteSwiftRequest request = new DeleteSwiftRequest();
        request.setSession_id(sessionId);
        request.setSwid(swiftId);

        Call<Response<List<Object>>> deleteSwiftResponseCall = service.deleteSwift(request);

        return callService(deleteSwiftResponseCall);
    }

    public Response<List<User>> getSwifts(String sessionId) throws ApiException {
        GetSwiftsRequest request = new GetSwiftsRequest();
        request.setSession_id(sessionId);

        Call<Response<List<User>>> swifts = service.getSwifts(request);

        return callService(swifts);
    }

    public Response<List<Object>> registerSwiftView(String sessionId, int userId, String swiftId) throws ApiException {
        RegisterSwiftViewRequest request = new RegisterSwiftViewRequest();
        request.setSession_id(sessionId);
        request.setUser_id(userId);
        request.setSwid(swiftId);

        Call<Response<List<Object>>> registerSwiftViewResponseCall = service.registerSwiftView(request);

        return callService(registerSwiftViewResponseCall);
    }

    public Response<Thread> fetchThreadData(String sessionId, int threadId) throws ApiException {
        FetchThreadDataRequest request = new FetchThreadDataRequest();
        request.setSession_id(sessionId);
        request.setThread_id(threadId);

        Call<Response<Thread>> fetchThreadDataResponseCall = service.fetchThreadData(request);

        return callService(fetchThreadDataResponseCall);
    }

    public Response<List<Reply>> fetchThreadReplies(String sessionId, int threadId, int offset, int pageSize) throws ApiException {
        FetchThreadRepliesRequest request = new FetchThreadRepliesRequest();
        request.setSession_id(sessionId);
        request.setThread_id(threadId);
        request.setOffset(offset);
        request.setPage_size(pageSize);

        Call<Response<List<Reply>>> fetchThreadRepliesResponseCall = service.fetchThreadReplies(request);

        return callService(fetchThreadRepliesResponseCall);
    }

    public Response<List<Post>> getBookmarks(String sessionId, int offset, int pageSize) throws ApiException {
        GetBookmarksRequest request = new GetBookmarksRequest();
        request.setSession_id(sessionId);
        request.setOffset(offset);
        request.setPage_size(pageSize);

        Call<Response<List<Post>>> bookmarks = service.getBookmarks(request);

        return callService(bookmarks);
    }

    public Response<Bookmark> toggleBookmark(String sessionId, int postId) throws ApiException {
        AddBookmarkRequest request = new AddBookmarkRequest();
        request.setSession_id(sessionId);
        request.setPost_id(postId);

        Call<Response<Bookmark>> addBookmarkResponseCall = service.toggleBookmark(request);

        return callService(addBookmarkResponseCall);
    }

    public Response<Avatar> changeAvatar(String sessionId, byte[] avatar) throws ApiException {
        ChangeAvatarRequest request = new ChangeAvatarRequest();
        request.setSession_id(sessionId);
        request.setAvatar(avatar);

        Call<Response<Avatar>> changeAvatarResponseCall = service.changeAvatar(request);

        return callService(changeAvatarResponseCall);
    }

    public Response<Cover> changeCover(String sessionId, byte[] cover) throws ApiException {
        ChangeCoverRequest request = new ChangeCoverRequest();
        request.setSession_id(sessionId);
        request.setCover(cover);

        Call<Response<Cover>> changeAvatarResponseCall = service.changeCover(request);

        return callService(changeAvatarResponseCall);
    }

    public Response<Cover> coverReposition(String sessionId, int position) throws ApiException {
        CoverRepositionRequest request = new CoverRepositionRequest();
        request.setSession_id(sessionId);
        request.setCover_position(position);

        Call<Response<Cover>> coverRepositionResponseCall = service.coverReposition(request);

        return callService(coverRepositionResponseCall);
    }

    public Response<PrivacySettings> getPrivacySettings(String sessionId) throws ApiException {
        GetPrivacySettingsRequest request = new GetPrivacySettingsRequest();
        request.setSession_id(sessionId);

        Call<Response<PrivacySettings>> privacySettings = service.getPrivacySettings(request);

        return callService(privacySettings);
    }

    public Response<List<Object>> setPrivacySettings(String sessionId, String followPrivacy, String contentPrivacy,
                                                                 String profileVisibility, String searchVisibility) throws ApiException {
        SetPrivacySettingsRequest request = new SetPrivacySettingsRequest();
        request.setSession_id(sessionId);
        request.setFollow_privacy(followPrivacy);
        request.setContact_privacy(contentPrivacy);
        request.setProfile_visibility(profileVisibility);
        request.setSearch_visibility(searchVisibility);

        Call<Response<List<Object>>> setPrivacySettingsResponseCall = service.setPrivacySettings(request);

        return callService(setPrivacySettingsResponseCall);
    }

    public Response<List<User>> followRequests(String sessionId, int offset, int pageSize) throws ApiException {
        FollowRequestsRequest request = new FollowRequestsRequest();
        request.setSession_id(sessionId);
        request.setOffset(offset);
        request.setPage_size(pageSize);

        Call<Response<List<User>>> followRequestsResponseCall = service.followRequests(request);

        return callService(followRequestsResponseCall);
    }

    public Response<ApprovedRequests> approveFollowRequest(String sessionId, int requestId) throws ApiException {
        ApproveFollowRequestRequest request = new ApproveFollowRequestRequest();
        request.setSession_id(sessionId);
        request.setReq_id(requestId);

        Call<Response<ApprovedRequests>> approveFollowRequestResponseCall = service.approveFollowRequest(request);

        return callService(approveFollowRequestResponseCall);
    }

    public Response<ApprovedRequests> ignoreFollowRequest(String sessionId, int requestId) throws ApiException {
        IgnoreFollowRequestRequest request = new IgnoreFollowRequestRequest();
        request.setSession_id(sessionId);
        request.setReq_id(requestId);

        Call<Response<ApprovedRequests>> ignoreFollowRequestResponseCall = service.ignoreFollowRequest(request);

        return callService(ignoreFollowRequestResponseCall);
    }

    public Response<Message> sendMessage(String sessionId, int userId, String type, String message, byte[] image) throws ApiException {
        SendMessageRequest request = new SendMessageRequest();
        request.setSession_id(sessionId);
        request.setUser_id(userId);
        request.setType(type);
        request.setMessage(message);
        request.setImage(image);

        Call<Response<Message>> sendMessageResponseCall = service.sendMessage(request);

        return callService(sendMessageResponseCall);
    }

    public Response<List<User>> getChats(String sessionId) throws ApiException {
        GetChatsRequest request = new GetChatsRequest();
        request.setSession_id(sessionId);

        Call<Response<List<User>>> chats = service.getChats(request);

        return callService(chats);
    }

    public Response<List<Message>> getMessages(String sessionId, int userId, int pageSize, int offsetUp, int offsetDown) throws ApiException {
        GetMessagesRequest request = new GetMessagesRequest();
        request.setSession_id(sessionId);
        request.setUser_id(userId);
        request.setPage_size(pageSize);
        request.setOffset_up(offsetUp);
        request.setOffset_down(offsetDown);

        Call<Response<List<Message>>> messages = service.getMessages(request);

        return callService(messages);
    }

    public Response<List<Message>> searchMessages(String sessionId, String query, int userId,
                                                                   int pageSize, int offsetUp, int offsetDown) throws ApiException {
        SearchMessagesRequest request = new SearchMessagesRequest();
        request.setSession_id(sessionId);
        request.setUser_id(userId);
        request.setQuery(query);
        request.setPage_size(pageSize);
        request.setOffset_up(offsetUp);
        request.setOffset_down(offsetDown);

        Call<Response<List<Message>>> searchMessageResponseCall = service.searchMessages(request);

        return callService(searchMessageResponseCall);
    }

    public Response<List<Object>> deleteMessage(String sessionId, int messageId) throws ApiException {
        DeleteMessageRequest request = new DeleteMessageRequest();
        request.setSession_id(sessionId);
        request.setMessage_id(messageId);

        Call<Response<List<Object>>> deleteMessageResponseCall = service.deleteMessage(request);

        return callService(deleteMessageResponseCall);
    }

    public Response<List<Object>> clearChat(String sessionId, int userId, int deleteAfterClearing) throws ApiException {
        ClearChatRequest request = new ClearChatRequest();
        request.setSession_id(sessionId);
        request.setUser_id(userId);
        request.setDelete_chat(deleteAfterClearing);

        Call<Response<List<Object>>> clearChatResponseCall = service.clearChat(request);

        return callService(clearChatResponseCall);
    }

    private <T extends Response> T callService(Call<T> t) throws ApiException {
        try {
            retrofit2.Response<T> execute = t.execute();

            if (execute.isSuccessful()) {
                if (execute.body() != null) {
                    switch (execute.body().getCode()) {
                        case 500:
                            throw new ServerErrorException(execute.body().getMessage());
                        case 410:
                            throw new UserAlreadyExistException(execute.body().getMessage());
                        case 402:
                            throw new IncorrectCredentialsException(execute.body().getMessage());
                        case 401:
                            throw new UnauthorizedAccessException(execute.body().getMessage());
                        case 400:
                        case 411:
                            throw new IllegalArgumentException(execute.body().getMessage());
                        case 404:
                        case 204:
                            throw new NoDataFoundException(execute.body().getMessage());
                        case 200:
                            return execute.body();
                    }
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return null;
    }

}
