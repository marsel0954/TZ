package api.petstore;

import io.restassured.response.Response;
import org.testng.annotations.Test;

public class ExamplePetTest extends BasePetsoreApiTest {
    @Test(description = "Получение информации о кредитах клиента")
    public void getClientCretids() {
        Response response = baseRequestGet("v2/store/inventory");

    }
}
