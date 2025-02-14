package day15_MouseAction;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class AssignmentDay35P2 {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.navigate().to("https://demo.guru99.com/test/drag_drop.html");
        driver.manage().window().maximize();

        Actions act1=new Actions(driver);

        WebElement bankBlock= driver.findElement(By.xpath("//a[normalize-space()='BANK']"));
        WebElement debAccount = driver.findElement(By.xpath("//table[@id='table4']//tbody//tr//td//div[@id='shoppingCart1']//ol[@id='bank']"));

        act1.dragAndDrop(bankBlock,debAccount).perform();

        Actions act2=new Actions(driver);

        WebElement moneyBlock1= driver.findElement(By.xpath("//section[@id='g-container-main']//li[2]//a[1]"));
        WebElement debAmount = driver.findElement(By.xpath("//table[@id='table4']//tbody//tr//td//div[@id='shoppingCart4']//ol[@id='amt7']"));

        act2.dragAndDrop(moneyBlock1,debAmount).perform();

        WebElement debitMovement = driver.findElement(By.xpath("//div[@id='bal3']//tr//td//div[@id='t7']"));

        if (debitMovement.getText().equals("5000")){
            System.out.println("Drag successful :) ");
        }
        else {
            System.out.println("Drag failed :< ");
        }

        Actions act3=new Actions(driver);

        WebElement saleBlock = driver.findElement(By.xpath("//a[normalize-space()='SALES']"));
        WebElement creAccount = driver.findElement(By.xpath("//table[@id='table4']//tbody//tr//td//ol[@id='loan']"));

        act3.dragAndDrop(saleBlock,creAccount).perform();

        Actions act4=new Actions(driver);

        WebElement moneyBlock2= driver.findElement(By.xpath("//section[@id='g-container-main']//li[4]//a[1]"));
        WebElement creAmount = driver.findElement(By.xpath("//table[@id='table4']//tbody//tr//td//div[@id='shoppingCart4']//ol[@id='amt8']"));

        act4.dragAndDrop(moneyBlock2,creAmount).perform();

        WebElement creditMovement = driver.findElement(By.xpath("//div[@id='bal3']//tr//td//div[@id='t8']"));

        if (creditMovement.getText().equals("5000")){
            System.out.println("Drag successful :) ");
        }
        else {
            System.out.println("Drag failed :< ");
        }

        driver.quit();


    }
}
