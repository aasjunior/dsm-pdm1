package classes

class PortaAbertaException(message: String) : Exception(message)
class PortaFechadaException(message: String) : Exception(message)
class CorNaoInserida(message: String) : Exception(message)
class CorJaInserida(message: String) : Exception(message)

class Porta{
    private var aberta: Boolean = false
    private var cor: String = ""
    private var altura: Float = 0.0f
    private var largura: Float = 0.0f
    val logger = FileLoger()

    constructor(aberta: Boolean, cor: String, altura: Float, largura: Float){
        this.aberta = aberta
        this.cor = cor
        this.altura = altura
        this.largura = largura
    }

    private fun getAberta(): Boolean{
        return this.aberta
    }

    private fun setAberta(aberta: Boolean){
        this.aberta = aberta
    }

    fun getCor(): String{
        return this.cor
    }

    private fun setCor(cor: String){
        this.cor = cor.lowercase()
    }

    fun getAltura(): Float{
        return this.altura
    }

    fun setAltura(altura: Float){
        this.altura = altura
    }

    fun getLargura(): Float{
        return this.largura
    }

    fun setLargura(largura: Float){
        this.largura = largura
    }

    fun abrir(){
        if(this.getAberta()){
            throw PortaAbertaException("A porta já estava aberta.")
        }else{
            this.setAberta(true)
        }
    }

    fun fechar(){
        if(this.getAberta()){
            this.setAberta(false)
        }else{
            throw PortaFechadaException("A porta já estava fechada.")
        }
    }

    fun estaAberta(): Boolean = this.getAberta()

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
}