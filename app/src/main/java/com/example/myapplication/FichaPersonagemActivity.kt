package com.example.myapplication

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class FichaPersonagemActivity : AppCompatActivity() {

    private lateinit var nomeTextView: TextView
    private lateinit var racaTextView: TextView
    private lateinit var descricaoTextView: TextView
    private lateinit var forcaTextView: TextView
    private lateinit var destrezaTextView: TextView
    private lateinit var constituicaoTextView: TextView
    private lateinit var inteligenciaTextView: TextView
    private lateinit var sabedoriaTextView: TextView
    private lateinit var carismaTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ficha_personagem)

        // Referenciar os TextViews
        nomeTextView = findViewById(R.id.nomeTextView)
        racaTextView = findViewById(R.id.racaTextView)
        descricaoTextView = findViewById(R.id.descricaoTextView)
        forcaTextView = findViewById(R.id.forcaTextView)
        destrezaTextView = findViewById(R.id.destrezaTextView)
        constituicaoTextView = findViewById(R.id.constituicaoTextView)
        inteligenciaTextView = findViewById(R.id.inteligenciaTextView)
        sabedoriaTextView = findViewById(R.id.sabedoriaTextView)
        carismaTextView = findViewById(R.id.carismaTextView)

        // Receber os dados passados pela Intent
        val nome = intent.getStringExtra("nome") ?: "Sem Nome"
        val raca = intent.getStringExtra("raca") ?: "Sem Raça"
        val descricao = intent.getStringExtra("descricao") ?: "Sem Descrição"
        val forca = intent.getIntExtra("forca", 8)
        val destreza = intent.getIntExtra("destreza", 8)
        val constituicao = intent.getIntExtra("constituicao", 8)
        val inteligencia = intent.getIntExtra("inteligencia", 8)
        val sabedoria = intent.getIntExtra("sabedoria", 8)
        val carisma = intent.getIntExtra("carisma", 8)

        // Exibir as informações nos TextViews
        nomeTextView.text = "Nome: $nome"
        racaTextView.text = "Raça: $raca"
        descricaoTextView.text = "Descrição: $descricao"
        forcaTextView.text = "Força: $forca"
        destrezaTextView.text = "Destreza: $destreza"
        constituicaoTextView.text = "Constituição: $constituicao"
        inteligenciaTextView.text = "Inteligência: $inteligencia"
        sabedoriaTextView.text = "Sabedoria: $sabedoria"
        carismaTextView.text = "Carisma: $carisma"
    }
}
