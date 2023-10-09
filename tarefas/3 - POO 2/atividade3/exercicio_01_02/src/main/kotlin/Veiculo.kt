abstract class Veiculo(val limiteVelocidade: Int) {
    var velocidade: Int = 0
    abstract fun acelerar(): Boolean
}