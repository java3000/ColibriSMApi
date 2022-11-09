package ru.java3000.colibrism.api;

import okhttp3.logging.HttpLoggingInterceptor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import ru.java3000.colibrism.api.dto.entity.Auth;
import ru.java3000.colibrism.api.dto.entity.User;
import ru.java3000.colibrism.api.dto.entity.UserWrapper;
import ru.java3000.colibrism.api.dto.response.Response;
import ru.java3000.colibrism.api.exception.ApiException;

import static org.junit.jupiter.api.Assertions.*;

class ApiClientTest {

    ApiClient client = new ApiClient("https://rutvit.com/", HttpLoggingInterceptor.Level.BODY);
    String authToken = "";
    
    @Test
    @Order(1)
    void login() {
        try {
            var user = client.login("mailfortwitter@internet.ru","P@ssw0rd");

            assertNotNull(user);
            assertEquals("mailfortwitter@internet.ru", user.getEmail());

            authToken = user.getAuth().getAuthToken();

        } catch (ApiException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void feeds() {
        try {
            var response = client.feeds(authToken, 0, 20);

            assertNotNull(response);
        } catch (ApiException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void reportUser() {
    }

    @Test
    void toggleBlockUser() {
    }

    @Test
    void savePushNotificationToken() {
    }

    @Test
    void changePassword() {
    }

    @Test
    void refreshAccessToken() {
    }

    @Test
    void verifyUser() {
    }

    @Test
    void votePoll() {
    }

    @Test
    void toggleLike() {
    }

    @Test
    void reportPost() {
    }

    @Test
    void repost() {
    }

    @Test
    void fetchLikes() {
    }

    @Test
    void deletePost() {
    }

    @Test
    void searchHashtag() {
    }

    @Test
    void searchPeople() {
    }

    @Test
    void searchPost() {
    }

    @Test
    void updateProfile() {
    }

    @Test
    void toggleFollow() {
    }

    @Test
    void fetchFollowing() {
    }

    @Test
    void fetchFollowers() {
    }

    @Test
    void getNotifications() {
    }

    @Test
    void deleteNotifications() {
    }

    @Test
    void deleteAccount() {
    }

    @Test
    void changeLanguage() {
    }

    @Test
    void getProfile() {
    }

    @Test
    void getProfilePosts() {
    }

    @Test
    void uploadPostMedia() {
    }

    @Test
    void deletePostMedia() {
    }

    @Test
    void publishPost() {
    }

    @Test
    void changePostPrivacy() {
    }

    @Test
    void uploadSwiftMedia() {
    }

    @Test
    void deleteSwiftMedia() {
    }

    @Test
    void publishSwift() {
    }

    @Test
    void deleteSwift() {
    }

    @Test
    void getSwifts() {
    }

    @Test
    void registerSwiftView() {
    }

    @Test
    void fetchThreadData() {
    }

    @Test
    void fetchThreadReplies() {
    }

    @Test
    void getBookmarks() {
    }

    @Test
    void toggleBookmark() {
    }

    @Test
    void changeAvatar() {
    }

    @Test
    void changeCover() {
    }

    @Test
    void coverReposition() {
    }

    @Test
    void getPrivacySettings() {
    }

    @Test
    void setPrivacySettings() {
    }

    @Test
    void followRequests() {
    }

    @Test
    void approveFollowRequest() {
    }

    @Test
    void ignoreFollowRequest() {
    }

    @Test
    void sendMessage() {
    }

    @Test
    void getChats() {
    }

    @Test
    void getMessages() {
    }

    @Test
    void searchMessages() {
    }

    @Test
    void deleteMessage() {
    }

    @Test
    void clearChat() {
    }

    @Test
    void logout() {
    }
}