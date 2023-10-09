import classes.SquareDrawer

fun main(){
    val squareDrawer = SquareDrawer()

    try{
        println("Digite o número de lados para o quadrado de asteriscos:")
        squareDrawer.drawSquare(readlnOrNull()!!.toInt())

        println("Digite o caractere para formar o quadrado que será impresso na tela: ")
        val c: Char = readlnOrNull()!!.single()

        println("Digite o número de lados para o quadrado:")
        squareDrawer.drawSquare(readlnOrNull()!!.toInt(), c)
    }catch(e: NumberFormatException){
        println("Valor inválido.\nErro: $e")
    }catch(e: IllegalArgumentException){
        println("Sequência de caracteres inválida. Deve ser inserido somente um caractere.\nErro: $e")
    }catch(e: Exception){
        println("${e.message}\nErro: $e")
    }
}