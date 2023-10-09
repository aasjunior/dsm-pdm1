import classes.Porta
import classes.Casa

fun main(){
    val porta1 = Porta(false, "preto", 2f, 1.3f)
    val porta2 = Porta(false, "branco", 2f, 1.3f)
    val porta3 = Porta(false, "vermelho", 2f, 1.3f)

    val casa1 = Casa("azul", porta1, porta2, porta3)

    try{
        casa1.pintar("amarelo")
        println("A cor da casa é ${casa1.getCor()}")

        casa1.porta1.setAltura(2.5f)
        println("A altura da primeira porta é ${casa1.porta1.getAltura()}")

        casa1.porta2.setLargura(1.8f)
        println("A largura da segunda porta é ${casa1.porta1.getLargura()}")

        casa1.porta3.pintar("verde")
        println("A cor da terceira porta é ${casa1.porta1.getCor()}")

        casa1.porta1.abrir()
        casa1.porta2.abrir()
        casa1.porta3.abrir()
        casa1.porta2.fechar()

        println("O número de portas abertas é ${casa1.quantasPortasEstaoAbertas()}")

    }catch(e: Exception){
        println(e.message)
        porta1.logger.error(e.message)
    }
}