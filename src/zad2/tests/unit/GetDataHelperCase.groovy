package zad2.tests.unit

import groovy.test.GroovyTestCase
import zad2.Main
class GetDataHelperCase extends GroovyTestCase {
    void testAssertions() {
        // Integer - correct cases
        assertTrue("All correct entries - typical integers", Main.getDataHelper(Integer, "1 2 3 4") == new Tuple2(true, [1, 2, 3, 4]))
        assertTrue("All correct entries - various spacing", Main.getDataHelper(Integer, "1   2  3 4") == new Tuple2(true, [1, 2, 3, 4]))
        assertTrue("Weird looking integers", Main.getDataHelper(Integer, "001 2 000003 404") == new Tuple2(true, [1, 2, 3, 404]))
        assertTrue("Negative integers", Main.getDataHelper(Integer, "-1 2 -3 4 -0005") == new Tuple2(true, [-1, 2, -3, 4, -5]))

        // Integer - incorrect cases
        assertTrue("Strings are not accepted", Main.getDataHelper(Integer, "1 dog 2 apple") == new Tuple2(false, ["dog", "apple"]))
        assertTrue("Empty sequence", Main.getDataHelper(Integer, "") == new Tuple2(false, ["No elements specified."]))
        assertTrue("Empty sequence", Main.getDataHelper(Integer, " ") == new Tuple2(false, ["No elements specified."]))
        assertTrue("Empty sequence", Main.getDataHelper(Integer, "     ") == new Tuple2(false, ["No elements specified."]))
        assertTrue("Floats with zero decimal part", Main.getDataHelper(Integer, "001 2.0 3 4.000 7.0000") == new Tuple2(false, ["2.0", "4.000", "7.0000"]))
        assertTrue("Integer overflow", Main.getDataHelper(Integer, "10147483647 2 3 -16147483647") == new Tuple2(false, ["10147483647", "-16147483647"]))

        // BigDecimal - correct cases
        assertTrue("All correct entries - typical BigDecimal cases", Main.getDataHelper(BigDecimal, "1.01    2532153126143261464123623623.1543522436 -30           4")
                == new Tuple2(true, [new BigDecimal("1.01"), new BigDecimal("2532153126143261464123623623.1543522436"), new BigDecimal("-30"), new BigDecimal("4")]))
        assertTrue("Weird looking integers", Main.getDataHelper(BigDecimal, "001.51  -2    000003")
                == new Tuple2(true, [new BigDecimal("1.51"), new BigDecimal(-2), new BigDecimal(3)]))

        // BigDecimal - incorrect cases
        assertTrue("Strings are not accepted", Main.getDataHelper(BigDecimal, "1 dog 2 apple") == new Tuple2(false, ["dog", "apple"]))
        assertTrue("Empty sequence", Main.getDataHelper(BigDecimal, "") == new Tuple2(false, ["No elements specified."]))
        assertTrue("Empty sequence", Main.getDataHelper(BigDecimal, " ") == new Tuple2(false, ["No elements specified."]))
        assertTrue("Empty sequence", Main.getDataHelper(BigDecimal, "     ") == new Tuple2(false, ["No elements specified."]))

        // String - correct cases
        assertTrue("Strings", Main.getDataHelper("abc def GHI 123") == new Tuple2(true, ["abc", "def", "GHI", "123"]))

        // String - incorrect cases
        assertTrue("Empty sequence", Main.getDataHelper(String, "") == new Tuple2(false, ["No elements specified."]))
        assertTrue("Empty sequence", Main.getDataHelper(String, " ") == new Tuple2(false, ["No elements specified."]))
        assertTrue("Empty sequence", Main.getDataHelper(String, "     ") == new Tuple2(false, ["No elements specified."]))
    }
}
