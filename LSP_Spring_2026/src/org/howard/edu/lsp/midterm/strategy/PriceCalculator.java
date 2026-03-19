package org.howard.edu.lsp.midterm.strategy;

/**
 * Context class that uses a discount strategy to calculate
 * the final purchase price.
 *
 * @author [INPUT NAME]
 */
public class PriceCalculator {
    
    private DiscountStrategy discountStrategy;

    /**
     * Sets the discount strategy to be used by this calculator.
     *
     * @param discountStrategy the discount strategy to use
     */
    public void setDiscountStrategy(DiscountStrategy discountStrategy) {
        this.discountStrategy = discountStrategy;
    }

    /**
     * Calculates the final price using the current discount strategy.
     *
     * @param price the original purchase price
     * @return the final price after applying the current strategy
     * @throws IllegalStateException if no discount strategy has been set
     */
    public double calculatePrice(double price) {
        if (discountStrategy == null) {
            throw new IllegalStateException("Discount strategy must be set before calculating price.");
        }
        return discountStrategy.applyDiscount(price);
    }
}