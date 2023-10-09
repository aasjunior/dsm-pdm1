import kotlin.NumberFormatException

fun main(){
    val products = mutableListOf<Product>()
    val productsLocked: List<Product> = products
    var x = 1

    while(true){
        println("Digite o nome do ${x}º produto (ou 0 para finalizar):")
        var name: String? = null
        while(name==null){
            try{
                name = readlnOrNull() ?: throw IllegalArgumentException("Nome obrigatório")
                if(name.isBlank()) {
                    throw IllegalArgumentException("Nome obrigatório")
                }
            }catch(e: IllegalArgumentException){
                name = null
                println("Nome obrigatório (ou digite 0 para finalizar):")
            }
        }
        if(name=="0"){
            break
        }

        println("Digite a quantidade do produto:")
        var qt: Int? = null
        while(qt==null) {
            try {
                qt = readlnOrNull()?.toInt() ?: throw NumberFormatException("Valor inválido")
                if (qt < 0) {
                    qt = null
                    throw NumberNegativeException()
                }
            } catch (e: Exception) {
                when (e) {
                    is NumberFormatException -> println("Valor inválido.\nTente novamente:")
                    is NumberNegativeException -> println("A quantidade não pode ser negativa.\nTente novamente:")
                    else -> println("Erro desconhecido.\nTente novamente:")
                }
            }
        }

        println("Digite o preço do produto:")
        var pr: Double? = null
        while(pr == null){
            try{
                pr = readlnOrNull()?.toDouble() ?: throw NumberFormatException("Valor inválido")
                if(pr < 0){
                    pr = null
                    throw NumberNegativeException()
                }
            }catch(e: Exception){
                when(e){
                    is NumberFormatException -> println("Valor inválido.\nTente novamente:")
                    is NumberNegativeException -> println("O valor não pode ser negativo.\nTente novamente:")
                    else -> println("Erro desconhecido.\nTente novamente:")
                }
            }
        }
        products.add(Product(name.trim(), qt, pr))
        x++
    }

    if(products.isEmpty()){
        println("Nenhum produto inserido")
    }else{
        val total: Double = products.sumOf { it.quantity * it.price }
        println("O total gasto pela empresa é: R$ $total")
        println(productsLocked)
    }
}

data class Product(
    val name: String,
    val quantity: Int,
    val price: Double
)

class NumberNegativeException: Exception()
/*
fun <T: Number> getValue(): T{
    var x: T? = null
    while(x == null){
        try{
            x = readLine()?.toT() ?: throw NumberFormatException("Valor inválido")
        }catch(e: NumberFormatException){
            println("Erro: quantidade inválida.\nTente novamente:")
        }
    }
    return x
}

fun <T : Number> String?.toT(): T? {
    return this?.toDoubleOrNull() as? T ?: this?.toIntOrNull() as? T
}
*/