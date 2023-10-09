sealed class CriacaoConta{
    // subclasse da classe selada para retornar o sucesso na criação da conta
    data class Sucesso(val conta: Conta): CriacaoConta()

    // Objeto único que representa a ação de sair
    data object Sair: CriacaoConta()
}

fun main() {
    val listaClientes: MutableList<Conta> = mutableListOf()
    val config = ConfigContaBase(10.0, 100.0, 0.01)

    try {
        // loop@ -> rotulo para referenciar o while
        loop@ while(true){
            println("Selecione uma opção:\n1 - Criar Conta\n2 - Depositar\n3 - Sacar\n4 - Mostrar Saldo\n5 - Testes\n0 - Sair")
            when(readlnOrNull()?.toInt()){
                1 -> when(val resultado = criarConta(config)){
                    is CriacaoConta.Sucesso -> listaClientes.add(resultado.conta)
                    CriacaoConta.Sair -> {
                        println("Encerrando")
                        break@loop // Encerra o loop
                    }
                }
                2 -> {
                    val msg = depositar(listaClientes)
                    println(msg)
                }
                3 -> {
                    val msg = sacar(listaClientes)
                    println(msg)
                }
                4 -> println(exibirSaldo(listaClientes))
                5 -> {
                    // Chama funções de teste
                    println("\nCorrente:")
                    testContaCorrente()
                    println("\nPoupança:")
                    testContaPoupanca()
                    break@loop
                }
                0 -> {
                    println("Encerrando")
                    break@loop // Encerra o loop
                }
                else -> throw IllegalArgumentException("Opção inválida.")
            }
        }
    }catch(e: IllegalArgumentException){
        println(e.message)
    }catch(e: Exception){
        println("Ocorreu um erro:\n${e.message}")
    }

}

fun exibirSaldo(listaClientes: MutableList<Conta>): String{
    println("Digite o nome do cliente:")
    val cliente = readlnOrNull()
    val conta = listaClientes.find { it.cliente == cliente }

    return if(conta != null){
            "Saldo atual: R$ ${conta.saldo()}"
        }else{
            "Conta não localizada."
        }
}

fun depositar(listaClientes: MutableList<Conta>): String{
    println("Digite o nome do cliente:")
    val cliente = readlnOrNull()
    val conta = listaClientes.find { it.cliente == cliente }

    return if(conta != null){
            println("Digite o valor para o deposito")
            conta.depositar(readlnOrNull()!!.toDouble())
        }else{
            "Conta não localizada."
        }
}

fun sacar(listaClientes: MutableList<Conta>): String{
    println("Digite o nome do cliente:")
    val cliente = readlnOrNull()
    val conta = listaClientes.find { it.cliente == cliente }

    return if(conta != null){
        println("Digite o valor para realizar o saque")
        conta.sacar(readlnOrNull()!!.toDouble())
    }else{
        "Conta não localizada."
    }
}

fun criarConta(config: ConfigContaBase): CriacaoConta{
    println("Digite o nome do cliente")
    val cliente = readlnOrNull() ?: "John Doe"

    println("Digite o saldo inicial")
    val saldo = readlnOrNull()?.toDouble() ?: 0.0

    println("Selecione o tipo de conta:\n1 - Conta Corrente\n2 - Conta Poupança\n0 - Sair")
    return when(readlnOrNull()?.toInt()){
        1 -> {
            println("Qual o tipo de conta corrente:\n1 - Simples\n2 - Especial\n0 - Sair")
            when(readlnOrNull()?.toInt()){
                1 -> CriacaoConta.Sucesso(
                    ContaCorrente(cliente, saldo, TipoContaCorrente.SIMPLES, config)
                )
                2 -> CriacaoConta.Sucesso(
                    ContaCorrente(cliente, saldo, TipoContaCorrente.ESPECIAL, config)
                )
                0 -> CriacaoConta.Sair
                else -> throw IllegalArgumentException("Valor inserido para tipo de conta corrente inválido")
            }
        }
        2 -> {
            println("Qual o tipo de conta poupança:\n1 - Tradicional\n2 - Alto Rendimento\n0 - Sair")
            when(readlnOrNull()?.toInt()){
                1 -> CriacaoConta.Sucesso(
                    ContaPoupanca(cliente, saldo, TipoContaPoupanca.TRADICIONAL, config)
                )
                2 -> CriacaoConta.Sucesso(
                    ContaPoupanca(cliente, saldo, TipoContaPoupanca.ALTO_RENDIMENTO, config)
                )
                0 -> CriacaoConta.Sair
                else -> throw IllegalArgumentException("Valor inserido para tipo de conta corrente inválido")
            }
        }
        0 -> CriacaoConta.Sair
        else -> throw IllegalArgumentException("Valor informado para tipo de conta inválido.")
    }
}
fun testContaCorrente() {
    val config = ConfigContaBase(10.0, 1000.0, 0.01)
    val contaCorrenteSimples = ContaCorrente("Cliente1", 500.0, TipoContaCorrente.SIMPLES, config)
    val contaCorrenteEspecial = ContaCorrente("Cliente2", 1000.0, TipoContaCorrente.ESPECIAL, config)

    println(contaCorrenteSimples.cliente)
    println(contaCorrenteSimples.depositar(500.0)) // Deve imprimir "Depósito de 200.0 realizado com sucesso."
    println(contaCorrenteSimples.cobrarTarifa()) // Deve imprimir "Conta isenta de tarifa de manutenção este mês."
    println(contaCorrenteSimples.saldo())
    println(contaCorrenteEspecial.cliente)
    println(contaCorrenteEspecial.sacar(800.0)) // Deve imprimir "Saque de 800.0 realizado com sucesso."
    println(contaCorrenteEspecial.cobrarTarifa()) // Deve imprimir "Tarifa de manutenção e juros cobrados: 10.0 + 0.01"
    println(contaCorrenteEspecial.saldo())
}

fun testContaPoupanca() {
    val config = ConfigContaBase(10.0, 100.0, 0.01)
    val contaPoupancaTradicional = ContaPoupanca("Cliente3", 1000.0, TipoContaPoupanca.TRADICIONAL, config)
    val contaPoupancaAltoRendimento = ContaPoupanca("Cliente4", 2000.0, TipoContaPoupanca.ALTO_RENDIMENTO, config)

    println(contaPoupancaTradicional.cliente)
    println(contaPoupancaTradicional.depositar(500.0)) // Deve imprimir "Depósito de 500.0 realizado com sucesso."
    println(contaPoupancaTradicional.aplicarRendimento()) // Deve imprimir "Rendimento de R$ 5.0 aplicado com sucesso."
    println(contaPoupancaTradicional.saldo())
    println(contaPoupancaAltoRendimento.cliente)
    println(contaPoupancaAltoRendimento.sacar(1500.0)) // Deve imprimir "Saque de 1500.0 realizado com sucesso."
    println(contaPoupancaAltoRendimento.aplicarRendimento()) // Deve imprimir "Rendimento de R$ 40.0 aplicado com sucesso."
    println(contaPoupancaAltoRendimento.saldo())
}
