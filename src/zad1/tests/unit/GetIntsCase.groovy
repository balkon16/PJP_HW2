package zad1.tests.unit

import groovy.test.GroovyTestCase
import zad1.Main

class GetIntsCase extends GroovyTestCase{
    void testAssertions() {
        assertTrue("All correct entries - typical integers", Main.getParsingResult("1 2 3 4") == new Tuple2(true, [1, 2, 3, 4]))
        assertTrue("All correct entries - various spacing", Main.getParsingResult("1   2  3 4") == new Tuple2(true, [1, 2, 3, 4]))
        assertTrue("Weird looking integers", Main.getParsingResult("001 2 000003 404") == new Tuple2(true, [1, 2, 3, 404]))
        assertTrue("Negative integers", Main.getParsingResult("-1 2 -3 4 -0005") == new Tuple2(true, [-1, 2, -3, 4, -5]))

        // incorrect cases
        assertTrue("Strings are not accepted", Main.getParsingResult("1 dog 2 apple") == new Tuple2(false, ["dog", "apple"]))
        assertTrue("Empty sequence", Main.getParsingResult("") == new Tuple2(false, ["No elements specified."]))
        assertTrue("Empty sequence", Main.getParsingResult(" ") == new Tuple2(false, ["No elements specified."]))
        assertTrue("Empty sequence", Main.getParsingResult("     ") == new Tuple2(false, ["No elements specified."]))
        assertTrue("Floats with zero decimal part", Main.getParsingResult("001 2.0 3 4.000 7.0000") == new Tuple2(false, ["2.0", "4.000", "7.0000"]))
        assertTrue("Integer overflow", Main.getParsingResult("10147483647 2 3 -16147483647") == new Tuple2(false, ["10147483647", "-16147483647"]))
    }

}
