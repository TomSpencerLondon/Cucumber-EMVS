package domain;

import actions.update_pack_state.UpdatePackStateRequestObject;
import entities.batch.Batch;
import entities.pack.Pack;
import entities.pack.PackState;
import entities.product.Product;

public class UpdatePackStateService {
    private ProductService productService;
    private PackService packService;
    private PackStateTransitionValidator transitionService;

    public UpdatePackStateService(ProductService productService, PackService packService, PackStateTransitionValidator transitionService) {
        this.productService = productService;
        this.packService = packService;
        this.transitionService = transitionService;
    }

    public PackState update(UpdatePackStateRequestObject requestObject) {
//        TODO refactor with VerificationService -> duplication
        Product product = productService.retrieve(requestObject.productCode);
        Batch batch = packService.retrieve(requestObject.batchID, product.getProductCode());
        Pack pack = batch.getPackBySerial(requestObject.packSerialNumber);

        if (transitionService.isTransitionAllowed(pack, requestObject.desiredState)){
            pack.changeState(requestObject.desiredState);
        }
        return pack.getState();
    }
}
