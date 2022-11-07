package ru.java3000.colibrism.api;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import ru.java3000.colibrism.api.dto.entity.Thread;
import ru.java3000.colibrism.api.dto.entity.*;
import ru.java3000.colibrism.api.dto.response.Response;
import ru.java3000.colibrism.api.exception.*;
import ru.java3000.colibrism.api.retrofit.ColibriSM;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.logging.Logger;

public class ApiClient {
    private final ColibriSM service;

    private static final Logger logger = Logger.getLogger("ApiClient");


    public ApiClient(String server) {
        this(server, HttpLoggingInterceptor.Level.NONE);
    }

    public ApiClient(String server, HttpLoggingInterceptor.Level logLevel) {

        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(logLevel);
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(server)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        service = retrofit.create(ColibriSM.class);
    }


    /**
     * API to access user login endpoint
     *
     * @param email    User e-mail address	E.g. mansurTL@gmail.com. from 6 to 55 symbols long
     * @param password User password in clear text	E.g. 123456. from 6 to 20 symbols long
     * @return {@link User} object
     * @throws ApiException             if request return 4xx-5xx state codes. See exception message in this case
     * @throws IllegalArgumentException if arguments is null or empty
     */
    public Response<User> login(String email, String password) throws ApiException {
        if ((email.isBlank() || email.length() > 55) ||
                (password.isBlank() | password.length() > 60 | password.length() < 6))
            throw new IllegalArgumentException();

        Call<Response<User>> request = service.login(email, password, "android");
        return callService(request);
    }

    /**
     * API for accessing user logouting endpoint
     *
     * @param sessionId Access token ID	E.g. de25cc16eb00960f076...
     * @return empty response with 200 code
     * @throws ApiException             if request return 4xx-5xx state codes. See exception message in this case
     * @throws IllegalArgumentException if arguments is null or empty
     */
    public Response<Void> logout(String sessionId) throws ApiException {
        if (sessionId.isBlank())
            throw new IllegalArgumentException();

        Call<Response<Void>> logoutResponse = service.logout(sessionId);
        return callService(logoutResponse);
    }

    /**
     * API to access user social (oAuth2 API) login endpoint
     *
     * @param token API access token E.g. ya29.a0AfH6SMBPzaEI2NaZyo_sui...
     * @param type  API provider name E.g. `facebook` or `google`
     * @return {@link User} object
     * @throws ApiException             if request return 4xx-5xx state codes. See exception message in this case
     * @throws IllegalArgumentException if arguments is null or empty
     */
    public Response<User> socialLogin(String token, String type) throws ApiException {
        if (token.isBlank() || type.isBlank())
            throw new IllegalArgumentException();

        Call<Response<User>> request = service.socialLogin(token, type, "android");
        return callService(request);
    }

    /**
     * API to access user signup endpoint
     *
     * @param email     New user's E-mail	This field must also be unique
     * @param username  Unique username	Must be without any characters other than Latin letters and numbers
     * @param password  New user's password	User password from 6-20 characters
     * @param firstName User first name	E.g. John
     * @param lastName  User last name	E.g. Smith
     * @return new user's auth token and expiry time in {@link Auth} object
     * @throws ApiException             if request return 4xx-5xx state codes. See exception message in this case
     * @throws IllegalArgumentException if arguments is null or empty
     */
    public Response<List<Auth>> signUp(String email, String username, String password, String firstName, String lastName) throws ApiException {
        if ((email.isBlank() || email.length() > 55) ||
                username.isBlank() ||
                (password.isBlank() | password.length() > 60 | password.length() < 6))
            throw new IllegalArgumentException();

        Call<Response<List<Auth>>> signup = service.signup(firstName, lastName, email, username, password);
        return callService(signup);
    }

    /**
     * API to access user password recovery endpoint
     *
     * @param email User email address	E.g. testuser@gmail.com
     * @return code 200 on success, 400-500 if there is an errors in request
     * @throws ApiException             if request return 4xx-5xx state codes. See exception message in this case
     * @throws IllegalArgumentException if arguments is null or empty
     */
    public Response<Void> resetPassword(String email) throws ApiException {
        if (email.isBlank())
            throw new IllegalArgumentException();

        Call<Response<Void>> resetPasswordResponseCall = service.resetPassword(email);
        return callService(resetPasswordResponseCall);
    }

    /**
     * API to access user timeline feed endpoint
     *
     * @param sessionId Access token ID	E.g. de25cc16eb00960f076...
     * @param offset    Last post offset ID	This is only needed when loading posts of the pagination system.
     * @param pageSize  Total post limit for each request	Recommended: 20
     * @return list of {@link Post} objects
     * @throws ApiException             if request return 4xx-5xx state codes. See exception message in this case
     * @throws IllegalArgumentException if arguments is null or empty
     */
    public Response<Feeds> feeds(String sessionId, int offset, int pageSize) throws ApiException {
        if (sessionId.isBlank())
            throw new IllegalArgumentException();

        Call<Response<Feeds>> feeds = service.feeds(offset, sessionId, pageSize);
        return callService(feeds);
    }

    /**
     * API for access user profile reporting endpoint
     *
     * @param userId    User int ID	E.g. 12
     * @param sessionId Access token ID	E.g. de25cc16eb00960f076...
     * @param reason    Report reason int ID (This value must be an int number as shown on the right)
     *                  For example, if you want to report spam account, then this value should be 1
     *                  1 = This user using this account for smap
     *                  2 = This user pretended to be someone
     *                  3 = This user posting inappropriate content
     *                  4 = This is a fake account
     *                  5 = This is a fraudulent account
     *                  6 = Other
     * @param comment   Comment to the reviwer	`Please take some actions. Thanks!`
     * @return code 200 for success, 4xx - if request have an error
     * @throws ApiException             if request return 4xx-5xx state codes. See exception message in this case
     * @throws IllegalArgumentException if arguments is null or empty
     */
    public Response<Void> reportUser(int userId, String sessionId, int reason, String comment) throws ApiException {
        if (sessionId.isBlank() || userId <= 0 || (reason == 0 || reason > 6))
            throw new IllegalArgumentException();

        Call<Response<Void>> reportUserResponseCall = service.reportProfile(sessionId, userId, reason, comment);
        return callService(reportUserResponseCall);
    }

