package actions;

import domain.VerificationService;
import entities.PackState;
import entities.ProductAggregate;

public class VerificationAPI {

    private VerificationService service;
    private ProductAggregateFactory factory;

    public VerificationAPI(VerificationService service, ProductAggregateFactory factory) {
        this.service = service;
        this.factory = factory;
    }

    public VerificationResponseObject verify(VerificationRequestObject verificationRequestObject) {
        ProductAggregate productAggregate = factory.create(verificationRequestObject);
        PackState packState = service.verify(productAggregate);
        return new VerificationResponseObject(packState.state);
    }

}
