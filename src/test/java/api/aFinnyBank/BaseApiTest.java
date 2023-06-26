package api.aFinnyBank;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public abstract class BaseApiTest {
    RequestSpecification requestSpec = new RequestSpecBuilder()
            .setBaseUri("https://a-finny-dev.astondevs.ru:30101/api/v1/")
            .setContentType(ContentType.JSON)
            .addHeader("Content-Type", "application-json")
            .addHeader("Authorization", tokenAuth())
            .log(LogDetail.ALL)
            .build();

    public String tokenAuth() {
        RestAssured.baseURI = "https://a-finny-dev.astondevs.ru:30101";

        RequestSpecification request = RestAssured.given();

        String logpass = "{\n" +
                "  \"login\": \"MR2417879\",\n" +
                "  \"password\": \"qpMc39zas\",\n" +
                "  \"type\": \"PASSPORT_NUMBER\"\n" +
                "}";
        request.header("Content-Type", "application/json");

        Response responseFromGenerateToken = request.body(logpass).post("/api/v1/login");

        responseFromGenerateToken.prettyPrint();

        String jsonString = responseFromGenerateToken.getBody().asString();

        String token = JsonPath.from(jsonString).get("accessToken");
        return token;
    }
    public Response baseRequestGet(String basePath) {
        Response response = given()
                .spec(requestSpec)
                .basePath(basePath)
                .when().get();

        response.prettyPrint();

        return response;
    }
}