    /**
     * API for access user profile blocking endpoint
     * Please note that if you request this api again, the user will be unblocked.
     * That is, the first call blocks and the second unlocks
     *
     * @param userId    User int ID	E.g. 12
     * @param sessionId Access token ID	E.g. de25cc16eb00960f076...
     * @return code 200 for success, 4xx - if request have an error
     * @throws ApiException             if request return 4xx-5xx state codes. See exception message in this case
     * @throws IllegalArgumentException if arguments is null or empty
     */
    public Response<Void> toggleBlockUser(int userId, String sessionId) throws ApiException {
        if (sessionId.isBlank() || userId <= 0)
            throw new IllegalArgumentException();

        Call<Response<Void>> toggleBlockResponseCall = service.toggleUserBlock(sessionId, userId);
        return callService(toggleBlockResponseCall);
    }

    /**
     * API to access the Notification Token Management Endpoint
     *
     * @param sessionId Access token ID	E.g. de25cc16eb00960f076...
     * @param type      Client device type	ios/android (Default is android)
     * @param token     Push notification token	E.g. c625cc16eb0096...
     * @return code 200 for success, 4xx - if request have an error
     * @throws ApiException             if request return 4xx-5xx state codes. See exception message in this case
     * @throws IllegalArgumentException if arguments is null or empty
     */
    public Response<Void> savePushNotificationToken(String sessionId, String type, String token) throws ApiException {
        if (sessionId.isBlank() || type.isBlank() || token.isBlank())
            throw new IllegalArgumentException();

        Call<Response<Void>> pushNotificationResponseCall = service.savePushNotificationToken(sessionId, token, type);
        return callService(pushNotificationResponseCall);
    }

    /**
     * API for accessing endpoint of user password management
     *
     * @param sessionId   Access token ID	E.g. de25cc16eb00960f076...
     * @param newPassword User new password	E.g. secret123
     * @param oldPassword User old password	E.g. 123456
     * @return code 200 for success, 4xx - if request have an error
     * @throws ApiException             if request return 4xx-5xx state codes. See exception message in this case
     * @throws IllegalArgumentException if arguments is null or empty
     */
    public Response<Void> changePassword(String sessionId, String newPassword, String oldPassword) throws ApiException {
        if (sessionId.isBlank() || newPassword.isBlank() || oldPassword.isBlank())
            throw new IllegalArgumentException();

        Call<Response<Void>> changePasswordResponseCall = service.changePassword(sessionId, oldPassword, newPassword);
        return callService(changePasswordResponseCall);
    }

    /**
     * API for accessing endpoint of user access token management
     *
     * @param token Refresh token ID	E.g. de25cc16eb00960f076...
     * @return {@link Auth} object
     * @throws ApiException             if request return 4xx-5xx state codes. See exception message in this case
     * @throws IllegalArgumentException if arguments is null or empty
     */
    public Response<Auth> refreshAccessToken(String token) throws ApiException {
        if (token.isBlank())
            throw new IllegalArgumentException();

        Call<Response<Auth>> refreshAccessTokenResponseCall = service.refreshAccessToken(token);
        return callService(refreshAccessTokenResponseCall);
    }

    /**
     * API for accessing a user account verification endpoint
     *
     * @param sessionId Access token ID	E.g. de25cc16eb00960f076...
     * @param fullName  User full name	E.g. John Smith
     * @param message   Text message to the reviewer	E.g. "Please verify my account"
     * @param video     Video message to the reviewer	E.g. "video appeal.mp4"
     * @return code 200 for success, 4xx - if request have an error
     * @throws ApiException             if request return 4xx-5xx state codes. See exception message in this case
     * @throws IllegalArgumentException if arguments is null or empty
     */
    public Response<Verification> verifyUser(String sessionId, String fullName,
                                             String message, String video) throws ApiException {
        if (sessionId.isBlank())
            throw new IllegalArgumentException();

        Call<Response<Verification>> verifyUserResponseCall = service.verifyUser(sessionId, message, video, fullName);
        return callService(verifyUserResponseCall);
    }

    /**
     * API endpoint for polls voting
     *
     * @param sessionId Access token ID	E.g. de25cc16eb00960f076...
     * @param postId    Post int ID	E.g. 84
     * @param pollId    Poll index ID (starts from 0,1,2,3 etc..)	E.g. To vote frist option of a poll send 0
     * @return poll statistics as {@link PollData} object
     * @throws ApiException             if request return 4xx-5xx state codes. See exception message in this case
     * @throws IllegalArgumentException if arguments is null or empty
     */
    public Response<PollData> votePoll(String sessionId, int postId, int pollId) throws ApiException {
        if (sessionId.isBlank() || postId <= 0)
            throw new IllegalArgumentException();

        Call<Response<PollData>> voteResponseCall = service.votePoll(sessionId, postId, pollId);
        return callService(voteResponseCall);
    }

    /**
     * API for access (like/unlike) post endpoint
     *
     * @param sessionId Access token ID	E.g. de25cc16eb00960f076...
     * @param postId    Liked/Unliked post int ID	E.g. 4567
     * @return {@link Like} object - the boolean for post like status
     * @throws ApiException             if request return 4xx-5xx state codes. See exception message in this case
     * @throws IllegalArgumentException if arguments is null or empty
     */
    public Response<Like> toggleLike(String sessionId, int postId) throws ApiException {
        if (sessionId.isBlank() || postId <= 0)
            throw new IllegalArgumentException();

        Call<Response<Like>> toggleLikeResponseCall = service.toggleLike(sessionId, postId);
        return callService(toggleLikeResponseCall);
    }

    /**
     * API for access publication reporting endpoint
     *
     * @param sessionId Access token ID	E.g. de25cc16eb00960f076...
     * @param postId    Post int ID	E.g. 4567
     * @param reason    Report reason int ID (This value must be an int number as shown on the right)
     *                  For example, if you want to report spam, then this value should be 1
     *                  1 = This is spam
     *                  2 = Misleading or fraudulent
     *                  3 = Publication of private information
     *                  4 = Threats of violence or physical harm
     *                  5 = I am not interested in this post
     *                  6 = Other
     * @param comment   Comment to the reviwer	`Please take some actions. Thanks!`
     * @return code of operation state
     * @throws ApiException             if request return 4xx-5xx state codes. See exception message in this case
     * @throws IllegalArgumentException if arguments is null or empty
     */
    public Response<Void> reportPost(String sessionId, int postId, int reason, String comment) throws ApiException {
        if (sessionId.isBlank() || postId <= 0 || (reason <= 0 || reason > 6))
            throw new IllegalArgumentException();

        Call<Response<Void>> reportPostResponseCall = service.reportPost(sessionId, postId, reason, comment);
        return callService(reportPostResponseCall);
    }

