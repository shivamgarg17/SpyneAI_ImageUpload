package org.spyneai.auto.spyneai_assignment;

import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.spyneai.auto.spyneai_assignment.utility.Utils;
import org.testng.annotations.*;

import static org.testng.Assert.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.awt.*;
import java.io.File;
import java.time.Duration;


@Story("SpyneAI Upscale")
public class MainPageTest {
    private WebDriver driver;
    private MainPage mainPage;
    private Utils utils;
    String downloadDirectory = System.getProperty("user.dir") + "/src/test/resources/download";


    @BeforeSuite
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        // Fix the issue https://github.com/SeleniumHQ/selenium/issues/11750
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("download.default_directory=" + downloadDirectory);
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        mainPage = new MainPage(driver);
        utils = new Utils();
        driver.navigate().to("https://www.spyne.ai/image-upscaler");
    }

    @AfterSuite
    public void tearDown() {
        driver.quit();
    }

    @Feature("Validating Website Elements")
    @Test(description = "Navigation to the Website and validate element is visible", priority = 1)
    public void navigateToWebsite() {
        assertEquals(driver.getCurrentUrl(), "https://www.spyne.ai/image-upscaler");
        assertTrue(driver.findElement(By.cssSelector("img[alt='spyne logo']")).isDisplayed());
        assertEquals(driver.getTitle(), "AI Image Upscaler: Upscale Your Image Quality with AI For Free");
    }

    @Test(description = "File Upload:", priority = 2)
    public void uploadFile() throws AWTException {
        WebDriverWait wt = new WebDriverWait(driver, Duration.ofSeconds(120));
        wt.until(ExpectedConditions.elementToBeClickable(mainPage.uploadImageHome)).click();
        utils.selectFile(System.getProperty("user.dir")+"/SpyneAI_Assignment/src/test/resources/files/images.jpeg");
    }

    //    @Test(description = "Invalid File Upload",priority = 3)
//    public void checkInvalidFileUpload() {
//
//        assertEquals(driver.getTitle(), "All Developer Tools and Products by JetBrains");
//    }
    @Test(description = "Image Upscaling", priority = 4)
    public void imageUpscaling() throws InterruptedException {
        driver.navigate().to("https://www.spyne.ai/image-enhancer/upload");
        driver.manage().window().fullscreen();
        mainPage.imageSelector.isDisplayed();
        mainPage.imageSelector.click();

        WebDriverWait wt = new WebDriverWait(driver, Duration.ofSeconds(120));
        wt.until(ExpectedConditions.elementToBeClickable(mainPage.processButton)).click();

    }

    @Test(description = "UI Validation", priority = 5)
    public void uiValidation() {
        WebDriverWait wt = new WebDriverWait(driver, Duration.ofSeconds(120));
        wt.until(ExpectedConditions.elementToBeClickable(mainPage.downloadButton)).isEnabled();
        assertTrue(mainPage.downloadButton.isDisplayed());
        assertTrue(mainPage.processButton.isDisplayed());
        assertTrue(mainPage.uploadButton.isDisplayed());

    }

    @Test(description = "Download Functionality", priority = 6)
    public void downloadFunctionality() {
        mainPage.downloadButton.click();
        File file = new File(downloadDirectory + File.separator + "output_image.jpeg");
        assertTrue(file.exists());
    }
//    @Test(description = "Performance Testing",priority =7)
//    public void performanceTesting(){
//
//    }
}
