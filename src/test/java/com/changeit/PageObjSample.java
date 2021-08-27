package com.changeit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

class PageObjSample {

    @FindBy(how = How.NAME, using = "q")
    WebElement searchBar;
    @FindBy(how = How.ID, using = "downloadLink")
    private WebElement appiumDownloadButton;

    PageObjSample(RemoteWebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    void search(String text) {
        searchBar.sendKeys(text);
    }

    void download() {
        appiumDownloadButton.click();
    }
}