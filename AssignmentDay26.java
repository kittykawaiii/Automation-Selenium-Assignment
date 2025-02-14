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

        //String windowID=driver.getWindowHandle();
        //System.out.println("Window ID: "+windowID);


        /*driver.findElement(By.xpath("//a[@id='apple']")).click();
        Set<String> windowIDs=driver.getWindowHandles();
        System.out.println(windowIDs);
         */

        WebElement logo=driver.findElement(By.xpath("//h1[normalize-space()='Automation Testing Practice']"));
        System.out.println("Display status of logo: "+logo.isDisplayed());

        boolean status=driver.findElement(By.xpath("//button[normalize-space()='START']")).isEnabled();
        System.out.println("Button status: "+status);

        WebElement SundayCheckbox=driver.findElement(By.xpath("//input[@id='sunday']"));

        System.out.println("Before selection");
        System.out.println(SundayCheckbox.isSelected());


        System.out.println("After selection");
        SundayCheckbox.click();
        System.out.println(SundayCheckbox.isSelected());

        driver.close();

    }
}
