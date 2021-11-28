package zad2.tests.unit

import groovy.test.GroovyTestCase
import zad2.Main

class GetDataCase extends GroovyTestCase {
    void testAssertion() {
        // Integer
        assertTrue(Main.getData("1 2 3 4  5 -1 -8", Integer) == [1, 2, 3, 4, 5, -1, -8])
        assertTrue(Main.getData("1 2 3 4  5 -1 -8", Integer) { it > 3 } == [4, 5])
        assertTrue(Main.getData("1 2 3 4  5 -1 -8", Integer) { it > 10 } == [])
        assertTrue(Main.getData("abc 1 10 15", Integer) == null)
        assertTrue(Main.getData("   ", Integer) == null)

        // BigDecimal
        assertTrue(Main.getData("1.02 -1.52532 2.5", BigDecimal) ==
                [new BigDecimal("1.02"), new BigDecimal("-1.52532"), new BigDecimal("2.5")])
        assertTrue(Main.getData("1.02 -1.52532 2.5", BigDecimal) { it > new BigDecimal("0.11") } ==
                [new BigDecimal("1.02"), new BigDecimal("2.5")])
        assertTrue(Main.getData("1.02 -1.52532 2.5", BigDecimal) { it > new BigDecimal("1000") } == [])
        assertTrue(Main.getData("abc 1.01 10 15", BigDecimal) == null)

        // String
        assertTrue(Main.getData("dog cat bird apple") == ["dog", "cat", "bird", "apple"])
        assertTrue(Main.getData("Ala ma kota") { it.size() > 1 } == ["Ala", "ma", "kota"])
        assertTrue(Main.getData("dog cat bird apple") { it.size() >= 4 } == ["bird", "apple"])
        assertTrue(Main.getData("abc") == ["abc"])
        assertTrue(Main.getData("   ") == null)

    }

}
