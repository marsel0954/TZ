package patterns.builder;

import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class BuilderTest {

    @Test
    public void builderTest(){
        UserModel user1 = UserModel.builder()
                .age(33)
                .salary(30.000)
                .isMarried(false)
                .password("my_pswm")
                .username("parampampam").build();

        UserModel user2 = UserModel.builder()
                .age(33)
                .salary(10.000)
                .build();

        System.out.println(user1);
        System.out.println();
        System.out.println(user2);

        given().auth().oauth2("Somebody token")
                .contentType(ContentType.JSON)
                .body(user2)
                .get("google.com");
    }
}
