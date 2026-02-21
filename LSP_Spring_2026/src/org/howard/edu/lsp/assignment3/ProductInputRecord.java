package org.howard.edu.lsp.assignment3;

import java.math.BigDecimal;

/**
 * Encapsulates a validated input product record.
 */
public class ProductInputRecord {
  private final int productId;
  private final String name;
  private final BigDecimal price;
  private final String category;

  /**
   * Constructs an input record.
   *
   * @param productId Product ID.
   * @param name Product name (trimmed, original case).
   * @param price Product price (unrounded).
   * @param category Product category (trimmed).
   */
  public ProductInputRecord(int productId, String name, BigDecimal price, String category) {
    this.productId = productId;
    this.name = name;
    this.price = price;
    this.category = category;
  }

  /** @return Product ID. */
  public int getProductId() {
    return productId;
  }

  /** @return Product name (original case). */
  public String getName() {
    return name;
  }

  /** @return Product price (unrounded). */
  public BigDecimal getPrice() {
    return price;
  }

  /** @return Product category (original). */
  public String getCategory() {
    return category;
  }
}