package lab12;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CartTest {
    @Test
    void addItemStoresIt() {
        Cart cart = new Cart();
        cart.addItem("SKU-1", 5.0, 2);
        assertEquals(1, cart.items().size());
    }

    @Test
    void zeroQuantityRejectedAndCartUnchanged() {
        Cart cart = new Cart();
        assertThrows(IllegalArgumentException.class, () -> cart.addItem("SKU-1", 5.0, 0));
        assertTrue(cart.items().isEmpty());
    }

    @Test
    void negativePriceRejected() {
        assertThrows(IllegalArgumentException.class, () -> new Cart().addItem("SKU-1", -1.0, 1));
    }

    @Test
    void totalIsSumOfPriceTimesQuantity() {
        Cart cart = new Cart();
        cart.addItem("SKU-1", 5.0, 2);
        cart.addItem("SKU-2", 3.5, 1);
        assertEquals(13.5, cart.total(), 0.001);
    }

    @Test
    void emptyCartTotalIsZero() {
        assertEquals(0.0, new Cart().total(), 0.001);
    }

    @Test
    void totalRoundsToTwoDecimals() {
        Cart cart = new Cart();
        cart.addItem("SKU-3", 0.333, 1);
        assertEquals(0.33, cart.total(), 0.0001);
    }

    @Test
    void tenPercentDiscountReducesTotal() {
        Cart cart = new Cart();
        cart.addItem("SKU-1", 5.0, 2);
        cart.addItem("SKU-2", 3.5, 1);
        cart.applyDiscountPercent(10);
        assertEquals(12.15, cart.total(), 0.001);
    }

    @Test
    void invalidPercentRejectedAndPreviousDiscountKept() {
        Cart cart = new Cart();
        cart.addItem("SKU-1", 100.0, 1);
        cart.applyDiscountPercent(10);
        assertThrows(IllegalArgumentException.class, () -> cart.applyDiscountPercent(101));
        assertThrows(IllegalArgumentException.class, () -> cart.applyDiscountPercent(-1));
        assertEquals(90.0, cart.total(), 0.001);
    }
}
