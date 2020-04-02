package domain;

import entities.product.Product;
import entities.product.ProductCode;
import entities.product.ProductRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
class ProductServiceTest {
    @Mock private ProductRepository productRepository;
    @Mock private Product product;

    @Test
    void retrieve_product_by_product_code() {
        ProductService productService = new ProductService(productRepository);
        ProductCode productCode = new ProductCode("12345678901231", "GTIN");
        given(productRepository.findByProductCode(productCode)).willReturn(product);

        Product actualProduct = productService.retrieve(productCode);
        assertEquals(product, actualProduct);
    }
}