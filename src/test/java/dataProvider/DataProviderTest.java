package dataProvider;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderTest {
    @DataProvider (name = "dpr")
    public Object[][] dataProviderMethod(){
        return new Object[][] {{"data1","data1"}};
    }
    @Test(dataProvider = "dpr")
    public void dpvTest(String assert1,String assert2){
        Assert.assertEquals(assert1,assert2);
        System.out.println(assert1 + " " + assert2);
    }

    @DataProvider(name = "DPlength")
    public Object[][] dpLength(){
        return new Object[][] {
                {"Слон",4},
                {"Енот",3},
                {"Еж",2},
                {"Кот", 3}};

    }
    @Test(dataProvider = "DPlength")
    public void truLength(String word, int expectedLegnth){
        int actualLength = word.length();
        Assert.assertEquals(actualLength,expectedLegnth);
        System.out.println(actualLength + "  " + expectedLegnth);
    }



}
