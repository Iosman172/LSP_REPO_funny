package org.howard.edu.lsp.midterm.strategy;

/**
 * Strategy interface for applying a discount to a purchase price.
 *
 * @author Ibrahim Osman
 */
public interface DiscountStrategy {
    
    /**
     * Applies a discount strategy to the given price.
     *
     * @param price the original purchase price
     * @return the final price after the discount is applied
     */
    double applyDiscount(double price);
}