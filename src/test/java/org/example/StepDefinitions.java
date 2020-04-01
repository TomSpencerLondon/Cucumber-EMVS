package org.example;

import entities.Product;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinitions {
  @Given("Product exists {string} {string} {string}")
  public void product_exists(String productScheme, String productCode, String productName) {
    ScenarioContext.createProduct(productScheme, productCode, productName);
  }

  @Given("Batch exists {string} for product {string} {string}")
  public void batchExistsForProduct(String batchID, String productScheme, String productCode) {
    ScenarioContext.createBatch(batchID, productScheme, productCode);
  }

  @Given("Pack {string} exists for Batch {string}")
  public void packExistsForBatch(String serialNumber, String batchID) {
  }

  @When("Dispenser asks for verification")
  public void dispenserAsksForVerification() {
  }

  @Then("NBS responds with Pack state")
  public void nbsRespondsWithPackState() {
  }
}
