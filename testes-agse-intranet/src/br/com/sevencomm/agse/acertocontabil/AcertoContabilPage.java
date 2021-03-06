package br.com.sevencomm.agse.acertocontabil;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;

public class AcertoContabilPage {

	public static void main(String[] args) throws AWTException,
			InterruptedException {

//		System.setProperty("webdriver.chrome.driver",
//				"C:\\Ferramental\\chromedriver_win32\\chromedriver.exe");
//		WebDriver browser = new ChromeDriver();

		WebDriver browser = new InternetExplorerDriver();

		browser.get("http://10.100.49.146:9080/agse");

		// Code to handle Basic Browser Authentication in Selenium.
		Alert aa = browser.switchTo().alert();
		aa.sendKeys("m1036");

		Robot a = new Robot();
		a.keyPress(KeyEvent.VK_TAB);

		boolean capsLigado = Toolkit.getDefaultToolkit().getLockingKeyState(KeyEvent.VK_CAPS_LOCK);

		if (capsLigado) {
			a.keyPress(KeyEvent.VK_CAPS_LOCK);
		}

		a.keyPress(KeyEvent.VK_G);
		a.keyPress(KeyEvent.VK_S);
		a.keyPress(KeyEvent.VK_E);
		a.keyPress(KeyEvent.VK_G);
		a.keyPress(KeyEvent.VK_0);
		a.keyPress(KeyEvent.VK_1);
		a.keyPress(KeyEvent.VK_1);

		a.keyPress(KeyEvent.VK_ENTER);
		a.keyPress(KeyEvent.VK_ENTER);

		// Webelement is the main menu Link
		Thread.sleep(5000);
		WebElement webElement = browser.findElement(By.id("menuItemN2_1_2"));
		Actions act = new Actions(browser);
		act.moveToElement(webElement).build().perform(); // This opens menu list
		Thread.sleep(1000);
		act.click();
		
		browser.close();

	}

}
