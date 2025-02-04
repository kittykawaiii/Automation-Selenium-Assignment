package day13_DynamicTable;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class Assignment_day33_1 {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.navigate().to("https://testautomationpractice.blogspot.com/");
        driver.manage().window().maximize();

        //Count number of pages
        List<WebElement> pages = driver.findElements(By.xpath("//ul[@id='pagination']//li"));
        System.out.println(pages.size());

        //repeating clicking pages
        for (int p = 1; p <= pages.size(); p++) {
            if (p > 1) {
                WebElement active_page = driver.findElement(By.xpath("//ul[@id='pagination']//li[" + p + "]"));
                active_page.click();
                Thread.sleep(3000);
            }

            //reading all data from the table
            int rows = driver.findElements(By.xpath("//table[@id='productTable']//tbody//tr")).size();

            for (int r = 1; r <= rows; r++) {
                String Product_name = driver.findElement(By.xpath("//table[@id='productTable']//tbody//tr[" + r + "]//td[2]")).getText();
                String Price = driver.findElement(By.xpath("//table[@id='productTable']//tbody//tr[" + r + "]//td[3]")).getText();
                System.out.println(Product_name + "\t" + Price);
            }

            //click all check-boxes in all pages
            for (int r = 1; r <= rows; r++) {
                WebElement checkbox = driver.findElement(By.xpath("//table[@id='productTable']//tbody//tr[" + r + "]//td[4]//input"));
                checkbox.click();
            }

        }
    }
}