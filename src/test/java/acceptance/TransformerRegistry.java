package acceptance;

import actions.VerificationRequestObject;
import entities.batch.Batch;
import entities.pack.Pack;
import entities.product.Product;
import entities.product.ProductCode;
import entities.product.ProductState;
import io.cucumber.core.api.TypeRegistry;
import io.cucumber.core.api.TypeRegistryConfigurer;
import io.cucumber.datatable.DataTableType;

import java.util.Locale;
import java.util.Map;

public class TransformerRegistry implements TypeRegistryConfigurer{
    @Override
    public Locale locale() {
        return Locale.ENGLISH;
    }

    @Override
    public void configureTypeRegistry(TypeRegistry typeRegistry) {
        typeRegistry.defineDataTableType(
                new DataTableType(Product.class, new ProductTransformer())
        );
        typeRegistry.defineDataTableType(
                new DataTableType(Batch.class, new BatchTransformer())
        );
        typeRegistry.defineDataTableType(
                        new DataTableType(VerificationRequestObject.class, new VerificationRequestObjectTransformer())
        );
    }
}
