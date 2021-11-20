package zad1.tests.unit

import groovy.test.GroovyTestCase
import zad1.Main

class InputValidationCase extends GroovyTestCase {
    void testAssertions() {
        assertFalse("An empty string is incorrect.", Main.isValidInput(""))
        assertFalse("A null input is incorrect.", Main.isValidInput(null))

        // at least one incorrect number type
        assertFalse("Other numeric types than integer are not allowed.", Main.isValidInput("10.5"))
        assertFalse("Other numeric types than integer are not allowed.", Main.isValidInput("-10.5"))
        assertFalse("Other numeric types than integer are not allowed.", Main.isValidInput("-10,51"))
        assertFalse("Other numeric types than integer are not allowed.", Main.isValidInput("10,51"))
        assertFalse("Other numeric types than integer are not allowed.", Main.isValidInput("10.5 10"))
        assertFalse("Other numeric types than integer are not allowed.", Main.isValidInput("-10.5 10"))
        assertFalse("Other numeric types than integer are not allowed.", Main.isValidInput("10 15 10.5"))
        assertFalse("Other numeric types than integer are not allowed.", Main.isValidInput("10 15 0.3(3) -10.5"))
        assertFalse("Other numeric types than integer are not allowed.", Main.isValidInput("10 17.1 12"))
        assertFalse("Other numeric types than integer are not allowed.", Main.isValidInput("10 -17.1 1/2 12"))

        // non-numeric types
        assertFalse("Non-numeric types are not allowed.", Main.isValidInput("abc"))
        assertFalse("Non-numeric types are not allowed.", Main.isValidInput("abc10"))
        assertFalse("Non-numeric types are not allowed.", Main.isValidInput("abc 10"))
        assertFalse("Non-numeric types are not allowed.", Main.isValidInput("abc -10"))
        assertFalse("Non-numeric types are not allowed.", Main.isValidInput("10 abc"))
        assertFalse("Non-numeric types are not allowed.", Main.isValidInput("-10 abc"))
        assertFalse("Non-numeric types are not allowed.", Main.isValidInput("abc 10 deb"))
        assertFalse("Non-numeric types are not allowed.", Main.isValidInput("abc -10 deb"))
        assertFalse("Non-numeric types are not allowed.", Main.isValidInput("abc 10 deb 12"))
        assertFalse("Non-numeric types are not allowed.", Main.isValidInput("-abc 10 deb 12"))

        // correct cases
        assertTrue("Positive integers should be allowed.", Main.isValidInput("10 12 15 18"))
        assertTrue("Zero should be allowed.", Main.isValidInput("0"))
        assertTrue("Zero should be allowed.", Main.isValidInput("-0"))
        assertTrue("Negative integers should be allowed.", Main.isValidInput("-10 -15 -3"))
        assertTrue("Mix of negative and positive integers should be allowed.", Main.isValidInput("-10 6 -15 10 0 -3"))

        // TODO: jak funkcja zachowa się wobec "01 2 003 4"
    }

}
