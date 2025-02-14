package day6_Methods;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment {
    public static void main(String[] args) {

        WebDriver driver=new ChromeDriver();
        driver.get("https://testautomationpractice.blogspot.com/");

        //System.out.println(driver.getTitle());

        //String window_ID=driver.getWindowHandle();
        //System.out.println("Window ID: "+window_ID);


        /*driver.findElement(By.xpath("//a[@id='apple']")).click();
        Set<String> window_IDs=driver.getWindowHandles();
        System.out.println(window_IDs);
         */

        WebElement logo=driver.findElement(By.xpath("//h1[normalize-space()='Automation Testing Practice']"));
        System.out.println("Display status of logo: "+logo.isDisplayed());

        boolean status=driver.findElement(By.xpath("//button[normalize-space()='START']")).isEnabled();
        System.out.println("Button_status: "+status);

        WebElement Sunday_checkbox=driver.findElement(By.xpath("//input[@id='sunday']"));

        System.out.println("Before selection");
        System.out.println(Sunday_checkbox.isSelected());


        System.out.println("After selection");
        Sunday_checkbox.click();
        System.out.println(Sunday_checkbox.isSelected());

        driver.close();




















    }
}
