package org.howard.edu.lsp.assignment3;

import java.math.BigDecimal;

/**
 * Encapsulates a transformed product record in the required output schema.
 */
public class ProductOutputRecord {
  private final int productId;
  private final String nameUpper;
  private final BigDecimal price;
  private final String category;
  private final PriceRange priceRange;

  /**
   * Constructs an output record.
   *
   * @param productId Product ID.
   * @param nameUpper Uppercased product name.
   * @param price Final rounded price (2 decimals, HALF_UP).
   * @param category Final category.
   * @param priceRange Price range bucket.
   */
  public ProductOutputRecord(int productId, String nameUpper, BigDecimal price, String category, PriceRange priceRange) {
    this.productId = productId;
    this.nameUpper = nameUpper;
    this.price = price;
    this.category = category;
    this.priceRange = priceRange;
  }

  /** @return Product ID. */
  public int getProductId() {
    return productId;
  }

  /** @return Uppercased product name. */
  public String getNameUpper() {
    return nameUpper;
  }

  /** @return Final rounded price. */
  public BigDecimal getPrice() {
    return price;
  }

  /** @return Final category. */
  public String getCategory() {
    return category;
  }

  /** @return Price range bucket. */
  public PriceRange getPriceRange() {
    return priceRange;
  }

  /**
   * Formats the record as a CSV row with required column order and formatting.
   *
   * @return CSV row string.
   */
  public String toCsvRow() {
    // price is already setScale(2), so toPlainString prints exactly two decimals.
    String priceStr = price.toPlainString();
    return productId + "," + nameUpper + "," + priceStr + "," + category + "," + priceRange.name();
  }
}