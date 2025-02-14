package day13_DynamicTable;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class Assignment_day33_2 {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.navigate().to("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        driver.manage().window().maximize();

        //Login
        driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("Admin");
        driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("admin123");
        driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();

        // Access Admin page
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[1]//a[1]//span[1]"))).click();

        // Get total of records
        WebElement recordCountElement = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[@class='oxd-text oxd-text--span']")));
        String text = recordCountElement.getText();

        // Extract the number of records from the text
        int totalRecords = Integer.parseInt(text.substring(text.indexOf("(") + 1, text.indexOf(")")));
        System.out.println("Total Records: " + totalRecords);

        // Find all rows in the table
        List<WebElement> rows = driver.findElements(By.xpath(".//div[@class='oxd-table-card']"));
        System.out.println("Total rows: " + rows.size());


        // Read all the data
        for (int r = 0; r < rows.size(); r++) {
            // Find all columns in the current row
            List<WebElement> columns = rows.get(r).findElements(By.xpath(".//div[@class='oxd-table-cell oxd-padding-cell']"));
            System.out.println("Total columns in row " + (r + 1) + ": " + columns.size());

            /*
            for (WebElement column : columns) {
                System.out.print(column.getText() + "\t");
            }
            System.out.println(); // Move to the next line after printing a row

         */

            // Delete user
            /*
            if (columns.get(1).getText().equals("Geetha")) {
                // Locate the "Delete" button in the same row and click it
                WebElement deleteButton = rows.get(r).findElement(By.xpath("//i[@class='oxd-icon bi-trash']"));
                deleteButton.click();
                driver.findElement(By.xpath("//button[normalize-space()='Yes, Delete']")).click();
            }

             */

            //Edit user
            if (columns.get(1).getText().equals("Jobinsam@6742")) {
                // Locate the "Edit" button in the same row and click it
                WebElement editButton = rows.get(r).findElement(By.xpath(".//i[@class='oxd-icon bi-pencil-fill']"));
                editButton.click();
            }

                // Click all check-boxes
                /*List<WebElement> checkBoxes = driver.findElements(By.xpath("//div[@class='oxd-table-card-cell-checkbox']"));
                for (WebElement checkBox : checkBoxes) {
                    if (!checkBox.isSelected()) { // Check if the checkbox is not already selected
                        checkBox.click();
                    }
                }

                 */

            }
        }
    }




