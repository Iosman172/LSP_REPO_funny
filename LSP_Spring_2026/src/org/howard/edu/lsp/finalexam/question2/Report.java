package org.howard.edu.lsp.finalexam.question2;

/**
 * Defines the template for generating a report.
 * 
 * The {@code generateReport} method is the template method because it fixes
 * the overall report generation workflow. Subclasses provide the specific
 * behavior for loading data and printing each section of the report.
 *
 * @author Ibrahim Osman
 * @version 1.0
 */
public abstract class Report {
    /**
     * Generates a complete report using a fixed workflow.
     * 
     * The workflow is:
     * load data, print the header, print the body, and print the footer.
     * This method is final so subclasses cannot change the order of the steps.
     */
    public final void generateReport() {
        loadData();

        System.out.println("=== HEADER ===");
        printHeader();

        System.out.println();
        System.out.println("=== BODY ===");
        printBody();

        System.out.println();
        System.out.println("=== FOOTER ===");
        printFooter();
        System.out.println();
    }

    /**
     * Loads the data needed for the report.
     * 
     * Each subclass must define what data is loaded for its specific report type.
     */
    protected abstract void loadData();

    /**
     * Prints the report-specific header content.
     */
    protected abstract void printHeader();

    /**
     * Prints the report-specific body content.
     */
    protected abstract void printBody();

    /**
     * Prints the report-specific footer content.
     */
    protected abstract void printFooter();
}