package org.howard.edu.lsp.midterm.strategy;

/**
 * Discount strategy for regular customers.
 * No discount is applied.
 *
 * @author Ibrahim Osman
 */
public class RegularDiscountStrategy implements DiscountStrategy {

    /**
     * Returns the original price with no discount.
     *
     * @param price the original purchase price
     * @return the original purchase price
     */
    @Override
    public double applyDiscount(double price) {
        return price;
    }
}