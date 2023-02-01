fun main() {
    val options = arrayOf("Камень", "Ножницы", "Бумага")
    val gameChoice = getGameChoice(options)
    val userChoice = getUserChoice(options)
    printResult(userChoice, gameChoice)
}

fun getGameChoice(optionsParam: Array<String>) =
    optionsParam[(Math.random() * optionsParam.size).toInt()]

fun getUserChoice(optionsParam: Array<String>): String {
    var isValidChoice = false
    var userChoice = ""
    //цикл пока юзер не введет нужный выбор
    while (!isValidChoice) {
        //Ask the user for their choice
        print("Пожалуйста выберите нужный вариант:")
        for (item in optionsParam) print(" $item")
        println(".")
        //прочитать ввод юзера
        val userInput = readlnOrNull()
        //применить ввод юзера
        if (userInput != null && userInput in optionsParam) {
            isValidChoice = true
            userChoice = userInput
        }
        //если выбор неверный, оповестить
        if (!isValidChoice) println("Неправильный ввод")
    }
    return userChoice
}

fun printResult(userChoice: String, gameChoice: String) {
    //вывод результата
    val result: String = if (userChoice == gameChoice) "Ничья О_О"
    else if ((userChoice == "Камень" && gameChoice == "Ножницы") ||
        (userChoice == "Бумага" && gameChoice == "Камень") ||
        (userChoice == "Ножницы" && gameChoice == "Бумага")) "Вы выиграли!"
    else "Вы проиграли"
    //принт результата
    println("Вы выбрали $userChoice. Я выбрал $gameChoice. $result")
}