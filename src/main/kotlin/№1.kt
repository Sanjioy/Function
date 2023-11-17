import kotlin.random.Random

fun main() {
    println("Добро пожаловать в игру 'Камень-Ножницы-Бумага'!")

    while (true) {
        println("Выберите свой вариант:")
        println("1 - Камень")
        println("2 - Ножницы")
        println("3 - Бумага")
        println("0 - Выход из игры")

        val Player = readLine()?.toIntOrNull()!!

        if (Player !in 0..3) {
            println("Неверный выбор, попробуйте еще раз.")
            continue
        }

        if (Player == 0) {
            println("Игра завершена.")
            break
        }

        val Computer = Random.nextInt(1, 4)

        println("Компьютер выбрал: ${getChoiceName(Computer)}")
        println("Вы выбрали: ${getChoiceName(Player)}")

        val Result = getResult(Player, Computer)
        when (Result) {
            0 -> println("Ничья!")
            1 -> println("Вы победили!")
            -1 -> println("Вы проиграли!")
        }

        println()
    }
}

fun getChoiceName(Choice: Int): String {
    return when (Choice) {
        1 -> "Камень"
        2 -> "Ножницы"
        3 -> "Бумага"
        else -> "Неверный выбор"
    }
}

fun getResult(Player: Int, Computer: Int): Int {
    if (Player == Computer) {
        return 0 // Ничья
    }

    return when (Player) {
        1 -> if (Computer == 2) 1 else -1
        2 -> if (Computer == 3) 1 else -1
        3 -> if (Computer == 1) 1 else -1
        else -> 0
    }
}
