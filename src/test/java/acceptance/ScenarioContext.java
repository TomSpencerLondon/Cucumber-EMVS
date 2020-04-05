package acceptance;

import actions.update_pack_state.UpdateStatePackResponseObject;
import actions.VerificationResponseObject;
import entities.batch.BatchPackRepository;
import entities.batch.InMemoryBatchPackRepository;
import entities.pack.Pack;
import entities.product.*;
import org.javatuples.Triplet;

import java.util.ArrayList;
import java.util.HashMap;

public class ScenarioContext {

  public static VerificationResponseObject verificationResponseObject;
  public static BatchPackRepository batchPackRepository = new InMemoryBatchPackRepository();
  public static HashMap<Triplet, ArrayList<Pack>> packs = new HashMap<>();
  protected static ProductRepository productRepository = new InMemoryProductRepository();
  protected static UpdateStatePackResponseObject updatePackStateResponseObject;

  public static void captureResponse(VerificationResponseObject response) {
    verificationResponseObject = response;
  }

  public static void captureUpdatePackStateResponse(UpdateStatePackResponseObject response){
    updatePackStateResponseObject = response;
  }
}
