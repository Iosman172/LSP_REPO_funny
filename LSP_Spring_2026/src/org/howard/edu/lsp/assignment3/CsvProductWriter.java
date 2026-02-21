package org.howard.edu.lsp.assignment3;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Writes transformed product records to the required output CSV file.
 * Always writes the header row first.
 */
public class CsvProductWriter {
  private final String outputPath;
  private BufferedWriter writer;

  /**
   * Constructs a writer for the given output file path.
   *
   * @param outputPath Relative output path (data/transformed_products.csv).
   */
  public CsvProductWriter(String outputPath) {
    this.outputPath = outputPath;
  }

  /**
   * Opens the output file and writes the required header row.
   *
   * @throws IOException If an I/O error occurs.
   */
  public void openAndWriteHeader() throws IOException {
    this.writer = new BufferedWriter(new FileWriter(outputPath));
    writer.write("ProductID,Name,Price,Category,PriceRange");
    writer.newLine();
  }

  /**
   * Writes one transformed product record as a CSV row.
   *
   * @param record The transformed record.
   * @throws IOException If an I/O error occurs.
   */
  public void writeRecord(ProductOutputRecord record) throws IOException {
    writer.write(record.toCsvRow());
    writer.newLine();
  }

  /**
   * Closes the writer, suppressing any IOException.
   * Used to keep the program's exit behavior clean.
   */
  public void closeQuietly() {
    if (writer == null) {
      return;
    }
    try {
      writer.close();
    } catch (IOException ignored) {
      // intentionally ignored
    }
  }
}