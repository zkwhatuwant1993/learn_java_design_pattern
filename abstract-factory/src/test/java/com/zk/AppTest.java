package com.zk;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

/**
 * Tests that Abstract Factory example runs without errors.
 */
public class AppTest 
{
    /**
     * Issue: Add at least one assertion to this test case.
     *
     * Solution: Inserted assertion to check whether the execution of the main method in {@link App}
     * throws an exception.
     */

    @Test
    void shouldExecuteApplicationWithoutException() {

        assertDoesNotThrow(() -> App.main(new String[]{}));
    }
}
