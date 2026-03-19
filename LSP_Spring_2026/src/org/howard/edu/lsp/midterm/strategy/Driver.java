package org.howard.edu.lsp.midterm.strategy;

/**
 * Driver class that demonstrates the Strategy Pattern implementation
 * for customer discount pricing.
 *
 * @author Ibrahim Osman
 */
public class Driver {

    /**
     * Demonstrates price calculation for different customer types
     * using a purchase price of 100.0.
     *
     * @param args command-line arguments
     */
    public static void main(String[] args) {
        PriceCalculator calculator = new PriceCalculator();
        double price = 100.0;

        calculator.setDiscountStrategy(new RegularDiscountStrategy());
        System.out.println("REGULAR: " + calculator.calculatePrice(price));

        calculator.setDiscountStrategy(new MemberDiscountStrategy());
        System.out.println("MEMBER: " + calculator.calculatePrice(price));

        calculator.setDiscountStrategy(new VipDiscountStrategy());
        System.out.println("VIP: " + calculator.calculatePrice(price));

        calculator.setDiscountStrategy(new HolidayDiscountStrategy());
        System.out.println("HOLIDAY: " + calculator.calculatePrice(price));
    }
}