    /**
     * API for access publication repost endpoint
     *
     * @param sessionId Access token ID	E.g. de25cc16eb00960f076...
     * @param postId    Post int ID	E.g. 4567
     * @return {@link Reposts} object - boolean result of operation
     * @throws ApiException             if request return 4xx-5xx state codes. See exception message in this case
     * @throws IllegalArgumentException if arguments is null or empty
     */
    public Response<Reposts> repost(String sessionId, int postId) throws ApiException {
        if (sessionId.isBlank() || postId <= 0)
            throw new IllegalArgumentException();

        Call<Response<Reposts>> repost = service.repost(sessionId, postId);
        return callService(repost);
    }

    /**
     * API for access fetch post likes endpoint
     * (FETCH REPOST ON POST) AT THE MOMENT THIS OPTION IS NOT SUPPORTED BY THE SCRIPT CORE
     *
     * @param sessionId Access token ID (Optional)	E.g. de25cc16eb00960f076...
     * @param postId    Liked/Unliked post int ID	E.g. 4567
     * @param offset    Last post offset ID	This is only needed when loading records of the pagination system.
     * @param pageSize  Total records limit for each request	Recommended: 20
     * @return list of {@link User} objects liked this post
     * @throws ApiException             if request return 4xx-5xx state codes. See exception message in this case
     * @throws IllegalArgumentException if arguments is null or empty
     */
    public Response<List<User>> fetchLikes(String sessionId, int postId, int offset, int pageSize) throws ApiException {
        if (postId <= 0)
            throw new IllegalArgumentException();

        Call<Response<List<User>>> fetchLikesResponseCall = service.fetchLikes(sessionId, postId, pageSize, offset);
        return callService(fetchLikesResponseCall);
    }

    /**
     * API for access (post/thread/reply) deleting endpoint
     *
     * @param sessionId Access token ID	E.g. de25cc16eb00960f076...
     * @param postId    Liked/Unliked post int ID	E.g. 4567
     * @return code of operation
     * @throws ApiException             if request return 4xx-5xx state codes. See exception message in this case
     * @throws IllegalArgumentException if arguments is null or empty
     */
    public Response<Void> deletePost(String sessionId, int postId) throws ApiException {
        if (sessionId.isBlank() || postId <= 0)
            throw new IllegalArgumentException();

        Call<Response<Void>> deletePostResponseCall = service.deletePost(sessionId, postId);
        return callService(deletePostResponseCall);
    }

    /**
     * API to access hashtags searching endpoint
     *
     * @param sessionId (Optional)	Access token ID	E.g. de25cc16eb00960f076...
     * @param query     Search keywords	E.g. Covid19
     * @param offset    Last post offset ID	This is only needed when loading posts of the pagination system.
     * @param pageSize  Total post limit for each request	Recommended: 20
     * @return list of {@link HashTag} objects
     * @throws ApiException             if request return 4xx-5xx state codes. See exception message in this case
     * @throws IllegalArgumentException if arguments is null or empty
     */
    public Response<List<HashTag>> searchHashtag(String sessionId, String query, int offset, int pageSize) throws ApiException {
        Call<Response<List<HashTag>>> searchHashtagResponseCall = service.searchHashtag(sessionId, query, offset, pageSize);
        return callService(searchHashtagResponseCall);
    }

    /**
     * API to access people searching endpoint
     *
     * @param sessionId (Optional)	Access token ID	E.g. de25cc16eb00960f076...
     * @param query     Search keywords	E.g. John Smith
     * @param offset    Last post offset ID	This is only needed when loading posts of the pagination system.
     * @param pageSize  Total post limit for each request	Recommended: 20
     * @return list of {@link User} objects
     * @throws ApiException             if request return 4xx-5xx state codes. See exception message in this case
     * @throws IllegalArgumentException if arguments is null or empty
     */
    public Response<List<User>> searchPeople(String sessionId, String query, int offset, int pageSize) throws ApiException {
        Call<Response<List<User>>> searchPeopleResponseCall = service.searchPeople(sessionId, query, offset, pageSize);
        return callService(searchPeopleResponseCall);
    }

    /**
     * API to access posts searching endpoint
     *
     * @param sessionId (Optional)	Access token ID	E.g. de25cc16eb00960f076...
     * @param query     Search keywords	E.g. `how to get followers`
     * @param offset    Last post offset ID	This is only needed when loading posts of the pagination system.
     * @param pageSize  Total post limit for each request	Recommended: 20
     * @return list of {@link Post} objects
     * @throws ApiException             if request return 4xx-5xx state codes. See exception message in this case
     * @throws IllegalArgumentException if arguments is null or empty
     */
    public Response<List<Post>> searchPost(String sessionId, String query, int offset, int pageSize) throws ApiException {
        Call<Response<List<Post>>> searchPeopleResponseCall = service.searchPost(sessionId, query, offset, pageSize);
        return callService(searchPeopleResponseCall);
    }

    //todo add pin post to profile method

    /**
     * API to update profile details of logged in user
     *
     * @param sessionId Access token ID	E.g. de25cc16eb00960f076...
     * @param about     User bio (Max 140 chars.)	E.g. ATL
     * @param userName  User new username	E.g. mansurTL
     * @param gender    User gender (M/F/O/T)	E.g. M
     * @param email     User email address	E.g. email@email.com
     * @param firstName User user first name	E.g. Mansur
     * @param lastName  User user last name	E.g. ATL
     * @param countryId User country ID	E.g. 1 (United States)
     * @param website   User website URL	E.g. <a href="https://rutvit.com/">https://rutvit.com/</a>
     * @return {@link User} object
     * @throws ApiException             if request return 4xx-5xx state codes. See exception message in this case
     * @throws IllegalArgumentException if arguments is null or empty
     */
    public Response<User> updateProfile(String sessionId, String about, String userName,
                                        String gender, String email, String firstName, String lastName,
                                        int countryId, URL website) throws ApiException {
        if (sessionId.isBlank())
            throw new IllegalArgumentException();

        Call<Response<User>> updateProfileResponseCall = service.updateProfile(sessionId, firstName, lastName, about,
                gender, email, userName, website, countryId);
        return callService(updateProfileResponseCall);
    }

