package StepDef;

import base.config;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.testng.util.Strings;

public class Hook extends config {
    public static String url;

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
                url = "https://qa.taltektc.com";

                break;
            case "STAGE":
                url = "https://stage.taltektc.com";
                break;
            case "PROD":
                url = "https://prod.taltektc.com";
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + envType);
        }
        driver.get(url);


}
 /* @After()
    public void afterEachTest(){
     driver.quit();
    }*/
}