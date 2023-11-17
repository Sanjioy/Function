fun main() {
    val InputMessage = "ШИФРВИЖЕНЕР"
    val InputKey = "КОД"

    val EncryptedMessage =EncryptVigenere(InputMessage, InputKey)
    println("Зашифрованное сообщение: $EncryptedMessage")
}

fun EncryptVigenere(Message: String, InputKey: String): String {
    val Alphabet = "АБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯ"
    val EncryptedMessage = StringBuilder()

    for (i in Message.indices) {
        val MessageChar = Message[i]
        val KeyChar = InputKey[i % InputKey.length] //возвращает остаток от деления индекса символа в ключе на длину ключа
        val MessageCharIndex = Alphabet.indexOf(MessageChar) //индекс символа в алфавите; метод indexOf() возвращает индекс первого вхождения символа в строке
        val KeyCharIndex = Alphabet.indexOf(KeyChar) //индекс символа в ключе

        if (MessageCharIndex != -1) {
            val EncryptedCharIndex = (MessageCharIndex + KeyCharIndex) % Alphabet.length //индекс зашифрованного символа в алфавите
            val EncryptedChar = Alphabet[EncryptedCharIndex] //зашифрованный символ
            EncryptedMessage.append(EncryptedChar) //добавляет зашифрованный символ к зашифрованному сообщению
        } else {
            EncryptedMessage.append(MessageChar) //добавляет текущую букву сообщения к переменной `encryptedMessage` без шифрования
        }
    }

    return EncryptedMessage.toString()
}
