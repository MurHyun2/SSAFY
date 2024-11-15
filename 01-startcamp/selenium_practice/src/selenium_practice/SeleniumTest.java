package selenium_practice;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumTest {
	public static void main(String[] args) throws IOException {
		WebDriver driver = new ChromeDriver();
		String nick = "널보는내마음은어느새여름";

		try {
			driver.get("https://lostark.game.onstove.com/Main");

			WebElement we = driver.findElement(
					By.cssSelector("#modal-summer > div > div > div.lui-modal__button > button.button--close"));
			we.click();

			we = driver.findElement(
					By.cssSelector("#modal-mokoko > div > div > div.lui-modal__button > button.button--close"));
			we.click();

			we = driver.findElement(By.cssSelector("#lostark-wrapper > header > nav > ul > li:nth-child(2) > a"));
			we.click();

			we = driver.findElement(By.cssSelector(
					"#lostark-wrapper > div > main > div > div > div.profile-search > form > fieldset > input"));
			we.sendKeys(nick);
			we.sendKeys(Keys.ENTER);

			we = driver.findElement(By.cssSelector(
					"#profile-ability > div.lui-tab.profile-ability-tab > div.lui-tab__menu.ability-menu > a:nth-child(3)"));
			we.click();

			List<WebElement> jewels = driver.findElements(By.cssSelector("#profile-jewel .jewel_level"));

			ArrayList<Integer> list = new ArrayList<>();
			int num = 1;

			for (WebElement el : jewels) {
				String lv = el.getText();
				list.add(Integer.parseInt(lv.substring(3)));

				System.out.println(num + "번째 보석 : " + lv);
				num++;
			}
			System.out.println();

			int jwNum = 0;

			for (Integer i : list) {
				if (i <= 5) {
					jwNum++;
				}
			}
			
			if (list.size() != 11) {
				System.out.println("####################");
				System.out.println("##주의 보석이 부족합니다.##");
				System.out.println("####################");
			}

			if (jwNum != 0) {
				System.out.println("##주의## 쌀먹입니다!!");
				System.out.println("5레벨 이하 보석 " + jwNum + "개 존재..");
			}

		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
		} finally {
			// 브라우저 닫기
//			driver.quit();
		}

	}
}
