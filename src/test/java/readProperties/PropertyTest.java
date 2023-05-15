package readProperties;

import org.testng.annotations.Test;

import java.io.IOException;


public class PropertyTest {
    @Test
    public void readPropeties() throws IOException {
        System.getProperties().load(ClassLoader.getSystemResourceAsStream("application.properties"));
        String urlFromProperties = System.getProperty("url");
        System.out.println(urlFromProperties);
    }
}
