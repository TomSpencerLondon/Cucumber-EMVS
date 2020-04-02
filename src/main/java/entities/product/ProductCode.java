package entities.product;

public class ProductCode {
    public final String code;
    public final String scheme;

    public ProductCode(String code, String scheme) {
        this.code = code;
        this.scheme = scheme;
    }

    public boolean isEquals(ProductCode productCode) {
        return code.equals(productCode.code) &&
                scheme.equals(productCode.scheme);
    }
}
