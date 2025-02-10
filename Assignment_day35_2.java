package day15_MouseAction;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class Assignment_day35_2 {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.navigate().to("https://demo.guru99.com/test/drag_drop.html");
        driver.manage().window().maximize();

        Actions act_1=new Actions(driver);

        WebElement bank_block= driver.findElement(By.xpath("//a[normalize-space()='BANK']"));
        WebElement deb_account = driver.findElement(By.xpath("//table[@id='table4']//tbody//tr//td//div[@id='shoppingCart1']//ol[@id='bank']"));

        act_1.dragAndDrop(bank_block,deb_account).perform();

        Actions act_2=new Actions(driver);

        WebElement money_block1= driver.findElement(By.xpath("//section[@id='g-container-main']//li[2]//a[1]"));
        WebElement deb_amount = driver.findElement(By.xpath("//table[@id='table4']//tbody//tr//td//div[@id='shoppingCart4']//ol[@id='amt7']"));

        act_2.dragAndDrop(money_block1,deb_amount).perform();

        WebElement debit_movement = driver.findElement(By.xpath("//div[@id='bal3']//tr//td//div[@id='t7']"));

        if (debit_movement.getText().equals("5000")){
            System.out.println("Drag successful :) ");
        }
        else {
            System.out.println("Drag failed :< ");
        }

        Actions act_3=new Actions(driver);

        WebElement sale_block = driver.findElement(By.xpath("//a[normalize-space()='SALES']"));
        WebElement cre_account = driver.findElement(By.xpath("//table[@id='table4']//tbody//tr//td//ol[@id='loan']"));

        act_3.dragAndDrop(sale_block,cre_account).perform();

        Actions act_4=new Actions(driver);

        WebElement money_block2= driver.findElement(By.xpath("//section[@id='g-container-main']//li[4]//a[1]"));
        WebElement cre_amount = driver.findElement(By.xpath("//table[@id='table4']//tbody//tr//td//div[@id='shoppingCart4']//ol[@id='amt8']"));

        act_4.dragAndDrop(money_block2,cre_amount).perform();

        WebElement credit_movement = driver.findElement(By.xpath("//div[@id='bal3']//tr//td//div[@id='t8']"));

        if (credit_movement.getText().equals("5000")){
            System.out.println("Drag successful :) ");
        }
        else {
            System.out.println("Drag failed :< ");
        }

        driver.quit();


    }
}
