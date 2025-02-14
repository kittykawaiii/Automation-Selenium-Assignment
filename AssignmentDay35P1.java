package day15_MouseAction;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class Assignment_day35_1 {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.navigate().to("https://testautomationpractice.blogspot.com/");
        driver.manage().window().maximize();

        // Double click

        String inputText ="kawaii";

        WebElement inputBox1 = driver.findElement(By.xpath("//input[@id='field1']"));
        String currentValue = input_box1.getAttribute("value");
        if (currentValue != null && !currentValue.isEmpty()) {
            inputBox1.clear();
        }
        inputBox1.sendKeys(inputText);

        WebElement button = driver.findElement(By.xpath("//button[normalize-space()='Copy Text']"));

        Actions act = new Actions(driver);
        act.doubleClick(button).perform();

        WebElement inputBox2 = driver.findElement(By.xpath("//input[@id='field2']"));
        String copiedValue = inputBox2.getAttribute("value");

        if (copiedValue.equals(input_text)){
            System.out.println("Button worked!");
        }
        else {
            System.out.println("Button failed!");
        }

        // Drag & Drop

        Actions actDrag=new Actions(driver);

        WebElement drag = driver.findElement(By.xpath("//div[@id='draggable']"));
        WebElement drop = driver.findElement(By.xpath("//div[@id='droppable']"));

        actDrag.dragAndDrop(drag,drop).perform();

        WebElement dropText = driver.findElement(By.xpath("//p[normalize-space()='Dropped!']"));

        if (dropText.getText().equals("Dropped!")){
            System.out.println("Drop successful!");
        }
        else {
            System.out.println("Drop failed :(");
        }

        driver.quit();


    }
    }
