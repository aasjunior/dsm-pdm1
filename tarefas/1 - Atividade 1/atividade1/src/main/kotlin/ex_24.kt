import java.time.LocalDate
import java.time.Period
import java.time.format.DateTimeFormatter

fun main(){
    val datepattern = "([0-9]{4})[\\\\-](1[0-2]|0[1-9]|[1-9])[\\\\-](3[01]|[12][0-9]|0[1-9]|[1-9])\$".toRegex()
    val datenow: LocalDate = LocalDate.now()

    try{
        println("Digite a sua data de nascimento (yyyy-MM-dd):")
        var datebirth = readlnOrNull()
        if(datebirth != null && datebirth.matches(datepattern)){
            val age = Period.between(LocalDate.parse(datebirth), datenow)
            println("Idade: ${age.years} anos, ${age.months} meses e ${age.days} dias")
        }else{
            throw IllegalArgumentException("Data inválida")
        }
    }catch(e: Exception){
        println("Erro: $e.")
    }
}