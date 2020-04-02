package org.example;

import actions.VerificationAPI;
import actions.VerificationRequestObject;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import static org.junit.Assert.assertEquals;

public class StepDefinitions {
  @Given("Product exists {string} {string} {string}")
  public void product_exists(String productScheme, String productCode, String productName) {
    ScenarioContext.createProduct(productScheme, productCode, productName);
  }

  @And("Batch exists {string} for product {string} {string} with {string} Pack {string}")
  public void batchExistsForProductWithPack(String batchID, String productScheme, String productCode, String packState, String packSerialNumber) {
    ScenarioContext.createBatch(batchID, productScheme, productCode, packSerialNumber, packState);
  }

  @When("Dispenser asks for verification")
  public void dispenserAsksForVerification() {
    VerificationAPI verificationAPI = new VerificationAPI();
    VerificationRequestObject verificationRequestObject = new VerificationRequestObject();
    ScenarioContext.captureResponse(verificationAPI.verify(verificationRequestObject));
  }

  @Then("NBS responds with Pack state {string}")
  public void nbsRespondsWithPackState(String packState) {
    assertEquals(packState, ScenarioContext.verificationResponseObject.state);
  }
}
