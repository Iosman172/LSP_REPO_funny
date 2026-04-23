package org.howard.edu.lsp.finalexam.question2;

/**
 * Represents a student report.
 * 
 * This class provides the student-specific steps for the report template,
 * including loading student data and printing the student report sections.
 *
 * @author Ibrahim Osman
 * @version 1.0
 */
public class StudentReport extends Report {
    private String studentName;
    private double gpa;

    /**
     * Loads the student data used in the report.
     */
    @Override
    protected void loadData() {
        studentName = "John Doe";
        gpa = 3.8;
    }

    /**
     * Prints the header for the student report.
     */
    @Override
    protected void printHeader() {
        System.out.println("Student Report");
    }

    /**
     * Prints the body of the student report, including the student's name and GPA.
     */
    @Override
    protected void printBody() {
        System.out.println("Student Name: " + studentName);
        System.out.println("GPA: " + gpa);
    }

    /**
     * Prints the footer for the student report.
     */
    @Override
    protected void printFooter() {
        System.out.println("End of Student Report");
    }
}