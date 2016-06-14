package com.zillow;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;

public class SolutionTest {
    @Rule
    public ExpectedException mExpectedEx = ExpectedException.none();

    @Test
    public void testNullInput() throws Exception {
        mExpectedEx.expect(NumberFormatException.class);
        mExpectedEx.expectMessage("null");
        Solution s = new Solution();
        s.stringToLong(null);
    }

    @Test
    public void testEmptyInput() throws Exception {
        mExpectedEx.expect(NumberFormatException.class);
        mExpectedEx.expectMessage("empty string");
        Solution s = new Solution();
        s.stringToLong("");
    }

    @Test
    public void testInputStartsWithZeros() throws Exception {
        Solution s = new Solution();
        long val = s.stringToLong("00000109");
        assertEquals(val, 109);
    }

    @Test
    public void testInputStartsWithPlus() throws Exception {
        Solution s = new Solution();
        long val = s.stringToLong("+109");
        assertEquals(val, 109);
    }

    @Test
    public void testInputStartsWithMinus() throws Exception {
        Solution s = new Solution();
        long val = s.stringToLong("-109");
        assertEquals(val, -109);
    }

    @Test
    public void testInputWithInvalidChar() throws Exception {
        mExpectedEx.expect(NumberFormatException.class);
        mExpectedEx.expectMessage("Invalid character");
        Solution s = new Solution();
        s.stringToLong("1a09");
    }

    @Test
    public void testInputMaxValue() throws Exception {
        Solution s = new Solution();
        long max = s.stringToLong("9223372036854775807");
        assertEquals(max, Long.MAX_VALUE);
    }

    @Test
    public void testInputMinValue() throws Exception {
        Solution s = new Solution();
        long min =s.stringToLong("-9223372036854775808");
        assertEquals(min, Long.MIN_VALUE);
    }

    @Test
    public void testInputLargerThanMaxValue() throws Exception {
        mExpectedEx.expect(NumberFormatException.class);
        mExpectedEx.expectMessage("Out of range");
        Solution s = new Solution();
        s.stringToLong("9223372036854775808");
    }

    @Test
    public void testInputSmallerThanMinValue() throws Exception {
        mExpectedEx.expect(NumberFormatException.class);
        mExpectedEx.expectMessage("Out of range");
        Solution s = new Solution();
        s.stringToLong("-9223372036854775809");
    }
}