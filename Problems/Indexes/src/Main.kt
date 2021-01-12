fun solution(products: List<String>, product: String) {
    // put your code here
    var index = 0
    for (item in products) {
        if (item == product) {
            print("$index ")
        }
        index += 1
    }
}
