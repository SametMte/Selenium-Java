package com.cydeo.tests.day06_alert_iframs_windows;

import com.cydeo.utility.WebDriverFactory;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class getDataOtomation {
    WebDriver driver;
    @BeforeMethod
    public void setupMethod(){
        //1. Open Chrome browser
        driver= WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));


        //2. Go to https://practice.cydeo.com/dropdown
        //driver.get("https://www.weather.gov/wrh/Climate?wfo=gsp");
        driver.get("https://www.weather.gov/wrh/Climate?wfo=cae");

    }
    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

    @Test
    public void test1() throws InterruptedException, IOException {
        Thread.sleep(2000);
        //find and switch to the iframe
        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@name='routine']")));

        //click and select location
        Select locationName=new Select(driver.findElement(By.xpath("//select[@name='station']")));
        locationName.selectByVisibleText("Columbia Metro AP, SC");
        /*
        * BÖLGENİN LOCASYON İSMİ GİRİLİR. NOT SİTEDEKİ LOCASYON EKRANI İLE AYNI OLMALIDIR.
        * */
        Thread.sleep(2000);

        //click and select product
        WebElement productType = driver.findElement(By.xpath("//div[@class='input_block'][2]//label[.='Daily data for a month']"));
        productType.click();
        Thread.sleep(2000);

        //click and select option(date)
        WebElement dateChanger = driver.findElement(By.xpath("//img[@class='ui-datepicker-trigger']"));
        dateChanger.click();

        //select month
        Select monthSelecter=new Select(driver.findElement(By.xpath("//select[@class='ui-datepicker-month']")));
        monthSelecter.selectByIndex(0);
        // TARİHTEKİ AYI DEĞİŞİR 0-11 ARASI DEĞER GİRİLİR 0-> 1. AYA, 11-> 12. AYA DENK GELİR
        // ÖRNEK monthSelecter.selectByIndex(0); OCAK AYI DATASI
        // ÖRNEK monthSelecter.selectByIndex(1); ŞUBAT AYI DATASI

        //select year
        Select yearSelecter=new Select(driver.findElement(By.xpath("//select[@class='ui-datepicker-year']")));
        yearSelecter.selectByVisibleText("2000");
        // TARİHTEKİ YILI DEĞİŞİR HANGİ YILA BAKILACAKSA O YIL GİRİLİR
        // ÖRNEK yearSelecter.selectByVisibleText("2000"); 2000 YILININ DATASI
        // ÖRNEK yearSelecter.selectByVisibleText("2001"); 2001 YILININ DATASI

        //click done
        WebElement doneButton = driver.findElement(By.xpath("//button[.='Done']"));
        doneButton.click();

        //click View for the see table
        WebElement viewButton = driver.findElement(By.xpath("//button[@id='go']"));
        viewButton.click();

        //-----------------------------------------Get Value ----------------------------------------------
        //get first row value
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
       /* for (int i = 0; i < elements0.size(); i++) {
            System.out.println(elements0.get(i).getText()+" | "+elements1.get(i).getText()+" | "+elements2.get(i).getText()+" | "+elements3.get(i).getText()+" | "+elements4.get(i).getText()+" | "+elements5.get(i).getText()+" | "+elements6.get(i).getText()+" | "+elements7.get(i).getText()+" | "+elements8.get(i).getText()+" | "+elements9.get(i).getText()+" | ");
        }*/
        List<String> col0=new ArrayList<>(Arrays.asList());
        List<String> col1=new ArrayList<>(Arrays.asList());
        List<String> col2=new ArrayList<>(Arrays.asList());
        List<String> col3=new ArrayList<>(Arrays.asList());
        List<String> col4=new ArrayList<>(Arrays.asList());
        List<String> col5=new ArrayList<>(Arrays.asList());
        List<String> col6=new ArrayList<>(Arrays.asList());
        List<String> col7=new ArrayList<>(Arrays.asList());
        List<String> col8=new ArrayList<>(Arrays.asList());
        List<String> col9=new ArrayList<>(Arrays.asList());


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

        for (int i = 0; i < col0.size(); i++) {
            System.out.println(col0.get(i)+" | "+col1.get(i)+" | "+
                               col2.get(i)+" | "+col3.get(i)+" | "+
                               col4.get(i)+" | "+col5.get(i)+" | "+
                               col6.get(i)+" | "+col7.get(i)+" | "+
                               col8.get(i)+" | "+col9.get(i)+" | ");


        }
        List<List<String>> data = Arrays.asList(col0, col1, col2, col3, col4, col5, col6, col7, col8, col9);
        exportToExcel(data,"Colombia-metro-AP.xlsx","Colombia-metro-AP");

    }



        public static void exportToExcel(List<List<String>> allColumns,String fileName,String sheetName) throws IOException {
            Workbook workbook;
            Sheet sheet;

            File file = new File(fileName);
            boolean fileExists = file.exists();

            // 1. Excel dosyasını oku (eğer varsa)
            if (fileExists) {
                // Okuma akışı ile workbook'u yükle
                try (FileInputStream fis = new FileInputStream(file)) {
                    workbook = new XSSFWorkbook(fis);
                }
            } else {
                workbook = new XSSFWorkbook();
            }

            // 2. Sheet varsa al, yoksa oluştur
            sheet = workbook.getSheet(sheetName);
            boolean isNewSheet = false;

            if (sheet == null) {
                sheet = workbook.createSheet(sheetName);
                isNewSheet = true;

            // Başlık satırı
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

            // 3. Verilerin ekleneceği satırın başlangıcı
            int startRow = sheet.getLastRowNum() + 1;
            if (isNewSheet && startRow < 2) {
                startRow = 2;
            }

            // 4. Veriyi yaz
            int rowCount = allColumns.get(0).size();
            for (int i = 0; i < rowCount; i++) {
                Row row = sheet.createRow(startRow + i);
                for (int j = 0; j < allColumns.size(); j++) {
                    row.createCell(j).setCellValue(allColumns.get(j).get(i));
                }
            }

            // 5. Dosyaya tekrar yazarak KAYDET
            try (FileOutputStream fos = new FileOutputStream(file)) {
                workbook.write(fos);
            }

            workbook.close();
}
        }


