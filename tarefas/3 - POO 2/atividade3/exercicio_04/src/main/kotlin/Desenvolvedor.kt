class Desenvolvedor(
    nome: String,
    sexo: Sexo,
    cpf: String,
    salarioBase: Double,
    val horasTrabalhadas: Int
) : Funcionario(nome, sexo, cpf, salarioBase) {
    override fun calcularSalario(): Double {
        return salarioBase + horasTrabalhadas * 100
    }
}