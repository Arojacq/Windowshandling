package testscript;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class WebPage {

	@Test
	public void AmazonPage() throws Exception {

		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.navigate().to("https://www.amazon.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		Reporter.log("**************Amazon page Launched*************", true);

		String mainid = driver.getWindowHandle();
		System.out.println(mainid);
		driver.findElement(By.xpath("//*[@name='field-keywords']")).sendKeys("Appeal Phone");
		driver.findElement(By.xpath("//*[@value='Go']")).click();

		List<WebElement> li = driver.findElements(By.xpath("//*[@class='a-size-medium a-color-base a-text-normal']"));

		for (int i = 0; i < 3; i++) {
			li.get(i).click();
		}
			Set<String> cid = driver.getWindowHandles();
			System.out.println(cid);

			for (String Ci : cid) {
				if (!Ci.equals(mainid)) {
					driver.switchTo().window(Ci);
					Thread.sleep(300);
					WebElement text = driver.findElement(By.xpath("//*[@id='priceblock_ourprice']"));
					String st = text.getAttribute("innerText");
					System.out.println(st);

				} driver.close();

			}

		}

	}
