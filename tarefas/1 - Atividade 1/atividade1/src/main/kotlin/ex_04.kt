import java.time.LocalDate
import kotlin.random.Random

fun main(){
    val hoursWorked = hours_worked()

    println("Digite o nome do funcionário:")
    var name: String? = null
    while(name==null){
        try{
            name = readlnOrNull() ?: throw IllegalArgumentException("Nome obrigatório")
            if(name.isBlank()) {
                throw IllegalArgumentException("Nome obrigatório")
            }
        }catch(e: IllegalArgumentException){
            name = null
            println("Nome obrigatório:")
        }
    }
    val func = Funcionario(name, (hoursWorked.values.sum()))

    println("Nome Funcionário: ${func.name}\nTotal de horas trabalhadas: ${func.hoursMonthly}\nSalário bruto: R$ ${func.grossSalary}")

    //get_hours_worked(hoursWorked)
}

data class Funcionario(val name: String = "", val hoursMonthly: Int = 0, val grossSalary: Double = 10.0 * hoursMonthly)

fun hours_worked(): Map<LocalDate, Int>{
    val hoursWorked = mutableMapOf<LocalDate, Int>()
    val hoursWorkedLocked: Map<LocalDate, Int> = hoursWorked

    for(i in 1..30){
        val hoursDaily = Random.nextInt(8, 12)

        hoursWorked[LocalDate.now().plusDays(i.toLong())] = hoursDaily
    }

    return hoursWorkedLocked
}

fun get_hours_worked(hoursWorked: Map<LocalDate, Int>){
    println("Registro de horas trabalhadas diarias:")
    hoursWorked.forEach{ key, value ->
        println("$key -> $value")
    }
}