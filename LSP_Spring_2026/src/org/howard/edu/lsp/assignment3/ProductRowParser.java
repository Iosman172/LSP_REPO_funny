package org.howard.edu.lsp.assignment3;

import java.math.BigDecimal;

/**
 * Parses and validates one CSV data line according to Assignment 2 skipping rules.
 */
public class ProductRowParser {

  /**
   * Parses a raw CSV line into a ProductInputRecord if valid; otherwise returns invalid.
   *
   * Skipping rules:
   * - blank line
   * - not exactly 4 comma-separated fields
   * - ProductID or Price cannot be parsed
   *
   * @param line Raw CSV data line (non-header).
   * @return Parse result.
   */
  public ProductRowParseResult parse(String line) {
    if (line == null) {
      return ProductRowParseResult.invalid();
    }

    if (line.trim().isEmpty()) {
      return ProductRowParseResult.invalid();
    }

    String[] parts = line.split(",");
    if (parts.length != 4) {
      return ProductRowParseResult.invalid();
    }

    for (int i = 0; i < 4; i++) {
      parts[i] = parts[i].trim();
    }

    final int productId;
    final BigDecimal price;
    try {
      productId = Integer.parseInt(parts[0]);
      price = new BigDecimal(parts[2]);
    } catch (NumberFormatException e) {
      return ProductRowParseResult.invalid();
    }

    ProductInputRecord record = new ProductInputRecord(productId, parts[1], price, parts[3]);
    return ProductRowParseResult.valid(record);
  }
}