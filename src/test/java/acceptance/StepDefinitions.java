package acceptance;

import actions.update_pack_state.UpdatePackStateAPI;
import actions.update_pack_state.UpdateStatePackRequestObject;
import actions.VerificationAPI;
import actions.VerificationRequestObject;
import domain.PackService;
import domain.ProductService;
import domain.VerificationService;
import entities.batch.Batch;
import entities.pack.Pack;
import entities.pack.PackState;
import entities.product.Product;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.javatuples.Triplet;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class StepDefinitions {

    @Given("Product exists in system")
    public void productExistsInSystem(List<Product> products) {
        products.forEach(product -> ScenarioContext.productRepository.save(product));
    }

    @And("Packs exists in system")
    public void packsExistsInSystem(DataTable dataTable) {
        dataTable.asMaps().forEach(pack -> {
            Triplet<String, String, String> key = Triplet.with(
                    pack.get("productCode"), pack.get("productSchema"), pack.get("batchID")
            );

            ArrayList<Pack> packList = ScenarioContext.packs.getOrDefault(key, new ArrayList<>());
            packList.add(new Pack(
                    pack.get("serialNumber"),
                    PackState.fromString(pack.get("state"))
            ));

            ScenarioContext.packs.put(key, packList);
        });
    }

    @And("Batch exists with pack in system")
    public void batchExistsWithActivePackInSystem(List<Batch> batches) {
        batches.forEach(batch -> ScenarioContext.batchPackRepository.save(batch));
    }

    @When("Dispenser asks for verification")
    public void dispenserAsksForVerification(List<VerificationRequestObject> requestObjects) {
        VerificationAPI verificationAPI = new VerificationAPI(new VerificationService(new ProductService(ScenarioContext.productRepository), new PackService(ScenarioContext.batchPackRepository)));
        requestObjects.forEach(obj -> ScenarioContext.captureResponse(verificationAPI.verify(obj)));
    }

    @Then("NBS responds with Pack state {string}")
    public void nbsRespondsWithPackState(String packState) {
        assertEquals(packState, ScenarioContext.verificationResponseObject.state);
    }
<<<<<<< HEAD
=======

    @When("Dispenser changes current pack state")
    public void dispenserChangesCurrentPackState(UpdateStatePackRequestObject requestObject) {
        UpdatePackStateAPI updatePackStateAPI = new UpdatePackStateAPI();
        ScenarioContext.captureUpdatePackStateResponse(updatePackStateAPI.update(requestObject));
    }

    @Then("NBS responds with new Pack state {string}")
    public void nbsRespondsWithNewPackState(String packState) {
        assertEquals(packState, ScenarioContext.updatePackStateResponseObject.state);
    }
>>>>>>> master
}
