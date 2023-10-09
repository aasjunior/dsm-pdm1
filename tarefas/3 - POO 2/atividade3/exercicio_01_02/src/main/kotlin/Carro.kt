class Carro(limiteVelocidade: Int): Veiculo(limiteVelocidade) {
    override fun acelerar(): Boolean {
        return if(velocidade < limiteVelocidade){
            velocidade += 10
            true
        }else{
            false
        }
    }
}