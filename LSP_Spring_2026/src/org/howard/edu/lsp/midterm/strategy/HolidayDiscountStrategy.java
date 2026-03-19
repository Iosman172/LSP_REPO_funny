package org.howard.edu.lsp.midterm.strategy;

/**
 * Discount strategy for holiday pricing.
 * A 15% discount is applied.
 *
 * @author Ibrahim Osman
 */
public class HolidayDiscountStrategy implements DiscountStrategy {

    /**
     * Applies a 15% discount to the purchase price.
     *
     * @param price the original purchase price
     * @return the final price after the discount
     */
    @Override
    public double applyDiscount(double price) {
        return price * 0.85;
    }
}