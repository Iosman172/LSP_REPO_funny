package org.howard.edu.lsp.assignment3;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Applies Assignment 2 transformation rules in the required order.
 */
public class DefaultProductTransformer implements ProductTransformer {

  /**
   * Transformation order (as required):
   * 1) Convert product name to UPPERCASE.
   * 2) If category is "Electronics", apply 10% discount.
   * (Required to define "final rounded price"): round HALF_UP to 2 decimals.
   * 3) If final rounded price > 500.00 AND original category was "Electronics",
   *    change category to "Premium Electronics".
   * 4) Compute PriceRange based on final rounded price.
   *
   * @param input Validated input record.
   * @return Transformed output record.
   */
  @Override
  public ProductOutputRecord transform(ProductInputRecord input) {
    final int productId = input.getProductId();
    final String originalCategory = input.getCategory();

    // 1) Name uppercase
    final String nameUpper = input.getName().toUpperCase();

    BigDecimal price = input.getPrice();
    String finalCategory = originalCategory;

    // 2) Discount if original category is Electronics
    if ("Electronics".equals(originalCategory)) {
      price = price.multiply(new BigDecimal("0.9"));
    }

    // Required: final rounded price used for steps 3 and 4
    price = price.setScale(2, RoundingMode.HALF_UP);

    // 3) Premium Electronics check (based on final rounded price AND original category)
    if ("Electronics".equals(originalCategory) && price.compareTo(new BigDecimal("500.00")) > 0) {
      finalCategory = "Premium Electronics";
    }

    // 4) PriceRange from final rounded price
    PriceRange range = PriceRange.fromPrice(price);

    return new ProductOutputRecord(productId, nameUpper, price, finalCategory, range);
  }
}