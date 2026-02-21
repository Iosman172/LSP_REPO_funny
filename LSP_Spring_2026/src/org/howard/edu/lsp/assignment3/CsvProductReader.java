package org.howard.edu.lsp.assignment3;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Reads product rows from the required input CSV.
 * Skips the header row exactly once, matching Assignment 2.
 */
public class CsvProductReader implements Closeable {
  private final BufferedReader reader;
  private boolean headerSkipped;

  /**
   * Constructs a reader for the given input file.
   *
   * @param inputPath Relative path to the input CSV file (data/products.csv).
   * @throws FileNotFoundException If the input file does not exist.
   */
  public CsvProductReader(String inputPath) throws FileNotFoundException {
    this.reader = new BufferedReader(new FileReader(inputPath));
    this.headerSkipped = false;
  }

  /**
   * Reads the next non-header line from the CSV file.
   * The first call consumes the header row (which may be null if the file is empty).
   *
   * @return Next data line, or null if end of file.
   * @throws IOException If an I/O error occurs.
   */
  public String readNextDataLine() throws IOException {
    if (!headerSkipped) {
      reader.readLine(); // discard header
      headerSkipped = true;
    }
    return reader.readLine();
  }

  /**
   * Closes the underlying reader.
   *
   * @throws IOException If closing fails.
   */
  @Override
  public void close() throws IOException {
    reader.close();
  }
}