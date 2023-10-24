package com.example.basicotelas.modelo

class CalculoIdade(val idade: Int) {
    fun ehMaiorDeIdade(): Boolean{
        return this.idade >= 18
    }
}