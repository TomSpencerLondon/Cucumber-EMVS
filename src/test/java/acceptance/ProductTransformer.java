package acceptance;

import entities.product.Product;
import entities.product.ProductCode;
import entities.product.ProductState;
import io.cucumber.datatable.DataTable;
import io.cucumber.datatable.TableTransformer;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ProductTransformer implements TableTransformer {
    @Override
    public Product transform(DataTable dataTable) throws Throwable {

        Stream<Product> productStream = dataTable.cells()
                .stream()
                .skip(1)        // Skip header row
                .map(fields -> new Product(ProductState.fromString(fields.get(3)), new ProductCode(fields.get(0), fields.get(1)), fields.get(2)));
        return productStream.collect(Collectors.toList()).get(0);
    }
}
