package acceptance;

import actions.VerificationAPI;
import actions.VerificationRequestObject;
import domain.PackService;
import domain.ProductService;
import domain.VerificationService;
import entities.batch.Batch;
import entities.product.Product;
import entities.product.ProductCode;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.time.LocalDate;

import static org.junit.Assert.assertEquals;

public class StepDefinitions {

    @Given("Product exists in system")
    public void productExistsInSystem(Product product) {
        ScenarioContext.productRepository.save(product);
    }

    @And("Batch exists with active pack in system")
    public void batchExistsWithActivePackInSystem(Batch batch) {
        ScenarioContext.batchPackRepository.save(batch);
    }

    @And("{string} Batch exists {string} for product {string} {string} with {string} Pack {string}")
    public void batchExistsForProductWithPack(String batchState, String batchID, String productScheme, String productCode, String packState,
                                              String packSerialNumber) {
        ScenarioContext.createBatch(batchState, batchID, productScheme, productCode, packSerialNumber, packState);
    }

    @When("Dispenser asks for verification")
    public void dispenserAsksForVerification(VerificationRequestObject verificationRequestObject) {
        VerificationAPI verificationAPI = new VerificationAPI(new VerificationService(new ProductService(ScenarioContext.productRepository), new PackService(ScenarioContext.batchPackRepository)));
        ScenarioContext.captureResponse(verificationAPI.verify(verificationRequestObject));
    }

    @Then("NBS responds with Pack state {string}")
    public void nbsRespondsWithPackState(String packState) {
        assertEquals(packState, ScenarioContext.verificationResponseObject.state);
    }

}
