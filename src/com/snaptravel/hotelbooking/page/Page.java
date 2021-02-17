/**
 *
 */
/**
 * @author mgarg


 *
 */
package com.snaptravel.hotelbooking.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class Page {

	private static WebDriver _driver;

	@SuppressWarnings("static-access")
	public Page(WebDriver driver) {
		this._driver = driver;
	}

	public static SearchPage searchPage() {
		PageFactory.initElements(_driver, SearchPage.class);
		return new SearchPage(_driver);
	}

  public static HotelListPage hotelListPage() {
    PageFactory.initElements(_driver, HotelListPage.class);
    return new HotelListPage(_driver);
  }

  public static HotelDetailsPage hotelDetailsPage() {
    PageFactory.initElements(_driver, HotelDetailsPage.class);
    return new HotelDetailsPage(_driver);
  }

  public static BookingPage bookingPage() {
    PageFactory.initElements(_driver, BookingPage.class);
    return new BookingPage(_driver);
  }

  public static BookingConfirmedPage bookingConfirmedPage() {
    PageFactory.initElements(_driver, BookingConfirmedPage.class);
    return new BookingConfirmedPage(_driver);
  }
}
