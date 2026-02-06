package org.howard.edu.lsp.assignment2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class ETLPipeline {

	/**
	 * Reads product rows from an input CSV, transforms valid records, and writes them to an output CSV.
	 * Prints a summary of rows read, transformed, and skipped, plus the output file path.
	 */
	public static void main(String[] args) {
		String Infile = "data/products.csv";
		String Outfile = "data/transformed_products.csv";
		
		int read_rows = 0;
		int skipped_rows = 0;
		int trans_rows = 0;
		
		// Open files (auto-closed by try-with-resources)
		try (BufferedReader reading = new BufferedReader(new FileReader(Infile));
			 BufferedWriter writing = new BufferedWriter(new FileWriter(Outfile))
			){
			// Skip input header
			reading.readLine();
			
			// Write output header
			writing.write("ProductID,Name,Price,Category,PriceRange");
			writing.newLine();
			
			String row;
			while ((row = reading.readLine()) != null) {
				read_rows++;
				
				// Skip blank lines
				if (row.trim().isEmpty()) {
					skipped_rows++;
					continue;
				}
				
				// Split row into columns; must be exactly 4 fields
				String[] pieces = row.split(",");
				if (pieces.length != 4) {
					skipped_rows++;
					continue;
				}
				
				// Trim whitespace on each field
				for (int i = 0; i < 4; i++) {
					pieces[i] = pieces[i].trim();
				}
				
				// Transform one record; "Skip" means invalid data
				String transformed_row = transform(pieces);
				if ("Skip".equals(transformed_row)){
					skipped_rows++;
					continue;
				} else {
					trans_rows++;
				}
				
				// Write transformed record
				writing.write(transformed_row);
				writing.newLine();
			}
			
			// Print run summary
			System.out.println("Number of rows read: " + read_rows);
			System.out.println("Number of rows transformed: " + trans_rows);
			System.out.println("Number of rows skipped: " + skipped_rows);
			System.out.println("Output File Path: " + new File(Outfile).getAbsolutePath());
		} 
		catch (FileNotFoundException e) {
			System.out.println("Error: Missing Input File - " + Infile);
		}
		catch (IOException e) {
			System.out.println("Error: I/O failure while processing files.");
		}
	}

	/**
	 * Converts a 4-field product record into the output CSV format by normalizing the name,
	 * applying category/price rules, and computing a price range; returns "Skip" if parsing fails.
	 */
	private static String transform(String[] fields) {
		int productID;
		BigDecimal price;
		String price_range;

		// Grab raw fields (name/category) and normalize name
		String category = fields[3];
		String name =  fields[1].toUpperCase();
		
		// Parse numeric fields; invalid numbers => skip this record
		try {
			productID = Integer.parseInt(fields[0]);
			price = new BigDecimal(fields[2]);
		}
		catch(NumberFormatException e) {
			return "Skip";
		}
		
		// Electronics: 10% discount + possible category upgrade if > 500 after discount
		if ("Electronics".equals(category)) {
			price = price.multiply(new BigDecimal("0.9"));
			price = price.setScale(2, RoundingMode.HALF_UP);
			if (price.compareTo(new BigDecimal("500.00")) > 0) {
				category = "Premium Electronics";
			}
		}
		else {
			// Non-electronics: just round
			price = price.setScale(2, RoundingMode.HALF_UP);
		}
		
		// Assign price range bucket based on final price
		if (price.compareTo(new BigDecimal("10.00")) <= 0) {
			price_range = "Low";
		}
		else if (price.compareTo(new BigDecimal("100.00")) <= 0){
			price_range = "Medium";
		}
		else if (price.compareTo(new BigDecimal("500.00")) <= 0) {
			price_range = "High";
		}
		else {
			price_range = "Premium";
		}
		
		// Ensure price prints as a normal decimal string
		String str_price = price.toPlainString();
		
		// Return one CSV output line
		return (productID + "," + name + "," + str_price + "," + category + "," + price_range);
	}
}