package com.example.projetobasico

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        /*
         * A variável `savedInstanceState` guarda informações do
         * estado da Activity, guarda quais	 componentes estão na tela e
         * informações que o usuário tenha preenchido.
        */

        super.onCreate(savedInstanceState)
        val tex = findViewById<TextView>("textView")

        // os recursos contidos na pasta `res` são tornados em atributos em tempo de compilação (metaprogramação)
        setContentView(R.layout.activity_main)
    }
}