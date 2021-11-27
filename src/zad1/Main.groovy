/**
 *
 * @author Lonca Paweł S23452
 *
 */

package zad1

import javax.swing.JOptionPane;

static getParsingResult(String input) {
    input = input.trim()
    if (input.length() == 0) return new Tuple2(false, ["No elements specified."])

    def isSuccess = true
    def correctElements = []
    def incorrectElements = []
    input.split(/\s+/).each {
        try {
            correctElements.add(it.toInteger())
        } catch (ignored) {
            isSuccess = false
            incorrectElements.add(it)
        }
    }
    if (isSuccess) {
        return new Tuple(isSuccess, correctElements)
    }
    return new Tuple(isSuccess, incorrectElements)
}

// for the purposes of compatability with the task's instructions
static Integer[] getInts(userInput) {
    def result = getParsingResult(userInput)
    if (result[0] == true) return result[1]
    else return null
}

while (true) {
    String userInput = JOptionPane.showInputDialog("Please specify your integers (separated by a whitespace):")
    if (userInput == null) {
        println("Closing...")
        break
    }
    def parsingResult = getParsingResult(userInput)
    if (parsingResult[0] == true) {
        println("Your integers: " + parsingResult[1])
    } else {
        println("Incorrect input. The following entries cannot be parsed to integers:")
        parsingResult[1].each { println("\t" + it) }
    }

}