    /**
     * API for access (follow/unfollow) user endpoint
     *
     * @param sessionId Access token ID	E.g. de25cc16eb00960f076...
     * @param userId    Followed/Unfollowed user int ID	E.g. 4567
     * @return {@link Follow} object - boolean result of operation
     * @throws ApiException             if request return 4xx-5xx state codes. See exception message in this case
     * @throws IllegalArgumentException if arguments is null or empty
     */
    public Response<Follow> toggleFollow(String sessionId, int userId) throws ApiException {
        if (sessionId.isBlank() || userId <= 0)
            throw new IllegalArgumentException();

        Call<Response<Follow>> toggleFollowResponseCall = service.toggleFollow(sessionId, userId);
        return callService(toggleFollowResponseCall);
    }

    /**
     * API for accessing endpoint of user (following) list
     *
     * @param sessionId Access token ID (Optional)	E.g. de25cc16eb00960f076...
     * @param userId    User int ID	E.g. 12
     * @param offset    Last user offset ID	This is only needed when loading users of the pagination system.
     * @param pageSize  Total users limit for each request	Recommended: 20
     * @return list of {@link User} objects
     * @throws ApiException             if request return 4xx-5xx state codes. See exception message in this case
     * @throws IllegalArgumentException if arguments is null or empty
     */
    public Response<List<User>> fetchFollowing(String sessionId, int userId, int offset, int pageSize) throws ApiException {
        if (userId <= 0)
            throw new IllegalArgumentException();

        Call<Response<List<User>>> fetchFollowingResponseCall = service.fetchFollowing(sessionId, userId, offset, pageSize);
        return callService(fetchFollowingResponseCall);
    }

    /**
     * API for accessing endpoint of user (followers) list
     *
     * @param sessionId Access token ID (Optional)	E.g. de25cc16eb00960f076...
     * @param userId    User int ID	E.g. 12
     * @param offset    Last user offset ID	This is only needed when loading users of the pagination system.
     * @param pageSize  Total users limit for each request	Recommended: 20
     * @return list of {@link User} objects
     * @throws ApiException             if request return 4xx-5xx state codes. See exception message in this case
     * @throws IllegalArgumentException if arguments is null or empty
     */
    public Response<List<User>> fetchFollowers(String sessionId, int userId, int offset, int pageSize) throws ApiException {
        if (userId <= 0)
            throw new IllegalArgumentException();

        Call<Response<List<User>>> fetchFollowersResponseCall = service.fetchFollowers(sessionId, userId, offset, pageSize);
        return callService(fetchFollowersResponseCall);
    }

    /**
     * API for accessing the endpoint of fetching user notifications & mentions
     *
     * @param sessionId Access token ID	E.g. de25cc16eb00960f076...
     * @param type      Notification type (notifs/mentions)	E.g. `notifs`
     * @param offset    Last record offset ID	This is only needed when loading records of the pagination system.
     * @param pageSize  Total records limit for each request	Recommended: 20
     * @return list of 	{@link Notification} objects
     * @throws ApiException             if request return 4xx-5xx state codes. See exception message in this case
     * @throws IllegalArgumentException if arguments is null or empty
     */
    public Response<List<Notification>> getNotifications(String sessionId, String type, int offset, int pageSize) throws ApiException {
        if (sessionId.isBlank() || type.isBlank())
            throw new IllegalArgumentException();

        Call<Response<List<Notification>>> notifications = service.getNotifications(sessionId, type, pageSize, offset);
        return callService(notifications);
    }

    /**
     * API for access (notifications & mentions) deleting endpoint
     *
     * @param sessionId Access token ID	E.g. de25cc16eb00960f076...
     * @param scope     Array of notification ID (Integer)	E.g. [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, ...]
     * @return the code result of operation
     * @throws ApiException             if request return 4xx-5xx state codes. See exception message in this case
     * @throws IllegalArgumentException if arguments is null or empty
     */
    public Response<Void> deleteNotifications(String sessionId, int... scope) throws ApiException {
        if (sessionId.isBlank() || scope.length == 0)
            throw new IllegalArgumentException();

        Call<Response<Void>> deleteNotificationsResponseCall = service.deleteNotifications(sessionId, scope);
        return callService(deleteNotificationsResponseCall);
    }

    /**
     * API for access remove user account endpoint
     *
     * @param sessionId Access token ID	E.g. de25cc16eb00960f076...
     * @param password  Current user password	E.g. secret123
     * @return result of operation
     * @throws ApiException             if request return 4xx-5xx state codes. See exception message in this case
     * @throws IllegalArgumentException if arguments is null or empty
     */
    public Response<Void> deleteAccount(String sessionId, String password) throws ApiException {
        if (sessionId.isBlank() || password.isBlank())
            throw new IllegalArgumentException();

        Call<Response<Void>> deleteAccountResponseCall = service.deleteAccount(sessionId, password);
        return callService(deleteAccountResponseCall);
    }

    /**
     * API endpoint for changing display language
     *
     * @param sessionId Access token ID	E.g. de25cc16eb00960f076...
     * @param language  Display language name
     *                  E.g. One of these options (
     *                  english,
     *                  french,
     *                  german,
     *                  italian,
     *                  russian,
     *                  portuguese,
     *                  spanish,
     *                  turkish,
     *                  dutch,
     *                  ukraine)
     * @return result code
     * @throws ApiException             if request return 4xx-5xx state codes. See exception message in this case
     * @throws IllegalArgumentException if arguments is null or empty
     */
    public Response<Void> changeLanguage(String sessionId, String language) throws ApiException {
        if (sessionId.isBlank() || language.isBlank())
            throw new IllegalArgumentException();

        Call<Response<Void>> changeLanguageResponseCall = service.changeLanguage(sessionId, language);
        return callService(changeLanguageResponseCall);
    }

    /**
     * API to access user profile data fetching endpoint
     *
     * @param sessionId User auth token (Optional)
     *                  In this case, authorization is not required,
     *                  but it is desirable to determine whether you are subscribed to this profile or not,
     *                  blocked or not, etc.
     * @param userName  Profile username	Unique username. E.g. "mansur_tl"
     * @param userId    Profile user ID	In order to get information about the profile,
     *                  you must send a valid ID or username
     * @return {@link User} object
     * @throws ApiException             if request return 4xx-5xx state codes. See exception message in this case
     * @throws IllegalArgumentException if arguments is null or empty
     */
    public Response<User> getProfile(String sessionId, String userName, int userId) throws ApiException {
        if (sessionId.isBlank() || userName.isBlank() || userId <= 0)
            throw new IllegalArgumentException();

        Call<Response<User>> profile = service.getProfile(sessionId, userId, userName);
        return callService(profile);
    }

