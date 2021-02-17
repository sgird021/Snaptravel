package com.snaptravel.hotelbooking.page;

import com.snaptravel.hotelbooking.util.Utils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.testng.Reporter;

import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

public class BookingPage extends BasePage {

  private static final String CLICK_ON_NEXT = "btn-next-to-payment";
  private static final String CARD_NUMBER_INPUT = "pan";
  private static final String CARD_EXPIRY = "expiry-year";
  private static final String CARD_CVV = "cvv";
  private static final String CARD_NAME = "billing-name";
  private static final String CARD_BILLING_ADDRESS = "billing-address";
  private static final String SUGGESTED_BILLING_ADDRESS = "li[class*=\"geosuggest\"]";
  private static final String CARD_CITY = "city";
  private static final String CARD_STATE = "state";
  private static final String CARD_POSTALCODE = "zip";
  private static final String CARD_COUNTRY = "country-name";
  private static final String COMPLETE_BOOKING = "submit-payment";

  // SEARCH_INPUT input
  @FindBy(how = How.ID, using = CLICK_ON_NEXT)
  private WebElement clickonNext;

  @FindBy(how = How.ID, using = CARD_NUMBER_INPUT)
  private WebElement enterCardNumber;

  @FindBy(how = How.ID, using = CARD_EXPIRY)
  private WebElement enterCardExpiry;

  @FindBy(how = How.ID, using = CARD_CVV)
  private WebElement enterCardCvv;

  @FindBy(how = How.ID, using = CARD_NAME)
  private WebElement enterCardName;

  @FindBy(how = How.ID, using = CARD_BILLING_ADDRESS)
  private WebElement enterCardBillingAddress;

  @FindBy(how = How.CSS, using = SUGGESTED_BILLING_ADDRESS)
  private List<WebElement> suggestedBillingAddress;

  @FindBy(how = How.ID, using = CARD_CITY)
  private WebElement enterCardCity;

  @FindBy(how = How.NAME, using = CARD_STATE)
  private WebElement enterCardState;

  @FindBy(how = How.NAME, using = CARD_COUNTRY)
  private WebElement enterCardCountry;

  @FindBy(how = How.ID, using = CARD_POSTALCODE)
  private WebElement enterCardPostalCode;

  @FindBy(how = How.ID, using = COMPLETE_BOOKING)
  private WebElement completeBooking;

  public BookingPage(WebDriver driver) {
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
      Reporter.log("Unable to Click on a Hotel");
      return false;
    }
  }

  public void enterGuestInformationAndClickNext() {
    clickElement(clickonNext);
    Utils.pause(5);
  }

  public void enterCardInformation() throws ParseException {
    driver.switchTo().frame("iframe");
    enterCardNumber.sendKeys("4111 1111 1111 1111");
    driver.switchTo().defaultContent();
    enterCardExpiry.sendKeys(getExpiryDate());
    enterCardCvv.sendKeys("456");
    enterCardName.sendKeys("Test Card");
    enterCardBillingAddress.sendKeys("10 Front Street");
    suggestedBillingAddress.get(0).click();
    Utils.pause(3);
    completeBooking.click();
    Utils.pause(15);
  }

  public String getExpiryDate() {
    Date date = new Date();
    Calendar calendar = new GregorianCalendar();
    calendar.setTime(date);
    int year = (calendar.get(calendar.YEAR) + 2) % 100;
    int month = calendar.get(Calendar.MONTH);
    return String.format("%02d", month) + "/" + String.valueOf(year);
  }
}
