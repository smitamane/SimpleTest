package so.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import so.util.ConfigReader;

public class LandingPage {
    public static void LaunchApplication(WebDriver driver){
        driver.get(ConfigReader.getProperty("app.url"));
        WebDriverWait wait = new WebDriverWait(driver,20);
        wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.xpath("//select[@id='selDetails']/option"),0));

    }

    public static void selectFiletr(String filetr,WebDriver driver) {
        Select filterSelect = new Select(driver.findElement(By.id("selDetails")));
        filterSelect.selectByVisibleText(filetr);
        WebDriverWait wait = new WebDriverWait(driver,20);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("overlay")));
    }

    public static void selectDepartment(WebDriver driver,String... filter) {
        Select deptSelect = new Select(driver.findElement(By.id("fltdepartment")));
        deptSelect.deselectAll();
        for (String s : filter) {
            deptSelect.selectByVisibleText(s);
        }
    }

    public static void selectSalleryBand(WebDriver driver, String... filter) {
        Select deptSelect = new Select(driver.findElement(By.id("fltsallery_band")));
        deptSelect.deselectAll();
        for (String s : filter) {
            deptSelect.selectByVisibleText(s);
        }
    }

    public static void generateReport(WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver,20);
        driver.findElement(By.id("btnGen")).click();
        wait.until(ExpectedConditions.numberOfWindowsToBe(2));
    }
}
