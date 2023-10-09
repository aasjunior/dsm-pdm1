fun main() {
    val carro = Carro(180)
    val moto = Moto(220)

    while(carro.acelerar()){
        println("Carro Acelerando. Velocidade: ${carro.velocidade}")
    }

    while(moto.acelerar()){
        println("Moto Acelerando. Velocidade: ${moto.velocidade}")
    }
}