package actions.update_pack_state;

import domain.UpdatePackStateService;
import entities.pack.PackState;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.Assert.assertEquals;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
class UpdatePackStateAPITest {

    @Mock
    private UpdatePackStateService service;

    @Mock
    private UpdatePackStateRequestObject requestObject;

    @Test
    void change_pack_state_should_update_state_of_pack_and_return_updated() {
        PackState updatedState = PackState.SUPPLIED;

        UpdatePackStateAPI updatePackStateAPI = new UpdatePackStateAPI(service);

        given(service.update(requestObject)).willReturn(updatedState);

        UpdateStatePackResponseObject update = updatePackStateAPI.update(requestObject);

        assertEquals(updatedState.value, update.state);
    }
}