    /**
     * API to access user profile posts fetching endpoint
     *
     * @param sessionId User auth token (Optional)
     *                  In this case, authorization is not required,
     *                  but it is desirable to determine whether you are subscribed to this profile or not,
     *                  blocked or not, etc.
     * @param userId    Profile user ID	In order to get information about the profile, you must send a valid ID
     * @param type      Profile posts type (posts/media/liked)	E.g. `posts` in order to get user publications
     * @param offset    Last post offset ID	This is only needed when loading posts of the pagination system.
     * @param pageSize  Total post limit for each request	Recommended: 20
     * @return List of {@link Post} objects wrapped in {@link Posts} object
     * @throws ApiException             if request return 4xx-5xx state codes. See exception message in this case
     * @throws IllegalArgumentException if arguments is null or empty
     */
    public Response<Posts> getProfilePosts(String sessionId, int userId, String type, int offset, int pageSize) throws ApiException {
        if (userId <= 0 || type.isBlank())
            throw new IllegalArgumentException();

        Call<Response<Posts>> profilePosts = service.getProfilePosts(sessionId, userId, type, offset, pageSize);
        return callService(profilePosts);
    }

    /**
     * API endpoint for uploading post multimedia files
     *
     * @param sessionId Access token ID	E.g. de25cc16eb00960f076...
     * @param type      Media file type (image/video)	E.g. image
     * @param file      Media file (Image/Video)	E.g. some-selfy-picture.jpeg
     * @return {@link Media} object. Fields may be vary.
     * @throws ApiException             if request return 4xx-5xx state codes. See exception message in this case
     * @throws IllegalArgumentException if arguments is null or empty
     */
    public Response<Media> uploadPostMedia(String sessionId, String type, byte[] file) throws ApiException {
        if (sessionId.isBlank() || type.isBlank() || file.length == 0)
            throw new IllegalArgumentException();

        Call<Response<Media>> uploadPostMediaImageResponseCall = service.uploadPostMedia(sessionId, type, file);
        return callService(uploadPostMediaImageResponseCall);
    }

    /**
     * API endpoint for deleteing post multimedia files
     *
     * @param sessionId Access token ID	E.g. de25cc16eb00960f076...
     * @param type      Media file type (Image/Video)	E.g. image
     * @param mediaId   Media file ID	E.g. 45
     * @return code of operation
     * @throws ApiException             if request return 4xx-5xx state codes. See exception message in this case
     * @throws IllegalArgumentException if arguments is null or empty
     */
    public Response<Void> deletePostMedia(String sessionId, String type, int mediaId) throws ApiException {
        if (sessionId.isBlank() || type.isBlank() || mediaId <= 0)
            throw new IllegalArgumentException();

        Call<Response<Void>> deletePostMediaResponseCall = service.deletePostMedia(sessionId, type, mediaId);
        return callService(deletePostMediaResponseCall);
    }

    /**
     * API endpoint for pulishing port or it's reply
     *
     * @param sessionId Access token ID	E.g. de25cc16eb00960f076...
     * @param text      Post text message (Max. 600 chars)	E.g. `Hello world!`
     * @param privacy   Publication privacy settings (Ignored for replies to posts)
     *                  One of those values (everyone, followers, mentioned)
     * @param gif       Gif image source URL	Only if the post does not contain other media files (Video or Image)
     * @param og        Extracted OG data from URL	Only if the post does not contain other media files (Video or Image or GIF)
     * @param poll      Poll JSON data
     *                  Json array with poll option objects. E.g. [{"value": "Option 1"}, {"value": "Option 2"}, {..}]
     *                  From 2 to 4 options
     * @param threadId  Thered int. ID	Required only for reply
     * @return {@link Post} object
     * @throws ApiException             if request return 4xx-5xx state codes. See exception message in this case
     * @throws IllegalArgumentException if arguments is null or empty
     */
    public Response<Post> publishPost(String sessionId, String text, String privacy, URL gif,
                                      String og, String poll, int threadId) throws ApiException {
        if (sessionId.isBlank())
            throw new IllegalArgumentException();

        Call<Response<Post>> publishPostResponseCall = service.publishPost(sessionId, text, threadId, gif, og, poll, privacy);
        return callService(publishPostResponseCall);
    }

    /**
     * API endpoint for changing post privacy
     * You will need this endpoint if you want to change the privacy of the post,
     * that is, the option "Who can reply"
     * However, keep in mind that this option is only available for Posts that do not have a parent chain.
     * That is, the post should be the original post and not the answer.
     *
     * @param sessionId Access token ID	E.g. de25cc16eb00960f076...
     * @param postId    Publication int ID	E.g. 11
     * @param privacy   Publication privacy settings (Ignored for replies to posts)
     *                  One of those values (everyone, followers, mentioned)
     * @return result of operation
     * @throws ApiException             if request return 4xx-5xx state codes. See exception message in this case
     * @throws IllegalArgumentException if arguments is null or empty
     */
    public Response<Void> changePostPrivacy(String sessionId, int postId, String privacy) throws ApiException {
        if (sessionId.isBlank() || postId <= 0 || privacy.isBlank())
            throw new IllegalArgumentException();

        Call<Response<Void>> changePostPrivacyResponseCall = service.changePostPrivacy(sessionId, postId, privacy);
        return callService(changePostPrivacyResponseCall);
    }

    /**
     * API endpoint for uploading swift media file. I.e Video or Image
     *
     * @param sessionId Access token ID	E.g. de25cc16eb00960f076...
     * @param type      Media file type (image/video)	E.g. image
     * @param file      Media file (Image/Video)	E.g. some-selfy-picture.jpeg
     * @return {@link SwiftMedia}
     * @throws ApiException             if request return 4xx-5xx state codes. See exception message in this case
     * @throws IllegalArgumentException if arguments is null or empty
     */
    public Response<SwiftMedia> uploadSwiftMedia(String sessionId, String type, byte[] file) throws ApiException {
        if (sessionId.isBlank() || type.isBlank() || file.length == 0)
            throw new IllegalArgumentException();

        Call<Response<SwiftMedia>> uploadSwiftMediaResponseCall = service.uploadSwiftMedia(sessionId, type, file);
        return callService(uploadSwiftMediaResponseCall);
    }

