class Moto(limiteVelocidade: Int): Veiculo(limiteVelocidade) {

    override fun acelerar(): Boolean {
        return if(velocidade < limiteVelocidade){
            velocidade += 20
            true
        }else{
            false
        }
    }
}