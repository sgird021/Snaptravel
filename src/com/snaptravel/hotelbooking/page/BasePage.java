package com.snaptravel.hotelbooking.page;

import com.snaptravel.hotelbooking.util.Utils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BasePage {
  protected static final Integer INIT_TIMEOUT = 8;
  protected static WebDriverWait wait;
  protected WebDriver driver;
  private JavascriptExecutor jsExecutor;

  public BasePage(WebDriver driver) {
    this.driver = driver;
    this.jsExecutor = (JavascriptExecutor) driver;
    new Utils(driver);
    new Page(driver);
    wait = new WebDriverWait(driver, Utils.localWait);
  }

  public static void pause(int i) {
    try {
      Thread.sleep(i * 500);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

  public static WebElement waitElement(String css) {
    return wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(css)));
  }

  public static WebElement waitElement(WebElement element) {
    return wait.until(ExpectedConditions.elementToBeClickable(element));
  }

  abstract public void waitPageLoad();

  abstract public void goTo();

  abstract public boolean isAt();

  public void clickElement(WebElement element) {
    waitElement(element).click();
  }

  public boolean urlContains(String path) {
    ExpectedCondition<Boolean> ec = ExpectedConditions.urlContains(path);
    boolean r = wait.until(ec);
    return r;
  }

}
