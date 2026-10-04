package lab12;

import java.util.ArrayList;
import java.util.List;

/** Shopping cart for EduShop. */
public class Cart {
    private final List<CartItem> items = new ArrayList<>();
    private double discountPercent = 0;

    /** @throws IllegalArgumentException if quantity < 1 or unitPrice < 0 (cart unchanged). */
    public void addItem(String sku, double unitPrice, int quantity) {
        if (quantity < 1) throw new IllegalArgumentException("quantity must be >= 1");
        if (unitPrice < 0) throw new IllegalArgumentException("unit price must be >= 0");
        items.add(new CartItem(sku, unitPrice, quantity));
    }

    public List<CartItem> items() {
        return List.copyOf(items);
    }

    /** Sum of unit price × quantity, rounded to 2 decimal places. Empty cart is 0.00. */
    public double total() {
        double sum = 0;
        for (CartItem item : items) {
            sum += item.unitPrice() * item.quantity();
        }
        double discounted = sum * (1 - discountPercent / 100.0);
        return Math.round(discounted * 100) / 100.0;
    }

    /** Applies a discount between 0 and 100 percent (inclusive). Invalid values leave the previous discount. */
    public void applyDiscountPercent(double percent) {
        if (percent < 0 || percent > 100) {
            throw new IllegalArgumentException("percent must be in [0, 100]");
        }
        this.discountPercent = percent;
    }
}
