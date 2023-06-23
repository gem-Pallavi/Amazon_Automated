package automate;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import java.util.*;
import java.time.Duration;

public class AutomateAmazon {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Pallavi.Arora\\Downloads\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

        driver.get("https://www.amazon.in/");

        driver.findElement(By.xpath("//*[@id='twotabsearchtextbox']")).sendKeys("Books");
        driver.findElement(By.xpath("//*[@id='nav-search-submit-button']")).click();

        driver.findElement(By.xpath("//*[@id='a-autoid-0-announce']")).click();
        driver.findElement(By.xpath("//*[@id='s-result-sort-select_1']")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@id=\"n/64619755031\"]/span")).click();

        List<WebElement> title = driver.findElements(By.xpath("//span[@class='a-size-medium a-color-base a-text-normal']"));
        WebElement product = title.get(0);
        js.executeScript("arguments[0].scrollIntoView();", product);
        Thread.sleep(1000);
        product.click();

        ArrayList<String> wid = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(wid.get(1));

        driver.findElement(By.id("add-to-ebooks-cart-button")).click();

        driver.close();
        driver.switchTo().window(wid.get(0));
        WebElement product1 = title.get(1);
        js.executeScript("arguments[0].scrollIntoView();", product1);
        Thread.sleep(1000);
        product1.click();

        ArrayList<String> wid1 = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(wid1.get(1));
        driver.findElement(By.xpath("//*[@id='add-to-ebooks-cart-button']")).click();
        Thread.sleep(2000);

        driver.close();
        driver.switchTo().window(wid.get(0));
        driver.findElement(By.id("nav-cart")).click();

        driver.quit();
    }
}
