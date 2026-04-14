package org.howard.edu.lsp.assignment6;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.NoSuchElementException;

import org.junit.jupiter.api.Test;

/**
 * JUnit 5 test suite for the {@link IntegerSet} class.
 * Tests normal and edge cases for all required methods.
 *
 * @author Ibrahim Osman
 * @version 1.0
 */
public class IntegerSetTest {

    /**
     * Tests that clear() removes all elements from a non-empty set.
     */
    @Test
    public void testClearNormalCase() {
        IntegerSet set = new IntegerSet();
        set.add(1);
        set.add(2);
        set.add(3);

        set.clear();

        assertTrue(set.isEmpty());
        assertEquals(0, set.length());
    }

    /**
     * Tests that clear() leaves an already empty set unchanged.
     */
    @Test
    public void testClearEdgeCaseAlreadyEmpty() {
        IntegerSet set = new IntegerSet();

        set.clear();

        assertTrue(set.isEmpty());
        assertEquals(0, set.length());
    }

    /**
     * Tests that length() returns the correct size for a non-empty set.
     */
    @Test
    public void testLengthNormalCase() {
        IntegerSet set = new IntegerSet();
        set.add(10);
        set.add(20);
        set.add(30);

        assertEquals(3, set.length());
    }

    /**
     * Tests that length() returns 0 for an empty set.
     */
    @Test
    public void testLengthEdgeCaseEmptySet() {
        IntegerSet set = new IntegerSet();

        assertEquals(0, set.length());
    }

    /**
     * Tests that equals() returns true for sets with the same elements
     * in different orders.
     */
    @Test
    public void testEqualsNormalCaseSameElementsDifferentOrder() {
        IntegerSet set1 = new IntegerSet();
        IntegerSet set2 = new IntegerSet();

        set1.add(1);
        set1.add(2);
        set1.add(3);

        set2.add(3);
        set2.add(1);
        set2.add(2);

        assertTrue(set1.equals(set2));
    }

    /**
     * Tests that equals() returns false for sets with different elements.
     */
    @Test
    public void testEqualsEdgeCaseMismatch() {
        IntegerSet set1 = new IntegerSet();
        IntegerSet set2 = new IntegerSet();

        set1.add(1);
        set1.add(2);
        set1.add(3);

        set2.add(1);
        set2.add(2);
        set2.add(4);

        assertFalse(set1.equals(set2));
    }

    /**
     * Tests that contains() returns true when the value is present.
     */
    @Test
    public void testContainsNormalCasePresent() {
        IntegerSet set = new IntegerSet();
        set.add(5);
        set.add(10);

        assertTrue(set.contains(10));
    }

    /**
     * Tests that contains() returns false when the value is absent.
     */
    @Test
    public void testContainsEdgeCaseAbsent() {
        IntegerSet set = new IntegerSet();
        set.add(5);
        set.add(10);

        assertFalse(set.contains(99));
    }

    /**
     * Tests that largest() returns the maximum value in a set
     * with multiple elements.
     */
    @Test
    public void testLargestNormalCase() {
        IntegerSet set = new IntegerSet();
        set.add(4);
        set.add(9);
        set.add(2);

        assertEquals(9, set.largest());
    }

    /**
     * Tests that largest() returns the only value in a single-element set.
     */
    @Test
    public void testLargestEdgeCaseSingleElement() {
        IntegerSet set = new IntegerSet();
        set.add(42);

        assertEquals(42, set.largest());
    }

    /**
     * Tests that largest() throws NoSuchElementException for an empty set.
     */
    @Test
    public void testLargestExceptionEmptySet() {
        IntegerSet set = new IntegerSet();

        assertThrows(NoSuchElementException.class, set::largest);
    }

    /**
     * Tests that smallest() returns the minimum value in a set
     * with multiple elements.
     */
    @Test
    public void testSmallestNormalCase() {
        IntegerSet set = new IntegerSet();
        set.add(4);
        set.add(9);
        set.add(2);

        assertEquals(2, set.smallest());
    }

    /**
     * Tests that smallest() returns the only value in a single-element set.
     */
    @Test
    public void testSmallestEdgeCaseSingleElement() {
        IntegerSet set = new IntegerSet();
        set.add(42);

        assertEquals(42, set.smallest());
    }

    /**
     * Tests that smallest() throws NoSuchElementException for an empty set.
     */
    @Test
    public void testSmallestExceptionEmptySet() {
        IntegerSet set = new IntegerSet();

        assertThrows(NoSuchElementException.class, set::smallest);
    }

    /**
     * Tests that add() inserts new distinct values into the set.
     */
    @Test
    public void testAddNormalCase() {
        IntegerSet set = new IntegerSet();

        set.add(7);
        set.add(8);

        assertEquals(2, set.length());
        assertTrue(set.contains(7));
        assertTrue(set.contains(8));
    }

    /**
     * Tests that add() does not insert duplicate values.
     */
    @Test
    public void testAddEdgeCaseDuplicateValue() {
        IntegerSet set = new IntegerSet();

        set.add(7);
        set.add(7);

        assertEquals(1, set.length());
        assertTrue(set.contains(7));
    }

