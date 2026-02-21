package org.howard.edu.lsp.assignment3;

/**
 * Represents the result of parsing: either a valid ProductInputRecord or invalid (skip).
 */
public class ProductRowParseResult {
  private final boolean valid;
  private final ProductInputRecord record;

  private ProductRowParseResult(boolean valid, ProductInputRecord record) {
    this.valid = valid;
    this.record = record;
  }

  /**
   * Creates a valid parse result.
   *
   * @param record Parsed product record.
   * @return Valid parse result.
   */
  public static ProductRowParseResult valid(ProductInputRecord record) {
    return new ProductRowParseResult(true, record);
  }

  /**
   * Creates an invalid parse result (indicates row should be skipped).
   *
   * @return Invalid parse result.
   */
  public static ProductRowParseResult invalid() {
    return new ProductRowParseResult(false, null);
  }

  /**
   * Returns whether the parse was valid.
   *
   * @return True if valid; false if invalid.
   */
  public boolean isValid() {
    return valid;
  }

  /**
   * Returns the parsed record (only meaningful when isValid() is true).
   *
   * @return Parsed product record.
   */
  public ProductInputRecord getRecord() {
    return record;
  }
}