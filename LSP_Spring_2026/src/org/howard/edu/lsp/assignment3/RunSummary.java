package org.howard.edu.lsp.assignment3;

/**
 * Tracks run statistics and prints the required summary.
 */
public class RunSummary {
  private int rowsRead;
  private int rowsTransformed;
  private int rowsSkipped;
  private final String outputPath;

  /**
   * Constructs a summary tracker.
   *
   * @param outputPath Relative output path used by the pipeline.
   */
  public RunSummary(String outputPath) {
    this.outputPath = outputPath;
    this.rowsRead = 0;
    this.rowsTransformed = 0;
    this.rowsSkipped = 0;
  }

  /** Increments the count of non-header rows encountered. */
  public void incrementRowsRead() {
    rowsRead++;
  }

  /** Increments the count of rows successfully transformed and written. */
  public void incrementRowsTransformed() {
    rowsTransformed++;
  }

  /** Increments the count of rows skipped due to invalid input. */
  public void incrementRowsSkipped() {
    rowsSkipped++;
  }

  /**
   * Prints the required run summary fields.
   *
   * @param absoluteOutputPath Absolute path to the output file written.
   */
  public void print(String absoluteOutputPath) {
    System.out.println("Number of rows read: " + rowsRead);
    System.out.println("Number of rows transformed: " + rowsTransformed);
    System.out.println("Number of rows skipped: " + rowsSkipped);
    System.out.println("Output File Path: " + absoluteOutputPath);
  }

  /**
   * Returns the output path (relative).
   *
   * @return Output path.
   */
  public String getOutputPath() {
    return outputPath;
  }
}