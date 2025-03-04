package day21_ExcelUtils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

public class AssignmentDay41 {
    public static void main(String[] args) throws IOException, InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.navigate().to("https://www.cit.com/cit-bank/resources/calculators/certificate-of-deposit-calculator");
        driver.manage().window().maximize();

        String filePath = "/Users/dieulypham/IdeaProjects/KittyLearnSelenium/testdata/caldata.xlsx";
        int rows = ExcelUtils.getRowCount(filePath, "Sheet1");

        for (int i=1; i<=rows;i++) {
            //1) Read data from Excel
            String amount = ExcelUtils.getCellData(filePath, "Sheet1", i, 0);
            String month = ExcelUtils.getCellData(filePath, "Sheet1", i, 1);
            String interest = ExcelUtils.getCellData(filePath, "Sheet1", i, 2);
            String com = ExcelUtils.getCellData(filePath, "Sheet1", i, 3);
            String total = ExcelUtils.getCellData(filePath, "Sheet1", i, 4);

            //2) Pass data into application
            WebElement depAmount = driver.findElement(By.xpath("//input[@id='mat-input-0']"));
            depAmount.clear();
            depAmount.sendKeys(amount);

            WebElement length = driver.findElement(By.xpath("//input[@id='mat-input-1']"));
            length.clear();
            length.sendKeys(month);

            WebElement intRate = driver.findElement(By.xpath("//input[@id='mat-input-2']"));
            intRate.clear();
            intRate.sendKeys(interest);
            Thread.sleep(3000);

            driver.findElement(By.xpath("//div[@class='mat-select-arrow-wrapper ng-tns-c109-4']")).click();
            List<WebElement> options =driver.findElements(By.xpath("//div[@role='listbox']//mat-option//span"));
            for (WebElement option: options){
                if (option.getText().contains(com)){
                    option.click();
                    break;
                }
            }
            driver.findElement(By.xpath("//button[@id='CIT-chart-submit']")).click();

            //3) Validation

            String actTotal = driver.findElement(By.xpath("//span[@id='displayTotalValue']")).getText();
            String cleanedTotal = total.replace("$", "").replace(",", "");
            String cleanedActTotal = actTotal.replace("$", "").replace(",", "");

            if (Double.parseDouble(cleanedTotal) == Double.parseDouble(cleanedActTotal)) {
                System.out.println("Test passed");
                ExcelUtils.setCellData(filePath, "Sheet1", i, 6, "Passed");
                ExcelUtils.fillGreenColor(filePath, "Sheet1", i, 6);
            } else {
                System.out.println("Test failed");
                ExcelUtils.setCellData(filePath, "Sheet1", i, 6, "Failed");
                ExcelUtils.fillRedColor(filePath, "Sheet1", i, 6);
            }
            Thread.sleep(3000);
        }
        driver.quit();
    }
}
