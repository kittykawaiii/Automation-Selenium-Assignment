package day9_Checkbox_Alert;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Assignment_Alert {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

        driver.get("https://bestbike-dev.vnit.top/sign-in");
        driver.manage().window().maximize();

        driver.findElement(By.xpath("//input[@id=':r0:-form-item']")).sendKeys("admin@gmail.com");
        driver.findElement(By.xpath("//input[@id=':r1:-form-item']")).sendKeys("123456aA");

        driver.findElement(By.xpath("//button[normalize-space()='Log in']")).click();
        Thread.sleep(30000);

        driver.findElement(By.xpath("//span[@class='text-sm text-black-2']")).click();

        driver.findElement(By.xpath("//a[@href='/accounts-management']")).click();

        driver.findElement(By.xpath("//tbody/tr[2]/td[8]/div[1]/button[3]/div[1]//*[name()='svg']")).click();
        Thread.sleep(5000);

        driver.findElement(By.xpath("//button[normalize-space()='Cancel']")).click();















    }
}
