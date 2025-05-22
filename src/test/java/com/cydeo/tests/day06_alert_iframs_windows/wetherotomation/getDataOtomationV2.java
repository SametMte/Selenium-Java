package com.cydeo.tests.day06_alert_iframs_windows.wetherotomation;

import com.cydeo.utility.WebDriverFactory;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.io.*;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class getDataOtomationV2 {
    public static void main(String[] args) throws InterruptedException, IOException {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.weather.gov/wrh/Climate?wfo=gsp");

        for (int yearCounter = 1985; yearCounter <= 2025; yearCounter++) {
            for (int monthCounter = 0; monthCounter < 12; monthCounter++) {

                Thread.sleep(1000);
                driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@name='routine']")));
                Thread.sleep(1000);

                // Select location
                Select locationName = new Select(driver.findElement(By.xpath("//select[@name='station']")));
                locationName.selectByVisibleText("Pisgah Forest 1, NC");
                Thread.sleep(1500);

                // Select product
                WebElement productType = driver.findElement(By.xpath("//div[@class='input_block'][2]//label[.='Daily data for a month']"));
                productType.click();
                Thread.sleep(1500);

                // Open date picker
                WebElement dateChanger = driver.findElement(By.xpath("//img[@class='ui-datepicker-trigger']"));
                dateChanger.click();
                Thread.sleep(1500);

                // Select year dynamically
                Select yearSelecter = new Select(driver.findElement(By.xpath("//select[@class='ui-datepicker-year']")));
                List<WebElement> yearOptions = yearSelecter.getOptions();
                List<Integer> yearValues = new ArrayList<>();
                for (WebElement option : yearOptions) {
                    yearValues.add(Integer.parseInt(option.getText()));
                }

                int yearIndex = yearValues.indexOf(yearCounter);
                if (yearIndex != -1) {
                    yearSelecter.selectByIndex(yearIndex);
                    System.out.println("Seçilen yıl: " + yearCounter);
                } else {
                    System.out.println("Yıl bulunamadı: " + yearCounter);
                    driver.switchTo().defaultContent();
                    continue; // Bu yılı atla
                }

                // Select month
                Select monthSelecter = new Select(driver.findElement(By.xpath("//select[@class='ui-datepicker-month']")));
                monthSelecter.selectByIndex(monthCounter);

                // Confirm date
                WebElement doneButton = driver.findElement(By.xpath("//button[.='Done']"));
                doneButton.click();

                // View report
                WebElement viewButton = driver.findElement(By.xpath("//button[@id='go']"));
                viewButton.click();

                WebElement closeButton = driver.findElement(By.xpath("(//button[@title='Close'])[1]"));

                // Collect data
                List<WebElement> elements0 = driver.findElements(By.xpath("//tr//td[@class='col0']"));
                List<WebElement> elements1 = driver.findElements(By.xpath("//tr//td[@class='col1']"));
                List<WebElement> elements2 = driver.findElements(By.xpath("//tr//td[@class='col2']"));
                List<WebElement> elements3 = driver.findElements(By.xpath("//tr//td[@class='col3']"));
                List<WebElement> elements4 = driver.findElements(By.xpath("//tr//td[@class='col4']"));
                List<WebElement> elements5 = driver.findElements(By.xpath("//tr//td[@class='col5']"));
                List<WebElement> elements6 = driver.findElements(By.xpath("//tr//td[@class='col6']"));
                List<WebElement> elements7 = driver.findElements(By.xpath("//tr//td[@class='col7']"));
                List<WebElement> elements8 = driver.findElements(By.xpath("//tr//td[@class='col8']"));
                List<WebElement> elements9 = driver.findElements(By.xpath("//tr//td[@class='col9']"));

                List<String> col0 = new ArrayList<>();
                List<String> col1 = new ArrayList<>();
                List<String> col2 = new ArrayList<>();
                List<String> col3 = new ArrayList<>();
                List<String> col4 = new ArrayList<>();
                List<String> col5 = new ArrayList<>();
                List<String> col6 = new ArrayList<>();
                List<String> col7 = new ArrayList<>();
                List<String> col8 = new ArrayList<>();
                List<String> col9 = new ArrayList<>();

                for (int i = 0; i < elements0.size(); i++) {
                    col0.add(elements0.get(i).getText());
                    col1.add(elements1.get(i).getText());
                    col2.add(elements2.get(i).getText());
                    col3.add(elements3.get(i).getText());
                    col4.add(elements4.get(i).getText());
                    col5.add(elements5.get(i).getText());
                    col6.add(elements6.get(i).getText());
                    col7.add(elements7.get(i).getText());
                    col8.add(elements8.get(i).getText());
                    col9.add(elements9.get(i).getText());
                }

                List<List<String>> data = Arrays.asList(col0, col1, col2, col3, col4, col5, col6, col7, col8, col9);
                exportToExcel(data, "Pisgah Forest 1, NCtest.xlsx", "Pisgah Forest 1, NC");

                closeButton.click();
                Thread.sleep(1500);
                driver.switchTo().defaultContent();
                driver.navigate().refresh();
            }
        }
        driver.quit();
    }

    private static void exportToExcel(List<List<String>> allColumns, String fileName, String sheetName) throws IOException {
        Workbook workbook;
        Sheet sheet;

        File file = new File(fileName);
        boolean fileExists = file.exists();

        if (fileExists) {
            try (FileInputStream fis = new FileInputStream(file)) {
                workbook = new XSSFWorkbook(fis);
            }
        } else {
            workbook = new XSSFWorkbook();
        }

        sheet = workbook.getSheet(sheetName);
        boolean isNewSheet = false;

        if (sheet == null) {
            sheet = workbook.createSheet(sheetName);
            isNewSheet = true;

            Row header = sheet.createRow(0);
            header.createCell(0).setCellValue("Date");
            header.createCell(1).setCellValue("Temperature");
            header.createCell(5).setCellValue("HDD");
            header.createCell(6).setCellValue("CDD");
            header.createCell(7).setCellValue("Precipitation");
            header.createCell(8).setCellValue("New Snow");
            header.createCell(9).setCellValue("Snow Depth");
            header = sheet.createRow(1);
            header.createCell(1).setCellValue("Maximum");
            header.createCell(2).setCellValue("Minimum");
            header.createCell(3).setCellValue("Average");
            header.createCell(4).setCellValue("Departure");
        }

        int startRow = sheet.getLastRowNum() + 1;
        if (isNewSheet && startRow < 2) {
            startRow = 2;
        }

        int rowCount = allColumns.get(0).size();
        for (int i = 0; i < rowCount; i++) {
            Row row = sheet.createRow(startRow + i);
            for (int j = 0; j < allColumns.size(); j++) {
                row.createCell(j).setCellValue(allColumns.get(j).get(i));
            }
        }

        try (FileOutputStream fos = new FileOutputStream(file)) {
            workbook.write(fos);
        }

        workbook.close();
    }
}
