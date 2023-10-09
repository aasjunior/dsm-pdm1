class ContaCorrente(cliente: String, saldo: Double, private var tipoConta: TipoContaCorrente, private val config: ConfigContaBase): Conta(cliente, saldo){
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

    fun cobrarTarifa(): String{
        val calculo: Boolean = calcularTarifa()
        val msg: String = when(tipoConta){
            TipoContaCorrente.SIMPLES -> {
                "Tarifa de manutenção cobrada: ${config.taxaMensal}"
            }
            TipoContaCorrente.ESPECIAL -> {
                "Tarifa de manutenção e juros cobrados: ${config.taxaMensal} + ${config.juros}"
            }
        }
        return if(calculo){
                msg
            }else{
                "Conta isenta de tarifa de manutenção este mês."
            }
    }

    private fun calcularTarifa(): Boolean{
        return if(saldo < config.saldoMinimo){
                saldo -= config.taxaMensal
                saldo -= config.juros
                true
            }else{
                false
            }
    }
}