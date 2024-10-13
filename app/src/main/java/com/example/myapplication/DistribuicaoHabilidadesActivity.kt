package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class DistribuicaoHabilidadesActivity : AppCompatActivity() {

    private var forca = 8
    private var destreza = 8
    private var constituicao = 8
    private var inteligencia = 8
    private var sabedoria = 8
    private var carisma = 8
    private var pontosDisponiveis = 27 // Inicializa com 27 pontos

    private lateinit var pontosRestantesTextView: TextView
    private lateinit var forcaTextView: TextView
    private lateinit var destrezaTextView: TextView
    private lateinit var constituicaoTextView: TextView
    private lateinit var inteligenciaTextView: TextView
    private lateinit var sabedoriaTextView: TextView
    private lateinit var carismaTextView: TextView
    private lateinit var proximaPaginaButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_distribuicao_habilidades)

        pontosRestantesTextView = findViewById(R.id.pontosRestantesTextView)
        forcaTextView = findViewById(R.id.forcaTextView)
        destrezaTextView = findViewById(R.id.destrezaTextView)
        constituicaoTextView = findViewById(R.id.constituicaoTextView)
        inteligenciaTextView = findViewById(R.id.inteligenciaTextView)
        sabedoriaTextView = findViewById(R.id.sabedoriaTextView)
        carismaTextView = findViewById(R.id.carismaTextView)
        proximaPaginaButton = findViewById(R.id.proximaPaginaButton)

        // Inicializa a interface
        atualizarInterface()

        // Botões de adição de pontos
        findViewById<Button>(R.id.adicionarForcaButton).setOnClickListener {
            adicionarPontos("forca")
            atualizarInterface()
        }

        findViewById<Button>(R.id.removerForcaButton).setOnClickListener {
            removerPontos("forca")
            atualizarInterface()
        }

        findViewById<Button>(R.id.adicionarDestrezaButton).setOnClickListener {
            adicionarPontos("destreza")
            atualizarInterface()
        }

        findViewById<Button>(R.id.removerDestrezaButton).setOnClickListener {
            removerPontos("destreza")
            atualizarInterface()
        }

        findViewById<Button>(R.id.adicionarConstituicaoButton).setOnClickListener {
            adicionarPontos("constituicao")
            atualizarInterface()
        }

        findViewById<Button>(R.id.removerConstituicaoButton).setOnClickListener {
            removerPontos("constituicao")
            atualizarInterface()
        }

        findViewById<Button>(R.id.adicionarInteligenciaButton).setOnClickListener {
            adicionarPontos("inteligencia")
            atualizarInterface()
        }

        findViewById<Button>(R.id.removerInteligenciaButton).setOnClickListener {
            removerPontos("inteligencia")
            atualizarInterface()
        }

        findViewById<Button>(R.id.adicionarSabedoriaButton).setOnClickListener {
            adicionarPontos("sabedoria")
            atualizarInterface()
        }

        findViewById<Button>(R.id.removerSabedoriaButton).setOnClickListener {
            removerPontos("sabedoria")
            atualizarInterface()
        }

        findViewById<Button>(R.id.adicionarCarismaButton).setOnClickListener {
            adicionarPontos("carisma")
            atualizarInterface()
        }

        findViewById<Button>(R.id.removerCarismaButton).setOnClickListener {
            removerPontos("carisma")
            atualizarInterface()
        }

        // Botão para ir à próxima página
        proximaPaginaButton.setOnClickListener {
            val intent = Intent(this, FichaPersonagemActivity::class.java)
            intent.putExtra("nome", intent.getStringExtra("nome")) // Passar nome do personagem
            intent.putExtra("descricao", intent.getStringExtra("descricao")) // Passar descrição
            intent.putExtra("raca", intent.getStringExtra("raca")) // Passar raça
            intent.putExtra("forca", forca)
            intent.putExtra("destreza", destreza)
            intent.putExtra("constituicao", constituicao)
            intent.putExtra("inteligencia", inteligencia)
            intent.putExtra("sabedoria", sabedoria)
            intent.putExtra("carisma", carisma)
            startActivity(intent)
        }
    }

    private fun adicionarPontos(habilidade: String) {
        when (habilidade) {
            "forca" -> if (forca < 15 && pontosDisponiveis > 0) {
                forca++
                pontosDisponiveis--
            }
            "destreza" -> if (destreza < 15 && pontosDisponiveis > 0) {
                destreza++
                pontosDisponiveis--
            }
            "constituicao" -> if (constituicao < 15 && pontosDisponiveis > 0) {
                constituicao++
                pontosDisponiveis--
            }
            "inteligencia" -> if (inteligencia < 15 && pontosDisponiveis > 0) {
                inteligencia++
                pontosDisponiveis--
            }
            "sabedoria" -> if (sabedoria < 15 && pontosDisponiveis > 0) {
                sabedoria++
                pontosDisponiveis--
            }
            "carisma" -> if (carisma < 15 && pontosDisponiveis > 0) {
                carisma++
                pontosDisponiveis--
            }
        }
    }

    private fun removerPontos(habilidade: String) {
        when (habilidade) {
            "forca" -> if (forca > 8) {
                forca--
                pontosDisponiveis++
            }
            "destreza" -> if (destreza > 8) {
                destreza--
                pontosDisponiveis++
            }
            "constituicao" -> if (constituicao > 8) {
                constituicao--
                pontosDisponiveis++
            }
            "inteligencia" -> if (inteligencia > 8) {
                inteligencia--
                pontosDisponiveis++
            }
            "sabedoria" -> if (sabedoria > 8) {
                sabedoria--
                pontosDisponiveis++
            }
            "carisma" -> if (carisma > 8) {
                carisma--
                pontosDisponiveis++
            }
        }
    }

    private fun atualizarInterface() {
        pontosRestantesTextView.text = "Pontos disponíveis: $pontosDisponiveis"
        forcaTextView.text = "Força: $forca"
        destrezaTextView.text = "Destreza: $destreza"
        constituicaoTextView.text = "Constituição: $constituicao"
        inteligenciaTextView.text = "Inteligência: $inteligencia"
        sabedoriaTextView.text = "Sabedoria: $sabedoria"
        carismaTextView.text = "Carisma: $carisma"
    }
}
