package actions.update_pack_state;

import entities.pack.PackState;
import entities.product.ProductCode;

import java.time.LocalDate;

public class UpdatePackStateRequestObject {

    public final ProductCode productCode;
    public final String batchID;
    public final LocalDate expiryDate;
    public final String packSerialNumber;
    public final PackState desiredState;

    public UpdatePackStateRequestObject(ProductCode productCode, String batchID, LocalDate expiryDate, String packSerialNumber, PackState desiredState) {
        this.productCode = productCode;
        this.batchID = batchID;
        this.expiryDate = expiryDate;
        this.packSerialNumber = packSerialNumber;
        this.desiredState = desiredState;
    }
}
