package client;

import constants.Endpoints;
import io.qameta.allure.Step;
import io.restassured.response.Response;
import model.User;

import static io.restassured.RestAssured.given;

public class UserApiClient {

    @Step("Создание пользователя через API")
    public Response createUser(User user) {
        return given()
                .baseUri(Endpoints.BASE_URL)
                .header("Content-Type", "application/json")
                .body(user)
                .when()
                .post(Endpoints.REGISTER);
    }

    @Step("Логин пользователя через API")
    public Response loginUser(User user) {
        return given()
                .baseUri(Endpoints.BASE_URL)
                .header("Content-Type", "application/json")
                .body(user)
                .when()
                .post(Endpoints.LOGIN);
    }

    @Step("Удаление пользователя через API")
    public Response deleteUser(String accessToken) {
        return given()
                .baseUri(Endpoints.BASE_URL)
                .header("Authorization", accessToken)
                .when()
                .delete(Endpoints.USER);
    }

    @Step("Получение токена из ответа")
    public String getAccessToken(Response response) {
        return response.then().extract().path("accessToken");
    }
}