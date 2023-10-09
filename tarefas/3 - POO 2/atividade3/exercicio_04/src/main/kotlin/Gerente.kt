class Gerente(
    nome: String,
    sexo: Sexo,
    cpf: String,
    salarioBase: Double,
    val bonus: Double
) : Funcionario(nome, sexo, cpf, salarioBase) {
    override fun calcularSalario(): Double {
        return salarioBase + bonus
    }
}