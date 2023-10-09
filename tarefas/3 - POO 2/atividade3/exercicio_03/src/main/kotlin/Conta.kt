abstract class Conta(val cliente: String, protected var saldo: Double) {
    abstract fun sacar(valor: Double): String
    abstract fun depositar(valor: Double): String

    fun saldo(): Double{
        return this.saldo
    }
}