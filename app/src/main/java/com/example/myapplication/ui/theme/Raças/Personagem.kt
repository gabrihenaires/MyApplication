package Raças

import android.content.Context
import android.widget.Toast

class Personagem(
    val nome: String,
    val raca: Raca,
    val descricao: String,
    val habilidadesComBonus: Map<String, Int>,
    val modificadoresHabilidade: Map<String, Int>,
    val habilidadesFinais: Map<String, Int>,
    val pontosDeVida: Int
) {
    fun exibirInfo(context: Context) {
        val info = """
            --- Ficha do Personagem ---
            Nome: $nome
            Raça: ${raca.javaClass.simpleName}
            Descrição: $descricao
            Habilidades com Bônus: $habilidadesComBonus
            Modificadores de Habilidade: $modificadoresHabilidade
            Habilidades Finais: $habilidadesFinais
            Pontos de Vida: $pontosDeVida
        """.trimIndent()

        Toast.makeText(context, info, Toast.LENGTH_LONG).show()
    }
}