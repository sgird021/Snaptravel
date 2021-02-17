package com.snaptravel.hotelbooking.page;

import com.snaptravel.hotelbooking.util.Utils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.testng.Reporter;

public class BookingConfirmedPage extends BasePage {

  private static final String SUCCESSFUL_BOOKING = "img[src*=\"confirmation\"]";

  @FindBy(how = How.CSS, using = SUCCESSFUL_BOOKING)
  private WebElement successfulBooking;

  public BookingConfirmedPage(WebDriver driver) {
    super(driver);
    PageFactory.initElements(new AjaxElementLocatorFactory(driver, INIT_TIMEOUT), this);
  }

  @Override
  public boolean isAt() {
    try {
      urlContains("confirmation");
      return true;
    } catch (Exception e) {
      Reporter.log("Expected web page is incorrect");
      return false;
    }
  }

  public boolean isBookingSuccessful() {
    Utils.pause(10);
    waitElement(successfulBooking);
    return Utils.exist(successfulBooking) && isAt();
  }

  @Override
  public void waitPageLoad() {
  }

  @Override
  public void goTo() {
  }
}
