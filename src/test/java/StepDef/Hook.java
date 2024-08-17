package StepDef;

import base.config;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.testng.util.Strings;

public class Hook extends config {
    public static String url;
    public static String browserType=System.getProperty("browser");

    public static String envType = System.getProperty("env");

    @Before
    public void beforeEachTest() {
        if (Strings.isNullOrEmpty(envType)){
            envType = "QA";
        }
        if (Strings.isNullOrEmpty(browserType)){
            browserType = "chrome";
        }

        driver = setupBrowser(browserType);
        switch (envType.toUpperCase()) {

            case "QA":
                driver.get("https://qa.taltektc.com");
                break;
            case "STAGE":
                driver.get("https://stage.taltektc.com");
                break;
            case "PROD":
                driver.get("https://prod.taltektc.com");
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + envType);

        }
}
 @After()
    public void afterEachTest(){
     driver.quit();
    }
}