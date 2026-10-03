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
}
