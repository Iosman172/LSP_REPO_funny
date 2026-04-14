package org.howard.edu.lsp.assignment6;

import java.util.ArrayList;
import java.util.Collections;
import java.util.NoSuchElementException;

/**
 * Models a mathematical set of integers.
 * A set contains no duplicate values and supports standard set operations.
 *
 * @author Ibrahim Osman
 * @version 1.0
 */
public class IntegerSet {
    private ArrayList<Integer> set;

    /**
     * Constructs an empty IntegerSet.
     */
    public IntegerSet() {
        set = new ArrayList<Integer>();
    }

    /**
     * Removes all elements from the set.
     */
    public void clear() {
        set.clear();
    }

    /**
     * Returns the number of elements currently in the set.
     *
     * @return the size of the set
     */
    public int length() {
        return set.size();
    }

    /**
     * Determines whether this set contains exactly the same elements as another set.
     * The order of elements does not matter.
     *
     * @param b the other IntegerSet to compare with
     * @return true if both sets contain exactly the same elements, false otherwise
     */
    public boolean equals(IntegerSet b) {
        if (b == null) {
            return false;
        }
        if (this.length() != b.length()) {
            return false;
        }
        return this.set.containsAll(b.set) && b.set.containsAll(this.set);
    }

    /**
     * Checks whether the given value is contained in the set.
     *
     * @param value the integer value to search for
     * @return true if the value is present in the set, false otherwise
     */
    public boolean contains(int value) {
        return set.contains(value);
    }

    /**
     * Returns the largest value in the set.
     *
     * @return the largest integer in the set
     * @throws NoSuchElementException if the set is empty
     */
    public int largest() {
        if (isEmpty()) {
            throw new NoSuchElementException("IntegerSet is empty.");
        }
        return Collections.max(set);
    }

    /**
     * Returns the smallest value in the set.
     *
     * @return the smallest integer in the set
     * @throws NoSuchElementException if the set is empty
     */
    public int smallest() {
        if (isEmpty()) {
            throw new NoSuchElementException("IntegerSet is empty.");
        }
        return Collections.min(set);
    }

    /**
     * Adds the given item to the set if it is not already present.
     *
     * @param item the integer to add
     */
    public void add(int item) {
        if (!set.contains(item)) {
            set.add(item);
        }
    }

    /**
     * Removes the given item from the set if it is present.
     *
     * @param item the integer to remove
     */
    public void remove(int item) {
        set.remove(Integer.valueOf(item));
    }

    /**
     * Returns a new set containing all elements that appear in either this set
     * or the given set. The original sets are not modified.
     *
     * @param intSetb the other IntegerSet
     * @return a new IntegerSet representing the union of the two sets
     */
    public IntegerSet union(IntegerSet intSetb) {
        IntegerSet result = new IntegerSet();
        result.set.addAll(this.set);

        if (intSetb != null) {
            for (Integer value : intSetb.set) {
                if (!result.set.contains(value)) {
                    result.set.add(value);
                }
            }
        }

        return result;
    }

    /**
     * Returns a new set containing only the elements common to this set
     * and the given set. The original sets are not modified.
     *
     * @param intSetb the other IntegerSet
     * @return a new IntegerSet representing the intersection of the two sets
     */
    public IntegerSet intersect(IntegerSet intSetb) {
        IntegerSet result = new IntegerSet();

        if (intSetb == null) {
            return result;
        }

        result.set.addAll(this.set);
        result.set.retainAll(intSetb.set);

        return result;
    }

    /**
     * Returns a new set containing the elements that are in this set
     * but not in the given set. The original sets are not modified.
     *
     * @param intSetb the other IntegerSet
     * @return a new IntegerSet representing the difference of the two sets
     */
    public IntegerSet diff(IntegerSet intSetb) {
        IntegerSet result = new IntegerSet();
        result.set.addAll(this.set);

        if (intSetb != null) {
            result.set.removeAll(intSetb.set);
        }

        return result;
    }

    /**
     * Returns a new set containing the elements that are in the given set
     * but not in this set. The original sets are not modified.
     *
     * @param intSetb the other IntegerSet
     * @return a new IntegerSet representing the complement of this set relative to intSetb
     */
    public IntegerSet complement(IntegerSet intSetb) {
        IntegerSet result = new IntegerSet();

        if (intSetb == null) {
            return result;
        }

        result.set.addAll(intSetb.set);
        result.set.removeAll(this.set);

        return result;
    }

    /**
     * Checks whether the set contains no elements.
     *
     * @return true if the set is empty, false otherwise
     */
    public boolean isEmpty() {
        return set.isEmpty();
    }

    /**
     * Returns a string representation of the set in ascending order.
     * The format is [1, 2, 3]. An empty set is represented as [].
     *
     * @return the formatted string representation of the set
     */
    @Override
    public String toString() {
        ArrayList<Integer> sorted = new ArrayList<Integer>(set);
        Collections.sort(sorted);
        return sorted.toString();
    }
}