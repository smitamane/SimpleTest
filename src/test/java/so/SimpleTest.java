package so;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import so.pages.LandingPage;

import java.util.Set;

public class SimpleTest extends BaseTest {

    @Test
    public void validateEmployeeReportForAdminSaleryBand(){
        LandingPage.LaunchApplication(driver);
        LandingPage.selectFiletr("department",driver);
        LandingPage.selectFiletr("sallery band",driver);
        LandingPage.selectDepartment(driver,"Administration");
        LandingPage.selectSalleryBand(driver,"");
        LandingPage.generateReport(driver);

        Set<String> windowHandles = driver.getWindowHandles();
        for (String windowHandle : windowHandles) {
            driver.switchTo().window(windowHandle);
        }
        driver.findElement(By.xpath("//table[@id='rpt']/thead/tr/th[6]")).click();
        int actualRows = driver.findElements(By.xpath("//table[@id='rpt']/tbody/tr/td[6][text()='1']")).size();
        int expectedRows = 5;
        Assert.assertEquals(actualRows,expectedRows,"record count does not match");
    }





}
