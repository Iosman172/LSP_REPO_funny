package org.howard.edu.lsp.finalexam.question2;

import java.util.ArrayList;
import java.util.List;

/**
 * Demonstrates the Template Method pattern using different report types.
 * 
 * The driver stores multiple {@code Report} objects in a list and calls
 * {@code generateReport} on each one to demonstrate polymorphism.
 *
 * @author Ibrahim Osman
 * @version 1.0
 */
public class Driver {
    /**
     * Runs the report generation program.
     * 
     * Creates a student report and a course report, stores them in a list of
     * {@code Report} references, and generates each report using the common
     * template method.
     *
     * @param args command-line arguments, not used by this program
     */
    public static void main(String[] args) {
        List<Report> reports = new ArrayList<>();

        reports.add(new StudentReport());
        reports.add(new CourseReport());

        for (Report report : reports) {
            report.generateReport();
        }
    }
}