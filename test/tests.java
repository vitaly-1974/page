import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import static org.testng.Assert.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import selenium1.FunctionalTest1;
import selenium1.ReceiptPage1;
import selenium1.SignUpPage1;


public class tests extends FunctionalTest1 {
    @BeforeClass
    public static void setUpClass() throws Exception {
        System.setProperty("webdriver.firefox.marionette","/export/geckodriver");
        FirefoxProfile profile = new FirefoxProfile();
        profile.setPreference("network.proxy.type", 4);
        profile.setPreference("browser.startup.homepage", "about:blank");
        profile.setPreference("startup.homepage_welcome_url", "about:blank");
        profile.setPreference("startup.homepage_welcome_url.additional", "about:blank");
        driver = new FirefoxDriver(profile);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
        driver.close();
    }

    @BeforeMethod
    public void setUpMethod() throws Exception {
    }

    @AfterMethod
    public void tearDownMethod() throws Exception {
    }
    
    @Test
    public void test1() {
                driver.get("http://www.kimschiller.com/page-object-pattern-tutorial/index.html");
		
		SignUpPage1 signUpPage = new SignUpPage1(driver);
		assertTrue(signUpPage.isInitialized());

		signUpPage.enterName("First", "Last");
		signUpPage.enterAddress("123 Street", "12345");

		ReceiptPage1 receiptPage = signUpPage.submit();
		assertTrue(receiptPage.isInitialized());

		assertEquals("Thank you!", receiptPage.confirmationHeader());
    }

  
}    