    /**
     * Tests that remove() deletes an existing value from the set.
     */
    @Test
    public void testRemoveNormalCase() {
        IntegerSet set = new IntegerSet();
        set.add(1);
        set.add(2);
        set.add(3);

        set.remove(2);

        assertEquals(2, set.length());
        assertFalse(set.contains(2));
    }

    /**
     * Tests that remove() leaves the set unchanged when the value is not present.
     */
    @Test
    public void testRemoveEdgeCaseValueNotPresent() {
        IntegerSet set = new IntegerSet();
        set.add(1);
        set.add(2);

        set.remove(99);

        assertEquals(2, set.length());
        assertTrue(set.contains(1));
        assertTrue(set.contains(2));
    }

    /**
     * Tests that union() returns a set containing all distinct elements
     * from both sets.
     */
    @Test
    public void testUnionNormalCase() {
        IntegerSet set1 = new IntegerSet();
        IntegerSet set2 = new IntegerSet();

        set1.add(1);
        set1.add(2);

        set2.add(2);
        set2.add(3);

        IntegerSet result = set1.union(set2);

        assertEquals("[1, 2, 3]", result.toString());
    }

    /**
     * Tests that union() with an empty set returns the original set.
     */
    @Test
    public void testUnionEdgeCaseWithEmptySet() {
        IntegerSet set1 = new IntegerSet();
        IntegerSet emptySet = new IntegerSet();

        set1.add(1);
        set1.add(2);

        IntegerSet result = set1.union(emptySet);

        assertEquals("[1, 2]", result.toString());
    }

    /**
     * Tests that intersect() returns only the common elements
     * between two sets.
     */
    @Test
    public void testIntersectNormalCase() {
        IntegerSet set1 = new IntegerSet();
        IntegerSet set2 = new IntegerSet();

        set1.add(1);
        set1.add(2);
        set1.add(3);

        set2.add(2);
        set2.add(3);
        set2.add(4);

        IntegerSet result = set1.intersect(set2);

        assertEquals("[2, 3]", result.toString());
    }

    /**
     * Tests that intersect() returns an empty set when there are
     * no common elements.
     */
    @Test
    public void testIntersectEdgeCaseNoCommonElements() {
        IntegerSet set1 = new IntegerSet();
        IntegerSet set2 = new IntegerSet();

        set1.add(1);
        set1.add(2);

        set2.add(3);
        set2.add(4);

        IntegerSet result = set1.intersect(set2);

        assertTrue(result.isEmpty());
        assertEquals("[]", result.toString());
    }

    /**
     * Tests that diff() returns the elements in the first set
     * that are not in the second set.
     */
    @Test
    public void testDiffNormalCase() {
        IntegerSet set1 = new IntegerSet();
        IntegerSet set2 = new IntegerSet();

        set1.add(1);
        set1.add(2);
        set1.add(3);

        set2.add(2);

        IntegerSet result = set1.diff(set2);

        assertEquals("[1, 3]", result.toString());
    }

    /**
     * Tests that diff() returns an empty set when both sets are identical.
     */
    @Test
    public void testDiffEdgeCaseIdenticalSets() {
        IntegerSet set1 = new IntegerSet();
        IntegerSet set2 = new IntegerSet();

        set1.add(1);
        set1.add(2);

        set2.add(1);
        set2.add(2);

        IntegerSet result = set1.diff(set2);

        assertTrue(result.isEmpty());
        assertEquals("[]", result.toString());
    }

    /**
     * Tests that complement() returns the elements in the second set
     * that are not in the first set.
     */
    @Test
    public void testComplementNormalCase() {
        IntegerSet set1 = new IntegerSet();
        IntegerSet set2 = new IntegerSet();

        set1.add(1);
        set1.add(2);

        set2.add(1);
        set2.add(2);
        set2.add(3);
        set2.add(4);

        IntegerSet result = set1.complement(set2);

        assertEquals("[3, 4]", result.toString());
    }

    /**
     * Tests that complement() returns all elements of the second set
     * when the two sets are disjoint.
     */
    @Test
    public void testComplementEdgeCaseDisjointSets() {
        IntegerSet set1 = new IntegerSet();
        IntegerSet set2 = new IntegerSet();

        set1.add(1);
        set1.add(2);

        set2.add(3);
        set2.add(4);

        IntegerSet result = set1.complement(set2);

        assertEquals("[3, 4]", result.toString());
    }

    /**
     * Tests that isEmpty() returns true for an empty set.
     */
    @Test
    public void testIsEmptyNormalCaseEmptySet() {
        IntegerSet set = new IntegerSet();

        assertTrue(set.isEmpty());
    }

    /**
     * Tests that isEmpty() returns false for a non-empty set.
     */
    @Test
    public void testIsEmptyEdgeCaseNonEmptySet() {
        IntegerSet set = new IntegerSet();
        set.add(1);

        assertFalse(set.isEmpty());
    }

    /**
     * Tests that toString() returns the required sorted format
     * for a non-empty set.
     */
    @Test
    public void testToStringNormalCase() {
        IntegerSet set = new IntegerSet();
        set.add(3);
        set.add(1);
        set.add(2);

        assertEquals("[1, 2, 3]", set.toString());
    }

    /**
     * Tests that toString() returns [] for an empty set.
     */
    @Test
    public void testToStringEdgeCaseEmptySet() {
        IntegerSet set = new IntegerSet();

        assertEquals("[]", set.toString());
    }
}