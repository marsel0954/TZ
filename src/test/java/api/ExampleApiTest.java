package api;

import io.restassured.response.Response;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

public class ExampleApiTest extends BaseApiTest {

    /*Проверки*/

    @Test(description = "Получение информации о клиенте")
    public void getInformationAboutUser() {

        Response response = baseRequestGet("/information");

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(response.jsonPath().getString("firstName"), "Андрей");
        softAssert.assertEquals(response.jsonPath().getString("lastName"), "Сайапин");
        softAssert.assertEquals(response.jsonPath().getString("mobilePhone"), "375335298911");
        softAssert.assertAll();

        response.then().assertThat().body(matchesJsonSchemaInClasspath("jsonScheme/informationUsers.json"));
    }

    @Test(description = "Получение информации о кредитах клиента")
    public void getClientCretids() {
        Response response = baseRequestGet("/credits");

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(response.jsonPath().getString("name[0]"), "Рефинансирование");
        softAssert.assertEquals(response.jsonPath().getString("creditCurrencyCode[0]"), "RUB");
        softAssert.assertAll();
    }
}
