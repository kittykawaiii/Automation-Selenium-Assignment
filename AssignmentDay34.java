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

        List<WebElement> fromCityOptions = driver.findElements(By.xpath("//div[@class='col-sm-12 p-0 suggestion-container'][1]//ul[@class='suggestions-list']//div[@class='suggestion-block']//div[@class='city']"));

        for (WebElement fromOption: fromCityOptions){
            if (fromOption.getText().contains("Hanoi")){
                fromOption.click();
                break;
            }
        }

        //Choose "To"
        driver.findElement(By.xpath("//div[@id='twotabtabtthree']//div[@id='multicityfh']//input[@name='destination[]']")).sendKeys("Toky");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='multicityfh']//div[@class='col-sm-12 p-0 suggestion-container'][2]//ul[@class='suggestions-list']")));
        List<WebElement> toCityOptions = driver.findElements(By.xpath("//div[@class='col-sm-12 p-0 suggestion-container'][2]//ul[@class='suggestions-list']//div[@class='suggestion-block']//div[@class='city']"));

        for (WebElement toOption: toCityOptions){
            if (toOption.getText().contains("Tokyo")){
                toOption.click();
                break;
            }
        }

        //Choose departure time
        String depYear="2026";
        String depMonth="May";
        String depDate="10";

        driver.findElement(By.xpath("//div[@id='twotabtabtthree']//div[@id='multicityfh']//input[@name='departure[]']")).click();

        WebElement depYearDropdown=driver.findElement(By.xpath("//select[@aria-label='Select year']"));
        Select selectYear=new Select(depYearDropdown);
        selectYear.selectByVisibleText(depYear);

        WebElement depMonthDropdown=driver.findElement(By.xpath("//select[@aria-label='Select month']"));
        Select selectMonth=new Select(depMonthDropdown);
        selectMonth.selectByVisibleText(depMonth);

        List<WebElement> depDates=driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//tbody//tr//td//a"));
        for(WebElement day:depDates)
        {
            if(day.getText().equals(depDate))
            {
                day.click();
                break;
            }

        }

        //Choose checkin time
        String checkinYear="2026";
        String checkinMonth="Sep";
        String checkinDate="23";

        Thread.sleep(5000);
        driver.findElement(By.xpath("//div[@id='twotabtabtthree']//div[@id='multicityfh']//input[@name='checkin[]']")).click();

        while (true) {
            String actualYear = driver.findElement(By.xpath("//span[@class='ui-datepicker-year']")).getText();

            if (actualYear.equals(checkinYear)) {
                break;
            }
            driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-e']")).click();
        }

        WebElement checkinMonthDropdown=driver.findElement(By.xpath("//select[@aria-label='Select month']"));
        Select selectCheckinMonth=new Select(checkinMonthDropdown);
        selectCheckinMonth.selectByVisibleText(checkinMonth);

        List<WebElement> checkinDates=driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//tbody//tr//td//a"));
        for(WebElement day:checkinDates)
        {
            if(day.getText().equals(checkinDate))
            {
                day.click();
                break;
            }

        }

        //Choose checkout time
        String checkoutYear="2027";
        String checkoutMonth="Jan";
        String checkoutDate="1";

        driver.findElement(By.xpath("//div[@id='twotabtabtthree']//div[@id='multicityfh']//input[@name='checkout[]']")).click();

        while (true) {
            String actualYear = driver.findElement(By.xpath("//span[@class='ui-datepicker-year']")).getText();

            if (actualYear.equals(checkoutYear)) {
                break;
            }
            driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-e']")).click();
        }

        WebElement checkoutMonthDropdown=driver.findElement(By.xpath("//select[@aria-label='Select month']"));
        Select selectCheckoutMonth=new Select(checkoutMonthDropdown);
        selectCheckoutMonth.selectByVisibleText(checkoutMonth);

        List<WebElement> checkoutDates=driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//tbody//tr//td//a"));
        for(WebElement day:checkoutDates)
        {
            if(day.getText().equals(checkoutDate))
            {
                day.click();
                break;
            }
        }
    }
}

