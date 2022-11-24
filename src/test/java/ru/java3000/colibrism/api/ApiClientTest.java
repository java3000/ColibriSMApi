package ru.java3000.colibrism.api;

import okhttp3.logging.HttpLoggingInterceptor;
import org.junit.jupiter.api.*;
import ru.java3000.colibrism.api.exception.ApiException;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class ApiClientTest {

    final ApiClient client = new ApiClient("https://rutvit.com/", HttpLoggingInterceptor.Level.BODY);
    String authToken = "";
    String refreshToken = "";

    @Test
    @Order(1)
    void login() {
        try {
            var user = client.login("mailfortwitter@internet.ru","P@ssw0rd");

            assertNotNull(user);
            assertEquals("mailfortwitter@internet.ru", user.getEmail());

            authToken = user.getAuth().getAuthToken();
            refreshToken = user.getAuth().getRefreshToken();

        } catch (ApiException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    @Disabled
    void feeds() {
        try {
            var response = client.feeds(this.authToken, 0, 20);

            assertNotNull(response);
        } catch (ApiException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    @Order(2)
    void refreshAccessToken() {
        try {
            var response = client.refreshAccessToken(this.refreshToken);

            assertNotNull(response);
            assertNotEquals(this.authToken, response.getAuthToken());

        } catch (ApiException e) {
            throw new RuntimeException(e);
        }

    }

    @Test
    @Disabled
    void verifyUser() {
    }

    @Test
    @Disabled
    void votePoll() {
    }

    @Test
    @Disabled
    void toggleLike() {
    }

    @Test
    @Disabled
    void reportPost() {
    }

    @Test
    @Disabled
    void repost() {
    }

    @Test
    @Disabled
    void fetchLikes() {
    }

    @Test
    @Disabled
    void deletePost() {
    }

    @Test
    @Disabled
    void searchHashtag() {
    }

    @Test
    @Order(3)
    void searchHashtagAny() {
        try {
            var response = client.searchHashtag(this.authToken, "russia", 0, 20);
            assertNotNull(response);
        } catch (ApiException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    @Disabled
    void searchPeople() {
    }

    @Test
    @Order(4)
    void searchPeopleAny() {
        try {
            var response = client.searchPeople(this.authToken, " ", 0, 20);
            assertNotNull(response);
        } catch (ApiException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    @Disabled
    void searchPost() {
    }

    @Test
    @Order(5)
    void searchPostAny() {
        try {
            var response = client.searchPost(this.authToken, " ", 0, 20);
            assertNotNull(response);
        } catch (ApiException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    @Disabled
    void updateProfile() {
    }

    @Test
    @Disabled
    void toggleFollow() {
    }

    @Test
    @Disabled
    void fetchFollowing() {
    }

    @Test
    @Disabled
    void fetchFollowers() {
    }

    @Test
    @Disabled
    void getNotifications() {
    }

    @Test
    @Disabled
    void deleteNotifications() {
    }

    @Test
    @Disabled
    void deleteAccount() {
    }

    @Test
    @Order(6)
    @Disabled
    void changeLanguage() {
        try {
            var responseGood = client.changeLanguage(this.authToken, "russian");

            //assertThrows(IllegalArgumentException.class, () -> client.changeLanguage(this.authToken, "klingon"));
            assertTrue(responseGood);
        } catch (ApiException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    @Disabled
    void getProfile() {
    }

    @Test
    @Disabled
    void getProfileMy() {
    }

    @Test
    @Disabled
    void getProfilePosts() {
    }

    @Test
    @Disabled
    void getProfilePostsMy() {
    }

    @Test
    @Disabled
    void uploadPostMedia() {
    }

    @Test
    @Disabled
    void deletePostMedia() {
    }

    @Test
    @Disabled
    void publishPost() {
    }

    @Test
    @Disabled
    void changePostPrivacy() {
    }

    @Test
    @Disabled
    void uploadSwiftMedia() {
    }

    @Test
    @Disabled
    void deleteSwiftMedia() {
    }

    @Test
    @Disabled
    void publishSwift() {
    }

    @Test
    @Disabled
    void deleteSwift() {
    }

    @Test
    @Disabled
    void getSwifts() {
    }

    @Test
    @Disabled
    void registerSwiftView() {
    }

    @Test
    @Disabled
    void fetchThreadData() {
    }

    @Test
    @Disabled
    void fetchThreadReplies() {
    }

    @Test
    @Disabled
    void getBookmarks() {
    }

    @Test
    @Disabled
    void toggleBookmark() {
    }

    @Test
    @Disabled
    void changeAvatar() {
    }

    @Test
    @Disabled
    void changeCover() {
    }

    @Test
    @Disabled
    void coverReposition() {
    }

    @Test
    @Disabled
    void getPrivacySettings() {
    }

    @Test
    @Disabled
    void setPrivacySettings() {
    }

    @Test
    @Disabled
    void followRequests() {
    }

    @Test
    @Disabled
    void approveFollowRequest() {
    }

    @Test
    @Disabled
    void ignoreFollowRequest() {
    }

    @Test
    @Disabled
    void sendMessage() {
    }

    @Test
    @Disabled
    void getChats() {
    }

    @Test
    @Disabled
    void getMessages() {
    }

    @Test
    @Disabled
    void searchMessages() {
    }

    @Test
    @Disabled
    void deleteMessage() {
    }

    @Test
    @Disabled
    void clearChat() {
    }

    @Test
    @Order(999)
    void logout() {
        try {
            var response = client.logout(this.authToken);
            assertTrue(response);
        } catch (ApiException e) {
            throw new RuntimeException(e);
        }
    }
}