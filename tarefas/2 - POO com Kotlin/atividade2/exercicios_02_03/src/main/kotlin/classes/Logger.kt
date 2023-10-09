package classes

import java.io.File
import java.io.FileWriter
import java.time.LocalDateTime

enum class LogLevel{
    ERROR,
    WARNING,
    INFO
}

abstract class Logger {
    /* abstract class: não pode ser utilizada diretamente. Usada como modelo para outras classes;
    *  abstract fun: método definido em uma classe abstrata e implementado na subclasse (FileLogger);
    *  LogLevel: enum que representa os níveis de gravidade de uma mensagem de log (ERROR, WARNING, INFO).
    */
    abstract fun log(level: LogLevel, message: String?)

    fun error(message: String?){
        log(LogLevel.ERROR, message)
    }

    fun warning(message: String?){
        log(LogLevel.WARNING, message)
    }

    fun info(message: String?){
        log(LogLevel.INFO, message)
    }
}

class FileLoger: Logger() {
    /* subclasse que cria um arquivo com o registro das mensagens de log de erro;
    *  override fun:  substitui a implementação de um método ou propriedade da superclasse (Logger)
    */
    private val fileLog = File("src/log.txt")
    private var message: String? = ""
    private val datenow: LocalDateTime = LocalDateTime.now()

    fun getMessage(): String?{
        return this.message
    }

    fun setMessage(message: String?){
        this.message = message
    }

    override fun log(level: LogLevel, message: String?){
        this.setMessage(message)
        val writer = FileWriter(fileLog, true)
        writer.write("${this.datenow}\n${level.name}: ${message}\n")
        writer.close()
    }
}