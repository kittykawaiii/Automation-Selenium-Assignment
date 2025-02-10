package day14_Calendar;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class Assignment_day34 {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        driver.navigate().to("https://dummy-tickets.com/buyticket");
        driver.manage().window().maximize();

        driver.findElement(By.xpath("//a[normalize-space()='Both']")).click();
        driver.findElement(By.xpath("//input[@value='multicityfh']")).click();

        //Choose "From"
        driver.findElement(By.xpath("//div[@id='twotabtabtthree']//div[@id='multicityfh']//input[@name='source[]']")).sendKeys("Hano");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='multicityfh']//div[@class='col-sm-12 p-0 suggestion-container'][1]//ul[@class='suggestions-list']")));

        List<WebElement> from_city_options = driver.findElements(By.xpath("//div[@class='col-sm-12 p-0 suggestion-container'][1]//ul[@class='suggestions-list']//div[@class='suggestion-block']//div[@class='city']"));

        for (WebElement from_option: from_city_options){
            if (from_option.getText().contains("Hanoi")){
                from_option.click();
                break;
            }
        }

        //Choose "To"
        driver.findElement(By.xpath("//div[@id='twotabtabtthree']//div[@id='multicityfh']//input[@name='destination[]']")).sendKeys("Toky");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='multicityfh']//div[@class='col-sm-12 p-0 suggestion-container'][2]//ul[@class='suggestions-list']")));
        List<WebElement> to_city_options = driver.findElements(By.xpath("//div[@class='col-sm-12 p-0 suggestion-container'][2]//ul[@class='suggestions-list']//div[@class='suggestion-block']//div[@class='city']"));

        for (WebElement to_option: to_city_options){
            if (to_option.getText().contains("Tokyo")){
                to_option.click();
                break;
            }
        }

        //Choose departure time
        String dep_year="2026";
        String dep_month="May";
        String dep_date="10";

        driver.findElement(By.xpath("//div[@id='twotabtabtthree']//div[@id='multicityfh']//input[@name='departure[]']")).click();

        WebElement dep_year_dropdown=driver.findElement(By.xpath("//select[@aria-label='Select year']"));
        Select select_year=new Select(dep_year_dropdown);
        select_year.selectByVisibleText(dep_year);

        WebElement dep_month_dropdown=driver.findElement(By.xpath("//select[@aria-label='Select month']"));
        Select select_month=new Select(dep_month_dropdown);
        select_month.selectByVisibleText(dep_month);

        List<WebElement> dep_dates=driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//tbody//tr//td//a"));
        for(WebElement day:dep_dates)
        {
            if(day.getText().equals(dep_date))
            {
                day.click();
                break;
            }

        }

        //Choose checkin time
        String checkin_year="2026";
        String checkin_month="Sep";
        String checkin_date="23";

        Thread.sleep(5000);
        driver.findElement(By.xpath("//div[@id='twotabtabtthree']//div[@id='multicityfh']//input[@name='checkin[]']")).click();

        while (true) {
            String actual_year = driver.findElement(By.xpath("//span[@class='ui-datepicker-year']")).getText();

            if (actual_year.equals(checkin_year)) {
                break;
            }
            driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-e']")).click();
        }

        WebElement checkin_month_dropdown=driver.findElement(By.xpath("//select[@aria-label='Select month']"));
        Select select_checkin_month=new Select(checkin_month_dropdown);
        select_checkin_month.selectByVisibleText(checkin_month);

        List<WebElement> checkin_dates=driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//tbody//tr//td//a"));
        for(WebElement day:checkin_dates)
        {
            if(day.getText().equals(checkin_date))
            {
                day.click();
                break;
            }

        }

        //Choose checkout time
        String checkout_year="2027";
        String checkout_month="Jan";
        String checkout_date="1";

        driver.findElement(By.xpath("//div[@id='twotabtabtthree']//div[@id='multicityfh']//input[@name='checkout[]']")).click();

        while (true) {
            String actual_year = driver.findElement(By.xpath("//span[@class='ui-datepicker-year']")).getText();

            if (actual_year.equals(checkout_year)) {
                break;
            }
            driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-e']")).click();
        }

        WebElement checkout_month_dropdown=driver.findElement(By.xpath("//select[@aria-label='Select month']"));
        Select select_checkout_month=new Select(checkout_month_dropdown);
        select_checkout_month.selectByVisibleText(checkout_month);

        List<WebElement> checkout_dates=driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//tbody//tr//td//a"));
        for(WebElement day:checkout_dates)
        {
            if(day.getText().equals(checkout_date))
            {
                day.click();
                break;
            }

        }



    }
}

