/**
 *
 * @author Lonca Paweł S23452
 *
 */

// TODO: napisać README
package zad2

static parseInput(input, method){
    try {
        return new Tuple2(true, method(input))
    } catch (ignored) {
        println(ignored) // debug
        return new Tuple2(false, input)
    }
}


static getData(elemType = String, String input) {
    // TODO: co zrobić z pustymi ciągami znaków?
//    input = input.trim()
//    if (input.length() == 0) return new Tuple2(false, ["No elements specified."])
    def correctElements = []
    def incorrectElements = []
    def elements = input.split(/\s+/)
    switch (elemType) {
        case Integer:
            elements.each { println(parseInput(it, Integer.&valueOf))}
            println("Integer")
            break
        case BigDecimal:
            println("BigDecimal")
            break
        case String:
            print("String")
            break
        default:
            throw GroovyException("Unknown parameter value: $elemType")
    }
}

getData(Integer, "10 11 12")

//println(BigDecimal)
//println(Integer)
//println(String)


 