package org.howard.edu.lsp.midterm.strategy;

/**
 * Discount strategy for member customers.
 * A 10% discount is applied.
 *
 * @author Ibrahim Osman
 */
public class MemberDiscountStrategy implements DiscountStrategy {

    /**
     * Applies a 10% discount to the purchase price.
     *
     * @param price the original purchase price
     * @return the final price after the discount
     */
    @Override
    public double applyDiscount(double price) {
        return price * 0.90;
    }
}