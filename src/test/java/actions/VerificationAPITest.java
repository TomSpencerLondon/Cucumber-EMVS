package actions;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.given;

import domain.VerificationService;
import entities.PackState;
import entities.ProductAggregate;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class VerificationAPITest {

  @Mock
  private VerificationService service;

  @Mock
  private ProductAggregateFactory factory;

  @Mock
  private VerificationRequestObject requestObject;

  @Mock
  private ProductAggregate productAggregate;

  @Test
  public void returns_pack_state() {
    PackState actualState = PackState.ACTIVE;

    given(factory.create(requestObject)).willReturn(productAggregate);
    given(service.verify(productAggregate)).willReturn(actualState);

    VerificationAPI verificationAPI = new VerificationAPI(service, factory);
    VerificationResponseObject response = verificationAPI.verify(
        requestObject);

    assertEquals(actualState.state, response.state);
  }


}