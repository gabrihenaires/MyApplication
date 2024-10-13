package com.example.myapplication

import Raças.Raca
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import Raças.*

class RacaSelecaoActivity : AppCompatActivity() {

    private lateinit var editTextNome: EditText
    private lateinit var spinnerRaca: Spinner
    private lateinit var textViewBonus: TextView
    private lateinit var editTextDescricao: EditText
    private lateinit var buttonProximo: Button

    private var racaSelecionada: Raca? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_raca_selecao)

        editTextNome = findViewById(R.id.editTextNome)
        spinnerRaca = findViewById(R.id.spinnerRaca)
        textViewBonus = findViewById(R.id.textViewBonusRaca)
        editTextDescricao = findViewById(R.id.editTextDescricao)
        buttonProximo = findViewById(R.id.buttonProximo)

        // Lista de raças
        val racas = listOf("Humano", "Elfo", "Anão", "Draconato", "Tiefling", "Gnomo", "Meio-Orc", "Meio-Elfo", "Halfing")

        // Adapter para o Spinner de raças
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, racas)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinnerRaca.adapter = adapter

        spinnerRaca.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View?, position: Int, id: Long) {
                val racaNome = parent.getItemAtPosition(position).toString()
                racaSelecionada = getRacaByName(racaNome)
                // Exibir bônus da raça no TextView programaticamente
                textViewBonus.text = "Bônus de Habilidade: ${racaSelecionada?.bonusHabilidades}"
            }

            override fun onNothingSelected(parent: AdapterView<*>) {
                // Nada selecionado
            }
        }

        buttonProximo.setOnClickListener {
            val nomePersonagem = editTextNome.text.toString()
            val descricao = editTextDescricao.text.toString()

            if (nomePersonagem.isNotEmpty() && racaSelecionada != null) {
                // Passa os dados para a próxima tela
                val intent = Intent(this, DistribuicaoHabilidadesActivity::class.java)
                intent.putExtra("nomePersonagem", nomePersonagem)
                intent.putExtra("racaSelecionada", racaSelecionada?.javaClass?.simpleName)
                intent.putExtra("bonusRaca", racaSelecionada?.bonusHabilidades.toString())
                intent.putExtra("descricao", descricao)
                startActivity(intent)
            } else {
                // Tratar caso o nome ou a raça não seja selecionada
                editTextNome.error = "Digite o nome do personagem"
            }
        }
    }

    // Função para mapear a raça com base no nome
    // Função para mapear a raça com base no nome
    private fun getRacaByName(nome: String): Raca {
        return when (nome) {
            "Gnomo das Rochas" -> gnomoRochas()
            "Alto Elfo" -> altoElfo()
            "Anão" -> anao()
            "Anão da Colina" -> anaoColina()
            "Anão da Montanha" -> anaoMontanha()
            "Draconato" -> draconato()
            "Drow" -> drow()
            "Elfo" -> elfo()
            "Elfo da Floresta" -> elfoFloresta()
            "Gnomo" -> gnomo()
            "Gnomo da Floresta" -> gnomoFloresta()
            "Halfing" -> halfing()
            "Halfing Pés Leves" -> halfingPesLeves()
            "Halfing Robusto" -> halfingRobusto()
            "Humano" -> humano()
            "Meio Elfo" -> meioElfo()
            "Meio Orc" -> meioOrc()
            "Tiefling" -> tiefling()
            else -> humano() // Caso padrão
        }
    }

}
