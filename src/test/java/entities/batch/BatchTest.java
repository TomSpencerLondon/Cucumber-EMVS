package entities.batch;

import entities.pack.Pack;
import entities.pack.PackState;
import entities.product.ProductCode;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;

class BatchTest {

    @Test
    void return_requested_pack_from_batch_based_on_serial_number() {
        String serialNumber = "8734789247214834671256";
        Pack pack = new Pack(serialNumber, PackState.ACTIVE);
        Batch batch = new Batch(
                BatchState.ACTIVE,
                "123456",
                new ProductCode("1234", "GS1P"),
                Collections.singletonList(pack),
                LocalDate.now()
        );

        assertEquals(pack, batch.getPackBySerial(serialNumber));
    }
}