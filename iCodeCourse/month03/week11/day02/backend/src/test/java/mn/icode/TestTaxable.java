package mn.icode;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TestTaxable {

    @Test
    void testDiscountAmount() {
        PremiumProduct product =
                new PremiumProduct("Laptop", 10000.0);

        assertEquals(1500.0, product.discountAmount(10000.0));
    }

    @Test
    void testTaxAmount() {
        PremiumProduct product =
                new PremiumProduct("Laptop", 10000.0);

        assertEquals(1000.0, product.taxAmount(10000.0));
    }

    @Test
    void testFinalPrice() {
        PremiumProduct product =
                new PremiumProduct("Laptop", 10000.0);

        // 10000 - 15% = 8500
        // 8500 + 10% tax = 9350
        assertEquals(9350.0, product.finalPrice());
    }
}