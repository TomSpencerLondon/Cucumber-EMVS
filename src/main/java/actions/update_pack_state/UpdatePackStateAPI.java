package actions.update_pack_state;

import domain.UpdatePackStateService;
import entities.pack.PackState;

public class UpdatePackStateAPI {
    private UpdatePackStateService service;

    public UpdatePackStateAPI(UpdatePackStateService service) {
        this.service = service;
    }

    public UpdateStatePackResponseObject update(UpdatePackStateRequestObject requestObject) {
        PackState update = service.update(requestObject);
        return new UpdateStatePackResponseObject(update.value);
    }
}
