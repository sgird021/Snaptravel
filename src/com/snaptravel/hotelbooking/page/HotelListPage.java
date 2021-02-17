package com.snaptravel.hotelbooking.page;

import com.snaptravel.hotelbooking.util.Utils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.testng.Reporter;

import java.util.ArrayList;

public class HotelListPage extends BasePage {

  private static final String VIEW_DETAIL_BUTTON = "div[class*=\"button_component\"]";

  // SEARCH_INPUT input
  @FindBy(how = How.CSS, using = VIEW_DETAIL_BUTTON)
  private WebElement viewDetailButton;

  public HotelListPage(WebDriver driver) {
    super(driver);
    PageFactory.initElements(new AjaxElementLocatorFactory(driver, INIT_TIMEOUT), this);
  }

  @Override
  public void waitPageLoad() {
  }

  @Override
  public void goTo() {
  }

  @Override
  public boolean isAt() {
    try {
      urlContains("hotels");
      return true;
    } catch (Exception e) {
      Reporter.log("Unable to Click on a Hotel");
      return false;
    }
  }

  public String clickOnAHotel(boolean expectSuccess) {
    clickElement(viewDetailButton);
    Utils.pause(5);

    ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
    driver.switchTo().window(tabs.get(1));
    if (expectSuccess) {
      try {
        return Boolean.toString(isAt());

      } catch (Exception e) {
        Reporter.log("Unable to Click on a  hotel");
        // driver.quit();
        return "Unable to Click on a  hotel";
      }
    } else {
      System.out.println("false");
      return "Error Message";
    }
  }
}
