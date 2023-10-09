fun main() {
    val gerente = Gerente(
        nome = "João da Silva",
        sexo = Sexo.M,
        cpf = "123.456.789-00",
        salarioBase = 10000.0,
        bonus = 5000.0
    )
    val sg = gerente.sufixo

    val desenvolvedor = Desenvolvedor(
        nome = "Maria da Silva",
        sexo = Sexo.F,
        cpf = "987.654.321-00",
        salarioBase = 5000.0,
        horasTrabalhadas = 100
    )
    val dg = desenvolvedor.sufixo

    println("Salário d${sg[0]} gerente ${gerente.nome}: R$ ${gerente.calcularSalario()}")
    println("Salário d${dg[0]} desenvolved${dg[1]} ${desenvolvedor.nome}: R$ ${desenvolvedor.calcularSalario()}")
}