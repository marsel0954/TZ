package api.kuCoin;

import io.restassured.http.ContentType;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.*;
import java.util.stream.Collectors;

import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;

public class KuCoinTest {
    @Test
    public List<PojoTickerData> getAllTickets(){

        return given()
                .contentType(ContentType.JSON)
                .when().get("https://api.kucoin.com/api/v1/market/allTickers")
                .then().log().body()
                .extract().jsonPath().getList("data.ticker", PojoTickerData.class);
    }

    @Test
    public void checkCrypto(){
        List<PojoTickerData> usdTickers = getAllTickets().stream().filter(s->s.getSymbol().endsWith("USDT")).collect(Collectors.toList());
        int a = 0;
        Assert.assertTrue(usdTickers.stream().allMatch(x->x.getSymbol().endsWith("USDT")));
    }
    @Test
    public void sortHighToLow(){
        List<PojoTickerData> highToLow = getAllTickets().stream().filter(x->x.getSymbol().endsWith("USDT")).sorted(new Comparator<PojoTickerData>() {
            @Override
            public int compare(PojoTickerData o1, PojoTickerData o2) {
                return o2.getChangeRate().compareTo(o1.getChangeRate());
            }
        }).collect(Collectors.toList());

        List<PojoTickerData> top10 = highToLow.stream().limit(10).collect(Collectors.toList());

        Assert.assertEquals(top10.get(0).getSymbol(),"UBXT-USDT");
    }

    @Test
    public void sortLowToHigh(){
        List<PojoTickerData> LowToHow = getAllTickets().stream().filter(x->x.getSymbol().endsWith("USDT"))
                .sorted(new TickerComparatorLow()).limit(10).collect(Collectors.toList());

        int a = 1;
    }

    @Test
    public void map(){
        Map<String,Float> usd = new HashMap<>();
        List<String> lowerCases = getAllTickets().stream().map(x->x.getSymbol().toLowerCase()).collect(Collectors.toList());
        getAllTickets().forEach(x->usd.put(x.getSymbol(),Float.parseFloat(x.getChangeRate())));

        List<TickerShort> shortList = new ArrayList<>();
        getAllTickets().forEach(x->shortList.add(new TickerShort(x.getSymbol(),Float.parseFloat(x.getChangeRate()))));

    }
}
