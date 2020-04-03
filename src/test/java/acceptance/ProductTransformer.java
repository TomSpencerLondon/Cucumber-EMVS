package acceptance;

import entities.product.Product;
import entities.product.ProductCode;
import entities.product.ProductState;
import io.cucumber.datatable.DataTable;
import io.cucumber.datatable.TableEntryTransformer;
import io.cucumber.datatable.TableTransformer;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ProductTransformer implements TableEntryTransformer<Product> {
    @Override
    public Product transform(Map<String, String> map) throws Throwable {
        ProductCode productCode = new ProductCode(map.get("productCode"), map.get("productSchema"));
        String productName = map.get("productName");
        ProductState state = ProductState.fromString(map.get("productState"));
        return new Product(state, productCode, productName);
    }
}
