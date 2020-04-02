package acceptance;

import actions.VerificationAPI;
import actions.VerificationRequestObject;
import domain.PackService;
import domain.ProductService;
import domain.VerificationService;
import entities.product.InMemoryProductRepository;
import entities.product.ProductCode;
import entities.product.ProductRepository;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import java.time.LocalDate;

import static org.junit.Assert.assertEquals;

public class StepDefinitions {

  @Given("{string} Product exists {string} {string} {string}")
  public void product_exists(String productState, String productScheme, String productCode, String productName) {
    ScenarioContext.createProduct(productState, productScheme, productCode, productName);
  }

  @And("{string} Batch exists {string} for product {string} {string} with {string} Pack {string}")
  public void batchExistsForProductWithPack(String batchState, String batchID, String productScheme, String productCode, String packState,
      String packSerialNumber) {
    ScenarioContext.createBatch(batchState, batchID, productScheme, productCode, packSerialNumber, packState);
  }

  @When("Dispenser asks for verification")
  public void dispenserAsksForVerification() {
    VerificationAPI verificationAPI = new VerificationAPI(new VerificationService(new ProductService(ScenarioContext.productRepository), new PackService()));
    ProductCode productCode = new ProductCode("12345678901231", "GTIN");
    VerificationRequestObject verificationRequestObject = new VerificationRequestObject(productCode, "123",
        LocalDate.of(2020, 1, 1), "456", "Ibuprofen");
    ScenarioContext.captureResponse(verificationAPI.verify(verificationRequestObject));
  }

  @Then("NBS responds with Pack state {string}")
  public void nbsRespondsWithPackState(String packState) {
    assertEquals(packState, ScenarioContext.verificationResponseObject.state);
  }
}
