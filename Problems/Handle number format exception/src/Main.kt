fun parseCardNumber(cardNumber: String): Long {
    // TODO
    val toLong:String
    if (cardNumber[4] != ' ' || cardNumber[9] != ' ' || cardNumber[14] != ' ') {
        throw Exception("Space not at index, 4,9, or 14")
    } else {
        toLong = cardNumber.filter { it.isDigit() }
    }
    if (toLong.length != 16) {
        throw Exception("16 digits needed")
    }
    return toLong.toLong()

}