    /**
     * API endpoint for deleteing swift media file
     * In this case, you just need to send the above request to delete the swift media file,
     * that is, a request without additional parameters,
     * since the system itself will determine which file was last uploaded and delete it
     *
     * @param sessionId Access token ID	E.g. de25cc16eb00960f076...
     * @return result op operation
     * @throws ApiException             if request return 4xx-5xx state codes. See exception message in this case
     * @throws IllegalArgumentException if arguments is null or empty
     */
    public Response<Void> deleteSwiftMedia(String sessionId) throws ApiException {
        if (sessionId.isBlank())
            throw new IllegalArgumentException();

        Call<Response<Void>> deleteSwiftMediaResponseCall = service.deleteSwiftMedia(sessionId);
        return callService(deleteSwiftMediaResponseCall);
    }

    /**
     * API endpoint for pulishing swift
     * This stage of creating a swift assumes that you have already uploaded a media file, that is,
     * a video or an image of a swift. Since the media file is required when creating a swift,
     * unlike the description, you can send the description or not.
     *
     * @param sessionId Access token ID	E.g. de25cc16eb00960f076...
     * @param text      Text text message (Max. 200 chars)	E.g. `Lorem ipsum`
     * @return result of operation
     * @throws ApiException             if request return 4xx-5xx state codes. See exception message in this case
     * @throws IllegalArgumentException if arguments is null or empty
     */
    public Response<Void> publishSwift(String sessionId, String text) throws ApiException {
        if (sessionId.isBlank())
            throw new IllegalArgumentException();

        Call<Response<Void>> publishSwiftResponseCall = service.publishSwift(sessionId, text);
        return callService(publishSwiftResponseCall);
    }

    /**
     * API endpoint for deleteing swift
     *
     * @param sessionId Access token ID	E.g. de25cc16eb00960f076...
     * @param swiftId   Swift hash id	E.g. `zpad2HalsbsLGhdI`
     * @return result of operation
     * @throws ApiException             if request return 4xx-5xx state codes. See exception message in this case
     * @throws IllegalArgumentException if arguments is null or empty
     */
    public Response<Void> deleteSwift(String sessionId, String swiftId) throws ApiException {
        if (sessionId.isBlank() || swiftId.isBlank())
            throw new IllegalArgumentException();

        Call<Response<Void>> deleteSwiftResponseCall = service.deleteSwift(sessionId, swiftId);
        return callService(deleteSwiftResponseCall);
    }

    //todo refactor returning object to propper. this is not a user MAYBE

    /**
     * API endpoint for fetching user swifts list
     * This endpoint will allow you to get all active swifts of the logged in user
     *
     * @param sessionId Access token ID	E.g. de25cc16eb00960f076...
     * @return list of {@link User} objects
     * @throws ApiException             if request return 4xx-5xx state codes. See exception message in this case
     * @throws IllegalArgumentException if arguments is null or empty
     */
    public Response<List<User>> getSwifts(String sessionId) throws ApiException {
        if (sessionId.isBlank())
            throw new IllegalArgumentException();

        Call<Response<List<User>>> swifts = service.getSwifts(sessionId);
        return callService(swifts);
    }

    /**
     * API endpoint for registering swift views
     * This endpoint is needed in order to send a request to the server when the swift is opened
     * so that the system registers the swift view.
     *
     * @param sessionId Access token ID	E.g. de25cc16eb00960f076...
     * @param userId    Swift user ID	E.g. `10`
     * @param swiftId   Swift hash id	E.g. `zpad2HalsbsLGhdI`
     * @return result of operation
     * @throws ApiException             if request return 4xx-5xx state codes. See exception message in this case
     * @throws IllegalArgumentException if arguments is null or empty
     */
    public Response<Void> registerSwiftView(String sessionId, int userId, String swiftId) throws ApiException {
        if (sessionId.isBlank() || swiftId.isBlank() || userId <= 0)
            throw new IllegalArgumentException();

        Call<Response<Void>> registerSwiftViewResponseCall = service.registerSwiftView(sessionId, userId, swiftId);
        return callService(registerSwiftViewResponseCall);
    }

    /**
     * API for accessing endpoint of post thread data
     * 1. The `post` variable contains the post data of the thread (The main post on the thread page)
     * 2. The variable `next` contains the responses to the thread
     * (Each post data in this array can also contain `replys` variable with first few replys to it)
     * 3. A variable named `prev` contains the parent chain of the current thread (Only if there are parent posts)
     * 4. If the variable `can_reply` has a value (false), it means that the current user cannot reply to this post
     *
     * @param sessionId Access token ID	E.g. de25cc16eb00960f076...
     * @param threadId  Thread int ID	E.g. 123456 (ID of any post to view replies and all details)
     * @return {@link Thread} object
     * @throws ApiException             if request return 4xx-5xx state codes. See exception message in this case
     * @throws IllegalArgumentException if arguments is null or empty
     */
    public Response<Thread> fetchThreadData(String sessionId, int threadId) throws ApiException {
        if (sessionId.isBlank() || threadId <= 0)
            throw new IllegalArgumentException();

        Call<Response<Thread>> fetchThreadDataResponseCall = service.fetchThreadData(sessionId, threadId);
        return callService(fetchThreadDataResponseCall);
    }

    /**
     * API for accessing endpoint of post thread replys
     * Please note that each post item in `data` array can also contain `replys` variable
     * with first few replys to it (see above)
     *
     * @param sessionId Access token ID	E.g. de25cc16eb00960f076...
     * @param threadId  Thread int ID	E.g. 123456 (ID of any post to view replies and all details)
     * @param offset    Last post offset ID
     *                  This variable must be the id of the last post (Reply) object in the `next` array (see above)
     * @param pageSize  Total post limit for each request (Optional)	Recommended: 20
     * @return {@link Post} object
     * @throws ApiException             if request return 4xx-5xx state codes. See exception message in this case
     * @throws IllegalArgumentException if arguments is null or empty
     */
    public Response<List<Post>> fetchThreadReplies(String sessionId, int threadId, int offset, int pageSize) throws ApiException {
        if (sessionId.isBlank() || threadId <= 0)
            throw new IllegalArgumentException();

        Call<Response<List<Post>>> fetchThreadRepliesResponseCall = service.fetchThreadReplies(sessionId, threadId, pageSize, offset);
        return callService(fetchThreadRepliesResponseCall);
    }

    /**
     * API for accessing get user bookmarks endpoint
     *
     * @param sessionId Access token ID	E.g. de25cc16eb00960f076...
     * @param offset    Last post offset ID	This is only needed when loading posts of the pagination system.
     * @param pageSize  Total post limit for each request	Recommended: 20
     * @return list of {@link Post} objects
     * @throws ApiException             if request return 4xx-5xx state codes. See exception message in this case
     * @throws IllegalArgumentException if arguments is null or empty
     */
    public Response<List<Post>> getBookmarks(String sessionId, int offset, int pageSize) throws ApiException {
        if (sessionId.isBlank())
            throw new IllegalArgumentException();

        Call<Response<List<Post>>> bookmarks = service.getBookmarks(sessionId, pageSize, offset);
        return callService(bookmarks);
    }

