abstract class Funcionario(
    val nome: String,
    val sexo: Sexo,
    protected val cpf: String,
    protected val salarioBase: Double
) {
    val sufixo: List<String> = if(sexo == Sexo.F) SufixoGenero.feminino else SufixoGenero.masculino
    abstract fun calcularSalario(): Double
}