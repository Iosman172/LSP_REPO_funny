package org.howard.edu.lsp.finalexam.question2;

/**
 * Represents a course report.
 * 
 * This class provides the course-specific steps for the report template,
 * including loading course data and printing the course report sections.
 *
 * @author Ibrahim Osman
 * @version 1.0
 */
public class CourseReport extends Report {
    private String courseName;
    private int enrollment;

    /**
     * Loads the course data used in the report.
     */
    @Override
    protected void loadData() {
        courseName = "CSCI 363";
        enrollment = 45;
    }

    /**
     * Prints the header for the course report.
     */
    @Override
    protected void printHeader() {
        System.out.println("Course Report");
    }

    /**
     * Prints the body of the course report, including the course name and enrollment.
     */
    @Override
    protected void printBody() {
        System.out.println("Course: " + courseName);
        System.out.println("Enrollment: " + enrollment);
    }

    /**
     * Prints the footer for the course report.
     */
    @Override
    protected void printFooter() {
        System.out.println("End of Course Report");
    }
}