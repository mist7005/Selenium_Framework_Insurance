package prac1;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ScenarioSelenium {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver=new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.icc-cricket.com/rankings/mens/player-rankings/t20i");
		driver.findElement(By.xpath("//a[contains(text(),'Men')]/ancestor::div[@class='rankings-menu__tab-container u-hide-tablet']//following-sibling::div[@class='active tab-content']//a[text()='Team Rankings']")).click();
		List<WebElement> team = driver.findElements(By.xpath("//table//tbody//tr//td[2]"));
		List<WebElement> matches = driver.findElements(By.xpath("//table//tbody//tr//td[3]"));
		List<WebElement> rating = driver.findElements(By.xpath("//table//tbody//tr//td[5]"));
		
		for (int i = 0; i < team.size(); i++) {
			System.out.println(team.get(i).getText()+"   "+matches.get(i).getText()+"   "+rating.get(i).getText());
		}
	}

}
