package com.snaptravel.hotelbooking.page;

import com.snaptravel.hotelbooking.util.Utils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.testng.Reporter;

public class HotelDetailsPage extends BasePage {

  private static final String RESERVE_A_ROOM = "div[class*=\"hotel_card_button\"]";

  // SEARCH_INPUT input
  @FindBy(how = How.CSS, using = RESERVE_A_ROOM)
  private WebElement reserveARoom;

  public HotelDetailsPage(WebDriver driver) {
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
      urlContains("bookings");
      return true;
    } catch (Exception e) {
      Reporter.log("Unable to Click on reserve  Hotel");
      return false;
    }
  }

  public void clickOnAReserve() {
    Utils.scrollToBottom();
    clickElement(reserveARoom);
    Utils.pause(5);
  }
  }
