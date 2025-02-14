package day11_Dropdowns;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class Assignment_1 {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.navigate().to("https://phppot.com/demo/jquery-dependent-dropdown-list-countries-and-states/");
        driver.manage().window().maximize();

        WebElement dropdown= driver.findElement(By.xpath("//select[@id='country-list']"));
        Select dropdownCountry = new Select(dropdown);

        List<WebElement> options= dropdownCountry.getOptions();
        System.out.println(options.size());

        for (WebElement option:options)
        {
            System.out.println(option.getText());
        }

        //dropdownCountry.selectByVisibleText("USA");
        //dropdownCountry.selectByValue("4");
        dropdownCcountry.selectByIndex(1);

    }
}
