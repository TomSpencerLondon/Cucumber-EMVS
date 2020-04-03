package acceptance;

import actions.VerificationRequestObject;
import entities.product.Product;
import entities.product.ProductCode;
import entities.product.ProductState;
import io.cucumber.datatable.DataTable;
import io.cucumber.datatable.TableTransformer;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class VerificationRequestObjectTransformer implements TableTransformer {
  @Override
  public VerificationRequestObject transform(DataTable dataTable) throws Throwable {

    Stream<VerificationRequestObject> productStream = dataTable.cells()
            .stream()
            .skip(1)        // Skip header row
            .map(fields -> new VerificationRequestObject(new ProductCode(fields.get(0), fields.get(1)), fields.get(2),
                    LocalDate.parse(fields.get(3), DateTimeFormatter.ofPattern("d/MM/yyyy")),
                            fields.get(4), fields.get(5)));

    return productStream.collect(Collectors.toList()).get(0);
  }
}
