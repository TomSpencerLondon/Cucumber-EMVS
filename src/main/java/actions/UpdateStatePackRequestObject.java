package actions;

import entities.pack.PackState;
import entities.product.ProductCode;

import java.time.LocalDate;

public class UpdateStatePackRequestObject {

    public final ProductCode productCode;
    public final String batchID;
    public final LocalDate expiryDate;
    public final String packSerialNumber;
    public final PackState desiredState;

    public UpdateStatePackRequestObject(ProductCode productCode, String batchID, LocalDate expiryDate, String packSerialNumber, PackState desiredState) {
        this.productCode = productCode;
        this.batchID = batchID;
        this.expiryDate = expiryDate;
        this.packSerialNumber = packSerialNumber;
        this.desiredState = desiredState;
    }
}
