package org.base;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.Duration;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import org.apache.commons.io.FileUtils;
import org.configuration.PropertiesReader;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass extends PropertiesReader {
	public static WebDriver driver;

	public static void iniBrow(String browser) {

		switch (browser) {
		case "Chrome":

			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			break;
		case "Edge":

			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			driver.manage().window().maximize();

			break;

		default:
			System.out.println("Not Initialized");
			break;
		}

	}

	public static void getUrl(String url) {
		driver.get(url);

	}

	public static void jsClick(WebElement element) {

		try {
			Thread.sleep(2000);
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", element);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void jsMove(WebElement element) {
		try {
			Thread.sleep(2000);
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void jsMoveCor() {
		try {
			((JavascriptExecutor) driver).executeScript("window.scrollBy(0,3000 );");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void switchToFrame(WebElement element) {
		driver.switchTo().frame(element);

	}

	public static void actionMoveTo(WebElement element) {
		try {

			Actions action = new Actions(driver);
			action.moveToElement(element).build().perform();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void clickAction() {
		Actions actions = new Actions(driver);

		int xCoordinate = 500;
		int yCoordinate = 300;

		actions.moveByOffset(xCoordinate, yCoordinate).click().perform();

	}

	public static void jsSelect(WebElement element, String value) {
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].value='" + value + "'", element);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void selectByVisibleText(WebElement element, String text) {

		Select s = new Select(element);
		s.selectByVisibleText(text);

	}

	public static void selectByIndex(WebElement element, int index) {

		Select s = new Select(element);
		s.selectByIndex(index);
	}

	public static void selectByValue(WebElement element, String value) {

		try {
			Select s = new Select(element);
			s.selectByValue(value);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void elementVisible(WebElement element) {
		try {
			String script = "arguments[0].style.display='block';";
			((JavascriptExecutor) driver).executeScript(script, element);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void screenShot(String name) {
		try {

			TakesScreenshot shot = (TakesScreenshot) driver;
			File source = shot.getScreenshotAs(OutputType.FILE);
			File target = new File("target\\" + name + ".jpeg");
			FileUtils.copyFile(source, target);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void switchtoChildWindowForMultiWindow(int SwitchWindowIndex) {

		try {

			Set<String> allWindowId = driver.getWindowHandles();

			List<String> li = new LinkedList<>();

			li.addAll(allWindowId);
			String windowHandles = li.get(SwitchWindowIndex);
			driver.switchTo().window(windowHandles);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void saveToCSV(String productName, String productPrice) {
		try (FileWriter writer = new FileWriter("src\\test\\resources\\amazon.csv")) {
			writer.append("Name,Price\n");
			writer.append(productName + "," + productPrice);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
