fun main(){
    val products = mutableListOf<Product>()

    for(i in 1..5){
        println("Digite o nome do ${i}º produto:")
        val name = readLine() ?: ""

        println("Digite a quantidade do ${i}º produto:")
        val quantity = readLine()?.toInt() ?: 0

        println("Digite o preço do ${i}º produto:")
        val price = readLine()?.toDouble() ?: 0.0

        products.add(Product(name, quantity, price))
    }
    val total: Double = products.sumOf{ it.quantity * it.price }

    println("O total gasto pela empresa é: R$ ${total}")
}
/*
data class Product(
    val name: String,
    val quantity: Int,
    val price: Double
)*/