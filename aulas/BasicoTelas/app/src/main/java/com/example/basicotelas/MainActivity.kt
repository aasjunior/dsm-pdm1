package com.example.basicotelas

import com.example.basicotelas.modelo.CalculoIdade

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val textView = findViewById<TextView>(R.id.textView)
        val editText = findViewById<EditText>(R.id.editTextText)
        val button = findViewById<Button>(R.id.button)

        button.setOnClickListener { event ->
            val idade = editText.text.toString().toInt()

            val resultado = CalculoIdade(idade).ehMaiorDeIdade()
            textView.text = when(resultado){
                true -> "Maior de idade"
                else -> "Menor de idade"
            }
        }
    }
}