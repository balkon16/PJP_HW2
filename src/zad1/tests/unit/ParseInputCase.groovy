package zad1.tests.unit

import groovy.test.GroovyTestCase
import zad1.Main

class ParseInputCase extends GroovyTestCase {
    void testAssertions() {
        assertTrue(Main.getInts("10") == [10])
        assertTrue(Main.getInts("10 12") == [10, 12])
        assertTrue(Main.getInts("0 1 2 3") == [0, 1, 2, 3])
        assertTrue(Main.getInts("-10 2 1") == [-10, 2, 1])
        assertTrue(Main.getInts("-0 32 1") == [0, 32, 1])
    }

}
