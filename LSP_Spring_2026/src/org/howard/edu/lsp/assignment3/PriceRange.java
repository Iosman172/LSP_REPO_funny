package org.howard.edu.lsp.assignment3;

import java.math.BigDecimal;

/**
 * Price range buckets derived from the final rounded price.
 */
public enum PriceRange {
  Low,
  Medium,
  High,
  Premium;

  /**
   * Determines the price range bucket from the final rounded price.
   *
   * <= 10.00 -> Low
   * > 10.00 and <= 100.00 -> Medium
   * > 100.00 and <= 500.00 -> High
   * > 500.00 -> Premium
   *
   * @param finalRoundedPrice Price rounded to 2 decimals (HALF_UP).
   * @return PriceRange bucket.
   */
  public static PriceRange fromPrice(BigDecimal finalRoundedPrice) {
    if (finalRoundedPrice.compareTo(new BigDecimal("10.00")) <= 0) {
      return Low;
    }
    if (finalRoundedPrice.compareTo(new BigDecimal("100.00")) <= 0) {
      return Medium;
    }
    if (finalRoundedPrice.compareTo(new BigDecimal("500.00")) <= 0) {
      return High;
    }
    return Premium;
  }
}