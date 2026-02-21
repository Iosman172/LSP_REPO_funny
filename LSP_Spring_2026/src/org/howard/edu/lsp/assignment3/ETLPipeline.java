package org.howard.edu.lsp.assignment3;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Entry point for Assignment 3 ETL pipeline.
 * Orchestrates extract-transform-load while preserving Assignment 2 behavior.
 */
public class ETLPipeline {

  /**
   * Runs the ETL pipeline using the required relative input/output paths.
   *
   * @param args Command-line arguments (unused).
   */
  public static void main(String[] args) {
    final String inputPath = "data/products.csv";
    final String outputPath = "data/transformed_products.csv";

    RunSummary summary = new RunSummary(outputPath);
    ProductRowParser parser = new ProductRowParser();
    ProductTransformer transformer = new DefaultProductTransformer();
    CsvProductWriter writer = new CsvProductWriter(outputPath);

    try (CsvProductReader reader = new CsvProductReader(inputPath)) {
      // Assignment 2 behavior: always create output file and write header (even if input has only header)
      writer.openAndWriteHeader();

      String line;
      while ((line = reader.readNextDataLine()) != null) {
        // Assignment 2: rows read counts every non-header line encountered (including blank/bad rows)
        summary.incrementRowsRead();

        ProductRowParseResult parsed = parser.parse(line);
        if (!parsed.isValid()) {
          summary.incrementRowsSkipped();
          continue;
        }

        ProductOutputRecord out = transformer.transform(parsed.getRecord());
        writer.writeRecord(out);
        summary.incrementRowsTransformed();
      }

      // Assignment 2: print summary at end (successful run)
      summary.print(new File(outputPath).getAbsolutePath());
    } catch (FileNotFoundException e) {
      // Assignment 2 required: clear error message, clean exit, no stack trace.
      System.out.println("Error: Missing Input File - " + inputPath);
    } catch (IOException e) {
      // Assignment 2 required: clear error message, clean exit, no stack trace.
      System.out.println("Error: I/O failure while processing files.");
    } finally {
      // Ensure writer closed even if reader constructor throws.
      writer.closeQuietly();
    }
  }
}