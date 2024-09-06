package org.spyneai.auto.spyneai_assignment;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

// page_url = https://www.jetbrains.com/
public class MainPage {
    @FindBy(xpath = "//button[normalize-space()='Upload an image']")
    public WebElement uploadImageHome;

    @FindBy(css = "label[class='w-full h-full flex gap-1 items-center cursor-pointer']")
    public WebElement uploadButton;

    @FindBy(css = "body div div div div div div div div div div:nth-child(2) img:nth-child(1)")
    public WebElement imageSelector;

    @FindBy(xpath = "//div[@class='w-11/12 flex gap-3']/button[contains(.,'Process')]")
    public WebElement processButton;
    @FindBy(xpath = "//div[@class='w-11/12 flex gap-3']/button[contains(.,' Download')]")
    public WebElement downloadButton;

    public MainPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}
