package acceptance;

import acceptance.updatePackState.UpdateStatePackRequestObjectTransformer;
import actions.UpdateStatePackRequestObject;
import actions.VerificationRequestObject;
import entities.batch.Batch;
import entities.product.Product;
import io.cucumber.core.api.TypeRegistry;
import io.cucumber.core.api.TypeRegistryConfigurer;
import io.cucumber.datatable.DataTableType;

import java.util.Locale;

public class TransformerRegistry implements TypeRegistryConfigurer {
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
        typeRegistry.defineDataTableType(
                new DataTableType(UpdateStatePackRequestObject.class, new UpdateStatePackRequestObjectTransformer())
        );
    }
}
