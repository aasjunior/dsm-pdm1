import classes.Porta

fun main(){
    val porta1 = Porta(false, "preto", 2f, 1.3f)

    try{
        porta1.abrir()
        var estado = if(porta1.estaAberta()) "aberta" else "fechada"
        println("A porta está $estado")

        porta1.fechar()
        estado = if(porta1.estaAberta()) "aberta" else "fechada"
        println("A porta está $estado")

        porta1.pintar("azul")
        println("A cor da porta é ${porta1.getCor()}")

        porta1.pintar("vermelho")
        println("A cor da porta é ${porta1.getCor()}")

        porta1.setAltura(2.5f)
        println("A altura da porta é ${porta1.getAltura()}")

        porta1.setLargura(1.5f)
        println("A largura da porta é ${porta1.getLargura()}")
    }catch(e: Exception){
        println(e.message)
        porta1.logger.error(e.message)
    }
}