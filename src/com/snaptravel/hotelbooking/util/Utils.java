/**
 * @author mgarg
 */
/**
 * @author mgarg
 *
 */
package com.snaptravel.hotelbooking.util;

import com.snaptravel.hotelbooking.page.BasePage;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Utils {

  private static WebDriver driver;
  public static final int localWait = 15;

  public Utils(WebDriver driver) {
    this.driver = driver;
  }

  public static void pause(int i) {
    try {
      Thread.sleep(i * 500);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

  public static void scrollToBottom() {
    Utils.executeJS("window.scrollTo(0, 1000)");
    pause(3);
  }
  public static boolean exist(WebElement element){
    try{
      BasePage.waitElement(element).getTagName();
      return true;
    }catch(Exception e){
      return false;
    }
  }

  public static void executeJS(String js) {
    JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
    jsExecutor.executeScript(js);
  }
}



