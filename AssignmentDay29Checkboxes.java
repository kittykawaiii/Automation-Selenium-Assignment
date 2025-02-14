package day9_Checkbox_Alert;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Assignment_Checkboxes {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://testautomationpractice.blogspot.com/");
        driver.manage().window().maximize();
        
        driver.findElement(By.xpath("//a[normalize-space()='2']")).click();

        List<WebElement> checkboxes=driver.findElements(By.xpath("//td//input[contains(@type,'checkbox')]"));

        for (WebElement checkbox:checkboxes)
        {
            checkbox.click();
        }

        driver.findElement(By.xpath("//a[normalize-space()='1']")).click();

        List<WebElement> checkboxes1=driver.findElements(By.xpath("//td//input[contains(@type,'checkbox')]"));

        for (WebElement checkbox1:checkboxes1)
        {
            checkbox1.click();
        }

        driver.findElement(By.xpath("//a[normalize-space()='2']")).click();

        driver.findElement(By.xpath("//tbody/tr[1]/td[4]/input[1]")).click();

        List<WebElement> checkboxes=driver.findElements(By.xpath("//td//input[contains(@type,'checkbox')]"));

        for (int i = 0; i<3; i++)
        {
            checkboxes.get(i).click();
        }
        for (int i = 2; i< checkboxes.size(); i++)
        {
            checkboxes.get(i).click();
        }
    }
}
