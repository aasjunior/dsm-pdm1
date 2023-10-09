package classes

class Casa(private var cor: String, val porta1: Porta, val porta2: Porta, val porta3: Porta){
    fun getCor(): String{
        return this.cor
    }

    private fun setCor(cor: String){
        this.cor = cor
    }

    fun pintar(cor: String){
        if(cor.isBlank()){
            throw CorNaoInserida("A cor da porta não pode ser vazia.")
        }
        if(cor.lowercase() == this.getCor()){
            throw CorJaInserida("A cor da porta já era ${cor.lowercase()}.")
        }else{
            this.setCor(cor.lowercase())
        }
    }

    fun quantasPortasEstaoAbertas(): Int{
        var portasAbertas = 0
        if(this.porta1.estaAberta()) portasAbertas++
        if(this.porta2.estaAberta()) portasAbertas++
        if(this.porta3.estaAberta()) portasAbertas++

        return portasAbertas
    }

}
