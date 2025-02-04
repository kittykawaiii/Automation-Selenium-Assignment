package day11_Dropdowns;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class Assignment_3 {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.navigate().to("https://testautomationpractice.blogspot.com/");
        driver.manage().window().maximize();

        //driver.findElement(By.xpath("//option[@value='blue']")).click();

        List<WebElement>options=driver.findElements(By.xpath("//select[@id='colors']//option"));
        System.out.println(options.size());

        for (WebElement color:options)
        {
            System.out.println(color.getText());
        }

    }
}
