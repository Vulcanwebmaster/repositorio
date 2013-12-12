package br.com.sevencomm.agse.acertocontabil;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class AcertoContabilPage {

	public static void main(String[] args) throws AWTException,
			InterruptedException {

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

	}

}
