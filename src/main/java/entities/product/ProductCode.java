package entities.product;

public class ProductCode {
    public final String code;
    public final String schema;

    public ProductCode(String code, String schema) {
        if (code == null || schema == null) {
            throw new UnsupportedOperationException();
        }
        this.code = code;
        this.schema = schema;
    }

    public boolean isEquals(ProductCode productCode) {
        return code.equals(productCode.code) &&
                schema.equals(productCode.schema);
    }
}
