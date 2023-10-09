package classes

class NumberNegativeException(message: String): Exception(message)

class SquareDrawer{
    private fun setSide(side: Int): Boolean{
        if(side>=0){
            return true
        }else{
            throw NumberNegativeException("Número inválido. O número deve ser positivo")
        }
    }

    fun drawSquare(side: Int){
        if(setSide(side)){
            repeat(side){
                print("*".repeat(side))
                println()
            }
            println()
        }
    }

    fun drawSquare(side: Int, fillCharacter: Char){
        if(setSide(side)){
            repeat(side){
                print(fillCharacter.toString().repeat(side))
                println()
            }
            println()
        }
    }
}