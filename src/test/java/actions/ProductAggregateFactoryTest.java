package actions;

import static org.junit.jupiter.api.Assertions.*;

import entities.ProductAggregate;
import java.time.LocalDate;
import org.junit.jupiter.api.Test;

class ProductAggregateFactoryTest {

  @Test
  public void create_ProductAggregate_from_VerificationRequestObject() {
    ProductAggregateFactory factory = new ProductAggregateFactory();
    VerificationRequestObject request = new VerificationRequestObject("12345678901231", "GTIN", "123",
        LocalDate.of(2020, 1, 1), "456","Ibuprofen");
    ProductAggregate productAggregate = factory.create(request);

    assertEquals(request.productCode, productAggregate.getProduct().getProductCode());
    assertEquals(request.productScheme, productAggregate.getProduct().getProductScheme());
    assertEquals(request.batchId, productAggregate.getBatch().getId());
    assertEquals(request.expiryDate, productAggregate.getBatch().getExpiryDate());
    assertEquals(request.packSerialNumber, productAggregate.getBatch().getPackBySerialNumber("456"));
  }

}