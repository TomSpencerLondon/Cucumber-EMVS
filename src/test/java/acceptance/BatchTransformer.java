package acceptance;

import actions.VerificationRequestObject;
import entities.batch.Batch;
import entities.batch.BatchState;
import entities.pack.Pack;
import entities.pack.PackState;
import entities.product.ProductCode;
import io.cucumber.datatable.DataTable;
import io.cucumber.datatable.TableEntryTransformer;
import io.cucumber.datatable.TableTransformer;
import org.javatuples.Triplet;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class BatchTransformer implements TableEntryTransformer<Batch> {
    @Override
    public Batch transform(Map<String, String> map) throws Throwable {
        ProductCode productCode = new ProductCode(map.get("productCode"), map.get("productSchema"));
        Triplet<String, String, String> key = new Triplet<>(
                map.get("productCode"), map.get("productSchema"), map.get("batchID")
        );
        List<Pack> packs = ScenarioContext.packs.get(key);
        return new Batch(
                BatchState.fromString(map.get("batchState")),
                map.get("batchID"),
                productCode,
                packs,
                LocalDate.parse(map.get("expiryDate"), DateTimeFormatter.ofPattern("d/MM/yyyy"))
        );
    }
}

