package org.howard.edu.lsp.finalexam.question3;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * Tests the behavior of the GradeCalculator class.
 * 
 * This test class verifies that GradeCalculator correctly calculates averages,
 * assigns letter grades, determines passing status, handles boundary values,
 * and throws exceptions for invalid score inputs.
 * 
 * @author Ibrahim Osman
 * @version 1.0
 */
public class GradeCalculatorTest {

    /**
     * Tests that the average method correctly calculates the average
     * when scores are at valid boundary values.
     */
    @Test
    public void testAverageWithValidBoundaryScores() {
        GradeCalculator calculator = new GradeCalculator();

        double result = calculator.average(0, 100, 100);

        assertEquals(200.0 / 3.0, result, 0.001);
    }

    /**
     * Tests that the letterGrade method correctly assigns letter grades
     * at important grade boundary values.
     */
    @Test
    public void testLetterGradeAtBoundaryValues() {
        GradeCalculator calculator = new GradeCalculator();

        assertEquals("A", calculator.letterGrade(90.0));
        assertEquals("B", calculator.letterGrade(80.0));
        assertEquals("C", calculator.letterGrade(70.0));
        assertEquals("D", calculator.letterGrade(60.0));
        assertEquals("F", calculator.letterGrade(59.9));
    }

    /**
     * Tests that the isPassing method correctly determines passing status
     * at the passing boundary.
     */
    @Test
    public void testIsPassingAtBoundaryValues() {
        GradeCalculator calculator = new GradeCalculator();

        assertTrue(calculator.isPassing(60.0));
        assertFalse(calculator.isPassing(59.9));
    }

    /**
     * Tests that the average method throws an IllegalArgumentException
     * when one of the scores is below 0.
     */
    @Test
    public void testAverageThrowsExceptionForScoreBelowZero() {
        GradeCalculator calculator = new GradeCalculator();

        assertThrows(IllegalArgumentException.class, () -> {
            calculator.average(-1, 80, 90);
        });
    }

    /**
     * Tests that the average method throws an IllegalArgumentException
     * when one of the scores is above 100.
     */
    @Test
    public void testAverageThrowsExceptionForScoreAboveOneHundred() {
        GradeCalculator calculator = new GradeCalculator();

        assertThrows(IllegalArgumentException.class, () -> {
            calculator.average(80, 90, 101);
        });
    }
}