    /**
     * API for accessing bookmark/unbookmark post endpoint
     *
     * @param sessionId Access token ID	E.g. de25cc16eb00960f076...
     * @param postId    Bookmarked/Unbookmarked post int ID	E.g. 4567
     * @return {@link Bookmark} wrapper object for boolean mark, if this post is bookmarked
     * @throws ApiException             if request return 4xx-5xx state codes. See exception message in this case
     * @throws IllegalArgumentException if arguments is null or empty
     */
    public Response<Bookmark> toggleBookmark(String sessionId, int postId) throws ApiException {
        if (sessionId.isBlank() || postId <= 0)
            throw new IllegalArgumentException();

        Call<Response<Bookmark>> addBookmarkResponseCall = service.toggleBookmark(sessionId, postId);
        return callService(addBookmarkResponseCall);
    }

    /**
     * API for accessing user avatar uploading endpoint
     *
     * @param sessionId Access token ID	E.g. de25cc16eb00960f076...
     * @param avatar    Image format file (jpg,png,jpeg,gif)	image.jpeg
     * @return {@link Avatar} object
     * @throws ApiException             if request return 4xx-5xx state codes. See exception message in this case
     * @throws IllegalArgumentException if arguments is null or empty
     */
    public Response<Avatar> changeAvatar(String sessionId, byte[] avatar) throws ApiException {
        if (sessionId.isBlank() || avatar.length == 0)
            throw new IllegalArgumentException();

        Call<Response<Avatar>> changeAvatarResponseCall = service.changeAvatar(sessionId, avatar);
        return callService(changeAvatarResponseCall);
    }

    /**
     * API for accessing user profile cover uploading endpoint
     *
     * @param sessionId Access token ID	E.g. de25cc16eb00960f076...
     * @param cover     Image format file (jpg,png,jpeg,gif)	image.jpeg
     * @return {@link Cover} object
     * @throws ApiException             if request return 4xx-5xx state codes. See exception message in this case
     * @throws IllegalArgumentException if arguments is null or empty
     */
    public Response<Cover> changeCover(String sessionId, byte[] cover) throws ApiException {
        if (sessionId.isBlank() || cover.length == 0)
            throw new IllegalArgumentException();

        Call<Response<Cover>> changeAvatarResponseCall = service.changeCover(sessionId, cover);
        return callService(changeAvatarResponseCall);
    }

    /**
     * API for accessing the endpoint of changing the position of the user's profile cover
     * This access point allows you to change the position of the profile cover up or down.
     * The margins are combed from top to bottom in pixels, given the standard cover size of 600 by 200 pixels.
     *
     * @param sessionId Access token ID	E.g. de25cc16eb00960f076...
     * @param position  Integer top position offset number	E.g. 10
     * @return {@link Cover} object
     * @throws ApiException             if request return 4xx-5xx state codes. See exception message in this case
     * @throws IllegalArgumentException if arguments is null or empty
     */
    public Response<Cover> coverReposition(String sessionId, int position) throws ApiException {
        if (sessionId.isBlank())
            throw new IllegalArgumentException();

        Call<Response<Cover>> coverRepositionResponseCall = service.coverReposition(sessionId, position);
        return callService(coverRepositionResponseCall);
    }

    /**
     * API for accessing the endpoint of user privacy settings
     *
     * @param sessionId Access token ID	E.g. de25cc16eb00960f076...
     * @return {@link PrivacySettings} object
     * @throws ApiException             if request return 4xx-5xx state codes. See exception message in this case
     * @throws IllegalArgumentException if arguments is null or empty
     */
    public Response<PrivacySettings> getPrivacySettings(String sessionId) throws ApiException {
        if (sessionId.isBlank())
            throw new IllegalArgumentException();

        Call<Response<PrivacySettings>> privacySettings = service.getPrivacySettings(sessionId);
        return callService(privacySettings);
    }

    /**
     * API for accessing the endpoint of changing user privacy settings
     *
     * @param sessionId         Access token ID	E.g. de25cc16eb00960f076...
     * @param followPrivacy     Follow request privacy	E.g. One of these options (approved/everyone)
     * @param contactPrivacy    Direct message privacy	E.g. One of these options (followed/everyone)vvv
     * @param profileVisibility Profile access privacy	E.g. One of these options (followers/everyone)
     * @param searchVisibility  Profile search indexing privacy	E.g. One of these options (Y/N)
     * @return result of operation
     * @throws ApiException             if request return 4xx-5xx state codes. See exception message in this case
     * @throws IllegalArgumentException if arguments is null or empty
     */
    public Response<Void> setPrivacySettings(String sessionId, String followPrivacy, String contactPrivacy,
                                             String profileVisibility, String searchVisibility) throws ApiException {
        if (sessionId.isBlank())
            throw new IllegalArgumentException();

        Call<Response<Void>> setPrivacySettingsResponseCall = service.setPrivacySettings(sessionId, profileVisibility,
                contactPrivacy, followPrivacy, searchVisibility);
        return callService(setPrivacySettingsResponseCall);
    }

    /**
     * API for accessing endpoint of user (follow requests) list
     *
     * @param sessionId Access token ID (Optional)	E.g. de25cc16eb00960f076...
     * @param offset    Last user offset ID	This is only needed when loading users of the pagination system.
     * @param pageSize  Total users limit for each request	Recommended: 20
     * @return list of {@link User} object
     * @throws ApiException             if request return 4xx-5xx state codes. See exception message in this case
     * @throws IllegalArgumentException if arguments is null or empty
     */
    public Response<List<User>> followRequests(String sessionId, int offset, int pageSize) throws ApiException {
        Call<Response<List<User>>> followRequestsResponseCall = service.followRequests(sessionId, offset, pageSize);
        return callService(followRequestsResponseCall);
    }

    /**
     * API for accessing endpoint of user (follow requests) accepting
     *
     * @param sessionId Access token ID (Optional)	E.g. de25cc16eb00960f076...
     * @param requestId Follow request int ID	E.g. 34
     * @return {@link ApprovedRequests} wrapper object for total number of approverd requests
     * @throws ApiException             if request return 4xx-5xx state codes. See exception message in this case
     * @throws IllegalArgumentException if arguments is null or empty
     */
    public Response<ApprovedRequests> approveFollowRequest(String sessionId, int requestId) throws ApiException {
        if (sessionId.isBlank() || requestId <= 0)
            throw new IllegalArgumentException();

        Call<Response<ApprovedRequests>> approveFollowRequestResponseCall = service.approveFollowRequest(sessionId, requestId);
        return callService(approveFollowRequestResponseCall);
    }

