package actions;

import domain.VerificationService;
import entities.pack.PackState;

public class VerificationAPI {

    private VerificationService service;

    public VerificationAPI(VerificationService service) {
        this.service = service;
    }

    public VerificationResponseObject verify(VerificationRequestObject verificationRequestObject) {
        PackState state = service.verify(verificationRequestObject);
        return new VerificationResponseObject(state.value);
    }

}
