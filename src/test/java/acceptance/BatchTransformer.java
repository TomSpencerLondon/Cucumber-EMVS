package acceptance;

import entities.batch.Batch;
import entities.batch.BatchState;
import entities.pack.Pack;
import entities.pack.PackState;
import entities.product.ProductCode;
import io.cucumber.datatable.DataTable;
import io.cucumber.datatable.TableTransformer;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Collections;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class BatchTransformer implements TableTransformer {
    @Override
    public Batch transform(DataTable dataTable) throws Throwable {
        Stream<Batch> batchStream = dataTable.cells()
                .stream()
                .skip(1)
                .map(fields -> new Batch(
                        BatchState.fromString(fields.get(2)),
                        fields.get(3),
                        new ProductCode(fields.get(0), fields.get(1)),
                        Collections.singletonList(new Pack(fields.get(4), PackState.fromString(fields.get(5)))),
                        LocalDate.parse(fields.get(6), DateTimeFormatter.ofPattern("d/MM/yyyy"))
                ));
        return batchStream.collect(Collectors.toList()).get(0);
    }
}
