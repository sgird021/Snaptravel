package com.snaptravel.hotelbooking.test;

import com.snaptravel.hotelbooking.page.Page;
import org.junit.Assert;
import org.testng.annotations.Test;

/**
 * Tests Booking a hotel functionality functionality.
 *
 */


@Test(testName = "Booking a room at Vegas ", priority = 1)
public class TestHotelBooking extends BaseTest {

  @Test(description = "Logs in with valid credentials", enabled = true)
  public void testLogin() throws Exception {
    Page.searchPage().searchByCity("Las Vegas", true);
    Page.hotelListPage().clickOnAHotel(true);
    Page.hotelDetailsPage().clickOnAReserve();
    Page.bookingPage().enterGuestInformationAndClickNext();
    Page.bookingPage().enterCardInformation();
    Assert.assertTrue(Page.bookingConfirmedPage().isBookingSuccessful());
  }
}



