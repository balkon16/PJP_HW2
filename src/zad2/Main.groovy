/**
 *
 * @author Lonca Paweł S23452
 *
 */

// TODO: napisać README
package zad2

import org.codehaus.groovy.GroovyException

import javax.swing.JOptionPane

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
    // TODO: co zrobić z pustymi ciągami znaków?
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

static List getData(elemType, input) {
    def result = getDataHelper(elemType, input)
    if (result[0] == true) return result[1].findAll()
    else return []
}


//myList = getDataHelper(BigDecimal, "doggie cat milk")[1]
//println(myList.every )
//println(myList.findAll())
//println(myList.findAll() { it.size() > 1 })

println(getData(Integer, "1 -100 002 3 00004 1245") {it > 1}) //To nie działa.
println(getData(Integer, "1 -100 002 3 00004 1245").findAll() {it > 1}) // To działa.


//while (true) {
//    String userInput = JOptionPane.showInputDialog("Please specify your data (separated by a whitespace):")
//    if (userInput == null) {
//        println("Closing...")
//        break
//    }
//    def parsingResult = getDataHelper(userInput)
//    if (parsingResult[0] == true) {
//        println("Your data: " + parsingResult[1])
//    } else {
//        println("Incorrect input. The following entries cannot be parsed to integers:")
//        parsingResult[1].each { println("\t" + it) }
//    }
//
//}