    /**
     * API for accessing endpoint of user (follow requests) deleting. I.e. Ignoring requests
     *
     * @param sessionId Access token ID (Optional)	E.g. de25cc16eb00960f076...
     * @param requestId Follow request int ID	E.g. 34
     * @return {@link ApprovedRequests} wrapper object for total number of ignored requests
     * @throws ApiException             if request return 4xx-5xx state codes. See exception message in this case
     * @throws IllegalArgumentException if arguments is null or empty
     */
    public Response<ApprovedRequests> ignoreFollowRequest(String sessionId, int requestId) throws ApiException {
        if (sessionId.isBlank() || requestId <= 0)
            throw new IllegalArgumentException();

        Call<Response<ApprovedRequests>> ignoreFollowRequestResponseCall = service.ignoreFollowRequest(sessionId, requestId);
        return callService(ignoreFollowRequestResponseCall);
    }

    /**
     * API for accessing the endpoint of sending a message|image
     *
     * @param sessionId Access token ID	E.g. de25cc16eb00960f076...
     * @param userId    User ID of the interlocutor	E.g. 4567
     * @param type      Message type Text or Image	E.g. One of these options (text/media)
     * @param message   Message text (Max length 3000)	E.g. `Hi! How are you?`
     * @param image     Message image file	E.g. some-picture.jpeg
     * @return sent {@link Message} object
     * @throws ApiException             if request return 4xx-5xx state codes. See exception message in this case
     * @throws IllegalArgumentException if arguments is null or empty
     */
    public Response<Message> sendMessage(String sessionId, int userId, String type, String message, byte[] image) throws ApiException {
        if (sessionId.isBlank() || type.isBlank() || userId <= 0 || message.length() > 3000)
            throw new IllegalArgumentException();

        Call<Response<Message>> sendMessageResponseCall = service.sendMessage(sessionId, userId, type, image, message);
        return callService(sendMessageResponseCall);
    }

    /**
     * API for accessing the endpoint of the chat list
     *
     * @param sessionId Access token ID	E.g. de25cc16eb00960f076...
     * @return list of {@link User} objects. Fields may be vary
     * @throws ApiException             if request return 4xx-5xx state codes. See exception message in this case
     * @throws IllegalArgumentException if arguments is null or empty
     */
    public Response<List<User>> getChats(String sessionId) throws ApiException {
        if (sessionId.isBlank())
            throw new IllegalArgumentException();

        Call<Response<List<User>>> chats = service.getChats(sessionId);
        return callService(chats);
    }

    /**
     * API for accessing the endpoint of the message list
     *
     * @param sessionId  Access token ID	E.g. de25cc16eb00960f076...
     * @param userId     User ID of the interlocutor	E.g. 4567
     * @param pageSize   Total message limit for each request	Recommended: 20
     * @param offsetUp   First message offset ID	This is only needed when loading old messages from the current chat.
     * @param offsetDown Last message offset ID	This is only needed when loading new messages from the current chat.
     * @return list of {@link Message} objects
     * @throws ApiException             if request return 4xx-5xx state codes. See exception message in this case
     * @throws IllegalArgumentException if arguments is null or empty
     */
    public Response<List<Message>> getMessages(String sessionId, int userId, int pageSize,
                                               int offsetUp, int offsetDown) throws ApiException {
        if (sessionId.isBlank() || userId <= 0)
            throw new IllegalArgumentException();

        Call<Response<List<Message>>> messages = service.getMessages(sessionId, userId, offsetUp, offsetDown, pageSize);
        return callService(messages);
    }

    /**
     * API for accessing the message search endpoint
     *
     * @param sessionId  Access token ID	E.g. de25cc16eb00960f076...
     * @param query      Search keyword	E.g. `Hello`
     * @param userId     User ID of the interlocutor	E.g. 4567
     * @param pageSize   Search result rows limit	Default is (50) rows
     * @param offsetUp   First message offset ID	This is only needed when loading previous messages.
     * @param offsetDown Last message offset ID	This is only needed when loading next messages.
     * @return list of {@link Message} objects
     * @throws ApiException             if request return 4xx-5xx state codes. See exception message in this case
     * @throws IllegalArgumentException if arguments is null or empty
     */
    public Response<List<Message>> searchMessages(String sessionId, String query, int userId,
                                                  int pageSize, int offsetUp, int offsetDown) throws ApiException {
        if (sessionId.isBlank())
            throw new IllegalArgumentException();

        Call<Response<List<Message>>> searchMessageResponseCall = service.searchMessages(sessionId, userId, query,
                offsetUp, offsetDown, pageSize);
        return callService(searchMessageResponseCall);
    }

    /**
     * API for accessing the endpoint of deleting a chat message
     *
     * @param sessionId Access token ID	E.g. de25cc16eb00960f076...
     * @param messageId Deleted message int ID	E.g. `34`
     * @return result of operation
     * @throws ApiException             if request return 4xx-5xx state codes. See exception message in this case
     * @throws IllegalArgumentException if arguments is null or empty
     */
    public Response<Void> deleteMessage(String sessionId, int messageId) throws ApiException {
        if (sessionId.isBlank() || messageId <= 0)
            throw new IllegalArgumentException();

        Call<Response<Void>> deleteMessageResponseCall = service.deleteMessage(sessionId, messageId);
        return callService(deleteMessageResponseCall);
    }

    /**
     * API for accessing the endpoint of clearing & deleting chat history
     *
     * @param sessionId           Access token ID	E.g. de25cc16eb00960f076...
     * @param userId              User ID of the interlocutor	E.g. 4567
     * @param deleteAfterClearing Delete chat after clearing	E.g. One of these options (1/0)
     * @return result of operation
     * @throws ApiException             if request return 4xx-5xx state codes. See exception message in this case
     * @throws IllegalArgumentException if arguments is null or empty
     */
    public Response<Void> clearChat(String sessionId, int userId, int deleteAfterClearing) throws ApiException {
        if (sessionId.isBlank() || userId <= 0)
            throw new IllegalArgumentException();

        Call<Response<Void>> clearChatResponseCall = service.clearChat(sessionId, userId, deleteAfterClearing);
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
