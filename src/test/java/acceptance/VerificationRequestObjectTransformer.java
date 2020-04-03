package acceptance;

import actions.VerificationRequestObject;
import entities.product.Product;
import entities.product.ProductCode;
import entities.product.ProductState;
import io.cucumber.datatable.DataTable;
import io.cucumber.datatable.TableEntryTransformer;
import io.cucumber.datatable.TableTransformer;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class VerificationRequestObjectTransformer implements TableEntryTransformer<VerificationRequestObject> {
  @Override
  public VerificationRequestObject transform(Map<String, String> map) throws Throwable {
    ProductCode productCode = new ProductCode(map.get("productCode"), map.get("productSchema"));
    return new VerificationRequestObject(
            productCode, map.get("batchID"),
            LocalDate.parse(map.get("expiryDate"), DateTimeFormatter.ofPattern("d/MM/yyyy")),
            map.get("packSerialNumber")
    );
  }
}
