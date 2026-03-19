package org.howard.edu.lsp.midterm.strategy;

/**
 * Discount strategy for VIP customers.
 * A 20% discount is applied.
 *
 * @author Ibrahim Osman
 */
public class VipDiscountStrategy implements DiscountStrategy {

    /**
     * Applies a 20% discount to the purchase price.
     *
     * @param price the original purchase price
     * @return the final price after the discount
     */
    @Override
    public double applyDiscount(double price) {
        return price * 0.80;
    }
}