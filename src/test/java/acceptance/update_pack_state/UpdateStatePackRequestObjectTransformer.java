package acceptance.update_pack_state;

import actions.update_pack_state.UpdatePackStateRequestObject;
import entities.pack.PackState;
import entities.product.ProductCode;
import io.cucumber.datatable.DataTable;
import io.cucumber.datatable.TableTransformer;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.stream.Collectors;

public class UpdateStatePackRequestObjectTransformer implements TableTransformer {

    @Override
    public UpdatePackStateRequestObject transform(DataTable dataTable) throws Throwable {
        return dataTable.cells()
                .stream()
                .skip(1)
                .map(fields -> new UpdatePackStateRequestObject(
                                new ProductCode(fields.get(0), fields.get(1)),
                                fields.get(2),
                                LocalDate.parse(fields.get(3), DateTimeFormatter.ofPattern("d/MM/yyyy")),
                                fields.get(4),
                                PackState.fromString(fields.get(5))
                        )
                ).collect(Collectors.toList()).get(0);
    }
}
