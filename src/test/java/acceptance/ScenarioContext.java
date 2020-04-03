package acceptance;

import actions.VerificationResponseObject;
import entities.batch.BatchPackRepository;
import entities.batch.InMemoryBatchPackRepository;
import entities.pack.Pack;
import entities.product.*;

import java.util.ArrayList;
import java.util.HashMap;

public class ScenarioContext {

  public static VerificationResponseObject verificationResponseObject;
  public static BatchPackRepository batchPackRepository = new InMemoryBatchPackRepository();
  public static HashMap<Object, ArrayList<Pack>> packs = new HashMap<>();
  protected static ProductRepository productRepository = new InMemoryProductRepository();

  public static void captureResponse(VerificationResponseObject response) {
    verificationResponseObject = response;
  }
}
