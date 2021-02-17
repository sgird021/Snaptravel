/**
 * @author mgarg
 */
/**
 * @author mgarg
 *
 */

package com.snaptravel.hotelbooking.test;

import com.snaptravel.hotelbooking.page.Page;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public abstract class BaseTest {

 private static final String SELENIUM_SERVER_ENDPOINT = "http://127.0.0.1:4444/wd/hub";
  public WebDriver _driver;
  @SuppressWarnings("unused")
  private ThreadLocal<RemoteWebDriver> remoteWebDriver = new ThreadLocal<RemoteWebDriver>();

  /**
   * Sets up the remoteWebDriver and selenium instance to use for testing.
   *
   * @throws Exception
   */

  public void setUp() throws Exception {
    System.setProperty("webdriver.chrome.driver", "./chromedriver.exe");
    ChromeOptions options = new ChromeOptions();
    options.addArguments("--start-maximized");
    options.addArguments("--disable-notifications");

    _driver = new ChromeDriver(options);
    _driver.get("https://staging.snaptravel.com/search?encrypted_user_id=BZ18EE-j_XQAPEzGzj91cQ");
    _driver.manage().window().maximize();
    _driver.navigate().refresh();
    _driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    new Page(_driver);

  }

  public void tearDown() {
    _driver.close();
    _driver.quit();

  }

  @BeforeMethod(alwaysRun = true)
  public void beforeMethod() throws Exception {
    setUp();
  }

  @AfterMethod(alwaysRun = true)
  public void afterMethod(ITestResult result) {
       tearDown();
  }

}
