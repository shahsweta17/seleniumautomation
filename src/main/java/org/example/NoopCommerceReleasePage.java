package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

public class NoopCommerceReleasePage extends Utils {
    private  By _checkTitleOfThePage =By.className("page-title");
    private By _enterTitle =By.id("AddNewComment_CommentTitle");
    private By _enterComment =By.id("AddNewComment_CommentText");
    private By _clickOnCommentButton =By.name("add-comment");
    private By _verifyMessageAfterClickingCommentButton =By.className("result");
    private By _verifyCommentHasBeenAddedToTheCommentList =By.xpath("//div[@class='comment-title']");

    public void verifyURL(){
        //Verify that user is on the nopcommerce new release page (Assert Point - verify URL)
        String expectedURL = "https://demo.nopcommerce.com/nopcommerce-new-release";
        String actualURL = driver.getCurrentUrl();
        Assert.assertEquals(actualURL, expectedURL);
    }
    public void checkTitleOfThePage() {
        String expectedTitle = "nopCommerce new release!";
        String actualTitle = getTextFromElement(_checkTitleOfThePage);
        Assert.assertEquals(actualTitle, expectedTitle);

    }

    public void enterTitle() {
        typeText(_enterTitle, "Automation");
    }

    public void enterComment() {
        typeText(_enterComment, "Tester");
    }

    public void clickOnCommentButton() {
        clickOnElement(_clickOnCommentButton);
    }

    //Verify comment added message "News comment is successfully added." (Assert Point - verify Message)
    public void verifyMessageAfterClickingCommentButton() {
        String actualMessage = getTextFromElement(_verifyMessageAfterClickingCommentButton);
        String expectedMessage = "News comment is successfully added.";
        Assert.assertEquals(actualMessage, expectedMessage, "News comment is not successfully added.");
    }
    public void verifyCommentHasBeenAddedToTheCommentList(){
        //Verify that user's comment has been added to the comments list (Assert Point - Comment has been added to the list)
        String title = "Automation";
        List<WebElement> comments = driver.findElements(_verifyCommentHasBeenAddedToTheCommentList);
        List<String> listOfComments = new ArrayList<>();
        for (WebElement we:comments){
            listOfComments.add(we.getText());
        }
        Assert.assertTrue(listOfComments.contains(title));
        String lastComment = listOfComments.get(listOfComments.size()-1);
        System.out.println(lastComment);
        Assert.assertEquals(lastComment, title, "Comments are not listed in correct order");

    }
}