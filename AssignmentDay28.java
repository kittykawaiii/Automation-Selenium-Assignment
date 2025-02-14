package day8_Browser_Navigational;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Assignment {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.navigate().to("https://testautomationpractice.blogspot.com/");
        driver.manage().window().maximize();

        // Search + click "Search"

        driver.findElement(By.xpath("//input[@id='Wikipedia1_wikipedia-search-input']")).sendKeys("selenium");
        driver.findElement(By.xpath("//input[@type='submit']")).click();

        // Count number of links

        List<WebElement> resultLinks = driver.findElements(By.xpath("//div[@id='Wikipedia1_wikipedia-search-results']//a"));
        List<WebElement> totalResults = new ArrayList<>(resultLinks);
        WebElement more = driver.findElement(By.xpath("//a[normalize-space()='More »']"));
        totalResults.add(more);

        System.out.println(totalResults.size());

        // Click each link

        for (int i = 0; i < totalResults.size(); i++) {
            totalResults.get(i).click();

        }

        // Get Window ID + title from each Window

        Set<String> WindowIDs = driver.getWindowHandles();
        List<String> WindowList = new ArrayList<>(WindowIDs);

        for (String winId : WindowList) {
            System.out.println("Window ID: "+winId);
            driver.switchTo().window(winId);

            System.out.println("Current Window Title: " + driver.getTitle());
        }

        // Close specific window

        for (String windowClose : WindowIDs) {
            String title = driver.switchTo().window(windowClose).getTitle();

            if (title.equals("Automation Testing Practice"))
            {
                driver.close();
            }
        }
        }
    }
