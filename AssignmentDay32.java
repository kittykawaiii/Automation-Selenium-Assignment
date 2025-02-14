package day12_StaticWebTable;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Assignment {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.navigate().to("https://blazedemo.com/");
        driver.manage().window().maximize();

        // Select departure city
        WebElement dropdown1 = driver.findElement(By.xpath("//select[@name='fromPort']"));
        Select drpDeparture = new Select(dropdown_1);
        drpDeparture.selectByVisibleText("San Diego");

        // Select destination city
        WebElement dropdown2 = driver.findElement(By.xpath("//select[@name='toPort']"));
        Select drpDestination = new Select(dropdown_2);
        drpDestination.selectByVisibleText("New York");

        // Click "Find Flights"
        driver.findElement(By.xpath("//input[@value='Find Flights']")).click();

        // Get the prices and corresponding "Choose This Flight" buttons
        List<WebElement> priceElements = driver.findElements(By.xpath("//table[@class='table']//tr/td[6]"));
        List<WebElement> chooseButtons = driver.findElements(By.xpath("//table[@class='table']//tr/td[1]/input"));
        List<Double> prices = new ArrayList<>();

        // Extract prices and convert them to double
        for (WebElement priceElement : priceElements) {
            String priceText = priceElement.getText().replace("$", ""); // Remove the dollar sign
            double price = Double.parseDouble(priceText); // Convert to double
            prices.add(price); // Add to the list
        }

        // Find the index of the cheapest price
        double cheapestPrice = Collections.min(prices);
        int cheapestIndex = prices.indexOf(cheapestPrice);

        // Click the "Choose This Flight" button for the cheapest price
        WebElement cheapestButton = chooseButtons.get(cheapestIndex);
        cheapestButton.click();

        // Verify that we are on the purchase page
        String purchasePageTitle = driver.getTitle();
        if (purchasePageTitle.contains("BlazeDemo Purchase")) {
            System.out.println("Successfully navigated to the purchase page for the cheapest flight!");
        } else {
            System.out.println("Failed to navigate to the purchase page.");
        }

        Thread.sleep(5000);

        // Fill in information

        driver.findElement(By.xpath("//input[@id='inputName']")).sendKeys("kittykawaii");
        driver.findElement(By.xpath("//input[@id='address']")).sendKeys("123A");
        driver.findElement(By.xpath("//input[@id='city']")).sendKeys("New York");
        driver.findElement(By.xpath("//input[@id='state']")).sendKeys("California");
        driver.findElement(By.xpath("//input[@id='zipCode']")).sendKeys("ABC123");

        driver.findElement(By.xpath("//select[@id='cardType']")).click();
        driver.findElement(By.xpath("//option[@value='dinersclub']")).click();

        driver.findElement(By.xpath("//input[@id='creditCardNumber']")).sendKeys("00112233");

        WebElement month = driver.findElement(By.xpath("//input[@id='creditCardMonth']"));
        month.clear();
        month.sendKeys("9");

        WebElement year = driver.findElement(By.xpath("//input[@id='creditCardYear']"));
        year.clear();
        year.sendKeys("2025");

        Thread.sleep(5000);

        driver.findElement(By.xpath("//input[@id='nameOnCard']")).sendKeys("kittykawaii");
        driver.findElement(By.xpath("//input[@id='rememberMe']")).click();

        driver.findElement(By.xpath("//input[@value='Purchase Flight']")).click();

        // Verify that was successful purchase
        String successfulPurchase = driver.getTitle();
        if (successfulPurchase.contains("BlazeDemo Confirmation")) {
            System.out.println("Thank you for your purchase today!");
        } else {
            System.out.println("Failed purchased");
        }

        // Close the browser
        driver.quit();
    }
}






