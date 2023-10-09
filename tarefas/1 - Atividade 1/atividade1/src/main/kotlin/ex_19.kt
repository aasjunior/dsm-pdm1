fun main(){
    val ops: MutableMap<String, Int> = mutableMapOf("A" to 0, "B" to 0, "C" to 0, "D" to 0, "E" to 0, "nulo" to 0)
    var qt = 0
    var somaidade = 0
    var idade: Int? = null
    while(true){
        var op: String? = null
        try{
            println("Digite a idade (digite um valor negativo para encerrar)")
            idade = readlnOrNull()?.toInt() ?: throw NumberFormatException("Valor inválido.")
            if(idade<0){
                break
            }
            println("Informe a opnião (A, B, C, D ou E):\nA - Ótimo\nB - Bom\nC - Regular\nD - Ruim\nE - Péssimo")
            op = readlnOrNull() ?: throw IllegalArgumentException("Nome obrigatório")
            if(op.isBlank()) {
                throw IllegalArgumentException("Opnião obrigatória.")
            }else if(op.uppercase() in ops.keys){
                ops[op.uppercase()] = ops[op.uppercase()]!! + 1
            }else{
                ops["nulo"] = ops["nulo"]!! + 1
            }
            qt++
            somaidade += idade
        }catch(e: Exception){
            println("Erro: $e.")
        }
    }
    if(qt==0){
        println("Nenhuma resposta.")
    }else{
        println("Porcentagem de respostas:")
        for((k, v) in ops){
            val porcentagem = (v.toDouble() / qt) * 100
            println("$k: ${porcentagem.toInt()}%")
        }
        println("Média de idade: ${somaidade.toDouble() / qt}")
    }
}