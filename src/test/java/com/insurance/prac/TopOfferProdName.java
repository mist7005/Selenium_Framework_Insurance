package com.insurance.prac;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TopOfferProdName {
	public static void main(String[] args) {
//		String xpath="//div[@id='container']//h2/parent::div/parent::div/following-sibling::div/descendant::div[contains(text(),'%s%Off')]";
//		String xpath2="//div[@id='container']//h2/parent::div/parent::div/following-sibling::div/descendant::div[contains(text(),'%s% Off')]";
		
		String titl1="//a[contains(@title,'%s')]/div[@class='_3LU4EM']";
		String xp=String.format(titl1, "10");

		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://www.flipkart.com/offers-store?otracker=nmenu_offer-zone&fm=neo%2Fmerchandising&iid=M_d187a388-03f1-446a-890e-186e1a980317_1_372UD5BXDFYS_MC.G6ZC4RAJ9OHU&otracker=hp_rich_navigation_8_1.navigationCard.RICH_NAVIGATION_Top%2BOffers_G6ZC4RAJ9OHU&otracker1=hp_rich_navigation_PINNED_neo%2Fmerchandising_NA_NAV_EXPANDABLE_navigationCard_cc_8_L0_view-all&cid=G6ZC4RAJ9OHU");
		
		List<WebElement> tFinal=driver.findElements(By.xpath(xp));
		for (WebElement ele : tFinal) {
			System.out.println(ele.getText());
		}
		
		
	
	}

}
