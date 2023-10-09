class ContaPoupanca(cliente: String, saldo: Double, private var tipoConta: TipoContaPoupanca, private val config: ConfigContaBase): Conta(cliente, saldo) {
    override fun sacar(valor: Double): String {
        return when{
            (valor <= 0) -> "O valor do saque deve ser maior que zero."
            (valor <= saldo) -> {
                saldo -= valor
                "Saque de $valor realizado com sucesso."
            }
            else -> "Saldo insuficiente para o saque."
        }
    }

    override fun depositar(valor: Double): String {
        return when{
            (valor <= 0) -> "O valor do depósito deve ser maior que zero."
            else -> {
                saldo += valor
                "Depósito de $valor realizado com sucesso."
            }
        }
    }

    fun aplicarRendimento(): String{
        val rendimento: Double = calcularRendimento()
        saldo += rendimento
        return "Rendimento de R$ $rendimento aplicado com sucesso."
    }

    private fun calcularRendimento(): Double{
        return when(tipoConta){
            TipoContaPoupanca.TRADICIONAL -> {
                saldo * config.juros * config.taxaMensal
            }
            TipoContaPoupanca.ALTO_RENDIMENTO -> {
                saldo * (1 + config.juros)
            }
        }
    }
}