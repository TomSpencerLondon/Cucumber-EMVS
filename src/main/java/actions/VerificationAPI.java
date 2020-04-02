package actions;

import domain.VerificationService;

public class VerificationAPI {

    private VerificationService service;
    private ProductAggregateFactory factory;

    public VerificationAPI(VerificationService service, ProductAggregateFactory factory) {
        this.service = service;
        this.factory = factory;
    }

    public VerificationResponseObject verify(VerificationRequestObject verificationRequestObject) {
        ProductAggregate productAggregate = factory.create(verificationRequestObject);
        String packState = service.verify(productAggregate);
        return new VerificationResponseObject(packState);
    }
}
