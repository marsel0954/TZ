package soap;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class SoapExampleTest {
/**
** Пример запроса. Не найден рабочий тренировычный сервис
**/
    @Test
    public void soapTry(){
        String wsdlUrl = "http://webservices.oorsprong.org/websamples.countryinfo/CountryInfoService.wso?wsdl";

        given()
                .contentType("text/xml")
                .body("<soap:Envelope xmlns:soap=\"http://www.w3.org/2003/05/soap-envelope\" " +
                        "xmlns:web=\"http://www.oorsprong.org/websamples.countryinfo\">\n" +
                        "   <soap:Header/>\n" +
                        "   <soap:Body>\n" +
                        "      <web:CapitalCity>\n" +
                        "         <web:sCountryISOCode>?</web:sCountryISOCode>\n" +
                        "      </web:CapitalCity>\n" +
                        "   </soap:Body>\n" +
                        "</soap:Envelope>")
                .when()
                .post("http://example.com/soap-endpoint")
                .then()
                .statusCode(404);
    }
}
