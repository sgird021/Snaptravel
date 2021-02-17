package com.snaptravel.hotelbooking.page;

import com.snaptravel.hotelbooking.util.Utils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.testng.Reporter;

public class SearchPage extends BasePage {

  private static final String SEARCH_INPUT = "input[class*=\"omnisearch\"]";
  private static final String SEARCH_BUTTON = "a[class*=\"button\"]";
  private static final String HOTEL_NAME = "div[class*=\"test-click\"]";
  private static final String CLOSE_SEARCHICON = "span[class*=\"omnisearch\"] > img";

  // SEARCH_INPUT input
  @FindBy(how = How.CSS, using = SEARCH_INPUT)
  private WebElement searchInput;

  @FindBy(how = How.CSS, using = CLOSE_SEARCHICON)
  private WebElement closeIcon;

  // SearchButton
  @FindBy(how = How.CSS, using = SEARCH_BUTTON)
  private WebElement searchButton;

  // Hotel Name
  @FindBy(how = How.CSS, using = HOTEL_NAME)
  private WebElement hotelName;

  public SearchPage(WebDriver driver) {
    super(driver);
    PageFactory.initElements(new AjaxElementLocatorFactory(driver, INIT_TIMEOUT), this);
  }

  public void searchHotel(String text) {
    clickElement(closeIcon);
    Utils.pause(5);
    searchInput.sendKeys(text);
    clickElement(searchButton);
    Utils.pause(5);
  }

  public String searchByCity(String searchKeyword, boolean expectSuccess) {
    searchHotel(searchKeyword);
    if (expectSuccess) {
      try {
        driver.navigate().refresh();
        return Boolean.toString(isAt());
      } catch (Exception e) {
        Reporter.log("Unable to search for a hotel");
        return "Unable to search for a hotel";
      }
    } else {
      return "test";
    }
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
      urlContains("mapview?encrypted_user_id");
      return true;
    } catch (Exception e) {
      Reporter.log("Unable to Search for a Hotel");
      return false;
    }
  }
}
