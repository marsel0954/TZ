package api.petstore;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public abstract class BasePetsoreApiTest {
    RequestSpecification requestSpec = new RequestSpecBuilder()
            .setBaseUri("https://petstore.swagger.io/")
            .setContentType(ContentType.JSON)
            .addHeader("Content-Type", "application/json")
            .addHeader("api_key", tokenAuth())
            .log(LogDetail.ALL)
            .build();

    public String tokenAuth() {
        RestAssured.baseURI = "https://petstore.swagger.io/";

        RequestSpecification request = RestAssured.given();

        String logpass = "{\n" +
                "  \"username\": \"marsel0954u\",\n" +
                "  \"password\": \"cnklol123\"\n" +
                "}";
        request.header("Content-Type", "application/json");

        Response responseFromGenerateToken = request.body(logpass).get("v2/user/login");

        responseFromGenerateToken.prettyPrint();

        String jsonString = responseFromGenerateToken.getBody().asString();

        String message = JsonPath.from(jsonString).get("message");

        String[] parts = message.split(":");
        String token = parts[1];

        System.out.println("Значение токена доставаемого с response :" + token);
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
