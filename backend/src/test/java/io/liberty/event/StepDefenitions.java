package io.liberty.event;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.liberty.event.models.Event;

import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class IsCreationDateBeforeToday {

    static String isCreationDateBeforeToday(Event event) {
        Date today = new Date();
        Date creationDate = null;
        SimpleDateFormat formatter = new SimpleDateFormat("hh:mm a, MMMM d yyyy");
        try {
            creationDate = formatter.parse(event.getTime());
        } catch (Exception e) {}

        return creationDate.before(today) ? "Choose a valid date" : "Have fun";

    }
}

public class StepDefenitions {
    private Event event = new Event();
    private String actualAnswer;

    @Given("creation date is 12:00 am, May 1 2022")
    public void creation_date_is_May() {
        try {
            event.setTime("12:00 am, May 1 2022");
        } catch (Exception e){

        }
    }

    @When("creation date is before today")
    public void creation_date_is_before_today() {
        actualAnswer = IsCreationDateBeforeToday.isCreationDateBeforeToday(event);
    }

    @Then("I should be told {string}")
    public void i_should_be_told(String expectedAnswer) {
        assertEquals(expectedAnswer, actualAnswer);
    }
}
