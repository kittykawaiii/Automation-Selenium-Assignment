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

        List<WebElement> result_links = driver.findElements(By.xpath("//div[@id='Wikipedia1_wikipedia-search-results']//a"));
        List<WebElement> total_results = new ArrayList<>(result_links);
        WebElement more = driver.findElement(By.xpath("//a[normalize-space()='More »']"));
        total_results.add(more);

        System.out.println(total_results.size());

        // Click each link

        for (int i = 0; i < total_results.size(); i++) {
            total_results.get(i).click();

        }

        // Get Window ID + title from each Window

        Set<String> Window_IDs = driver.getWindowHandles();
        List<String> Window_list = new ArrayList<>(Window_IDs);

        for (String win_id : Window_list) {
            System.out.println("Window ID: "+win_id);
            driver.switchTo().window(win_id);

            System.out.println("Current Window Title: " + driver.getTitle());
        }

        // Close specific window

        for (String Window_close : Window_IDs) {
            String title = driver.switchTo().window(Window_close).getTitle();

            if (title.equals("Automation Testing Practice"))
            {
                driver.close();
            }
        }
        }
    }
