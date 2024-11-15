package selenium_practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumTest1 {

	public static void main(String[] args) {
		// 1. 크롬 드라이버를 사용할 준비를 한다.
		// 자바와 크롬을 연동하기 위한 준비
		WebDriver driver = new ChromeDriver();

		// 2. 접속하고자 하는 웹페이지의 주소를 작성한다.
		driver.get("https://www.naver.com/");
//		 driver.get("https://finance.naver.com/");
		
		WebElement financeButton = driver.findElement(By.cssSelector("#shortcutArea > ul > li:nth-child(6) > a"));
		System.out.println(financeButton);
		
		// 증권 메뉴를 클릭해보자
		financeButton.click();
//		
	}
}
