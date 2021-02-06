fun main() {
    fun totalPrice(price: Int, type: String): Double {
        val tax = when (type) {
            "headphones" -> 1.11
            "smartphone" -> 1.15
            "tv" -> 1.17
            "laptop" -> 1.19
            else -> 1.0
        }

        return price.toDouble() * tax
    }
    val productType = readLine()!!
    val price = readLine()!!.toInt()
    val product = Product(price)
    println(totalPrice(product.price, productType).toInt())
}

data class Product(val price: Int)
