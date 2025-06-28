package com.unit.testing;

import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import static org.junit.Assert.*;

public class AAAPatternTest {
    private int a;
    private int b;
    private int result;

    @Before
    public void setUp() {
        // Arrange: Initialize variables before each test
        a = 10;
        b = 5;
        result = 0;
    }

    @After
    public void tearDown() {
        // Teardown: Reset variables after each test
        a = 0;
        b = 0;
        result = 0;
    }

    @Test
    public void testAddition() {
        // Act
        result = a + b;
        // Assert
        assertEquals(15, result);
    }

    @Test
    public void testSubtraction() {
        // Act
        result = a - b;
        // Assert
        assertEquals(5, result);
    }
} 