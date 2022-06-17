package io.liberty.event;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class IsCreationDateBeforeToday {
    static String isCreationDateBeforeToday(Date creationDate) {
        return null;
    }
}

public class StepDefenitions {
    private Date today = new Date();
    private Date creationDate;
    private String actualAnswer;

    @Given("creation date is 12:00 am, May 1 2022")
    public void creation_date_is_May() {
        SimpleDateFormat formatter = new SimpleDateFormat("hh:mm a, MMMM d yyyy");
        try {
            creationDate = formatter.parse("12:00 am, May 1 2022");
        } catch (Exception e){

        }
    }

    @When("creation date is before today")
    public void creation_date_is_before_today() {
        actualAnswer = IsCreationDateBeforeToday.isCreationDateBeforeToday(creationDate);
    }

    @Then("I should be told {string}")
    public void i_should_be_told(String expetedAnswer) {
        assertEquals(expetedAnswer, actualAnswer);
    }
}
