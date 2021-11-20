/**
 *
 * @author Lonca Paweł S23452
 *
 */

// TODO: napisać README
// TODO: regex do znajdowania niepasujących elementów (np. findAll z !\d+)
package zad1

import javax.swing.JOptionPane;

// TODO: zakres INT to od -2,147,483,648 do 2,147,483,647. Obecnie akceptuje wszystkie.

static boolean isValidInput(String input) {
    def pattern = /^(-?\d+ ?)+$/
    if ((input == '') | (input == null)) return false
    return input.trim() ==~ pattern
}

static getInts(String input) {
    return input.split(' ')*.toInteger()
}


while (true) {
    String userInput = JOptionPane.showInputDialog("Please specify your integers (separated by a whitespace):")
    if (isValidInput(userInput)) {
        println(getInts(userInput.trim()))
    } else {
        def msgOnFail = '''Provided incorrect input. Typical incorrect cases:
> other than integer numeric types, e.g. 10.5, 7.12, 0.555, -10.12, -5,125, 9.156
> strings, e.g. "my string", "my_string_with_underscores", "false"'''

        JOptionPane.showMessageDialog(null, msgOnFail)
    }

    if (userInput == null) {
        println("Closing...")
        break
    }
//    def parsedInput = validateAndTransformUserInput(productPrice)
//    if (parsedInput[0]) {
//        def productName = parsedInput[1][0]
//        productsSummary[productName] = productsSummary.get(productName, 0) + parsedInput[1][1]
//    }

}
