package actions;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.given;

import domain.VerificationService;
import entities.pack.PackState;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class VerificationAPITest {

  @Mock
  private VerificationService service;

  @Mock
  private VerificationRequestObject requestObject;

  @Test
  public void returns_pack_state() {
    PackState actualState = PackState.ACTIVE;

    given(service.verify(requestObject)).willReturn(actualState);

    VerificationAPI verificationAPI = new VerificationAPI(service);
    VerificationResponseObject response = verificationAPI.verify(
        requestObject);

    assertEquals(actualState.value, response.state);
  }


}