/**
 *
 * @author Lonca Paweł S23452
 *
 */

package zad2

import org.codehaus.groovy.GroovyException

static parseInput(input, method) {
    input = input.split(/\s+/)
    def correctElements = []
    def incorrectElements = []
    def success = true
    input.each {
        try {
            correctElements.add(method(it))
        } catch (ignored) {
            success = false
            incorrectElements.add(it)
        }
    }
    return new Tuple3(success, correctElements, incorrectElements)
}


static getDataHelper(elemType = String, String input) {
    input = input.trim()
    if (input.length() == 0) return new Tuple2(false, ["No elements specified."])
    def parsingResult
    switch (elemType) {
        case Integer:
            parsingResult = parseInput(input, Integer.&valueOf)
            break
        case BigDecimal:
            parsingResult = parseInput(input, BigDecimal::new)
            break
        case String:
            parsingResult = parseInput(input, String::new)
            break
        default:
            throw new GroovyException("Unknown parameter value: $elemType")
    }
    return new Tuple2(parsingResult[0], (parsingResult[0]) ? parsingResult[1] : parsingResult[2])
}

static getData(String input, Object elemType = String, Closure<Boolean> booleanClosure = { true }) {
    if (elemType instanceof Closure) {
        booleanClosure = elemType
        elemType = String
    }
    def result = getDataHelper(elemType, input)
    if (result[0] == true) return result[1].findAll(booleanClosure)
    else return null
}

def integerInput = "1 10 001 -102 -0005"
def stringInput = "abba ghij def"
def bigDecimalInput = "1.0 -15.1 1 301.2 001"
println getData(integerInput, Integer) { it > 0 }
println getData(stringInput) { it.size() > 3 }
println getData(stringInput)
println getData(bigDecimalInput, BigDecimal)