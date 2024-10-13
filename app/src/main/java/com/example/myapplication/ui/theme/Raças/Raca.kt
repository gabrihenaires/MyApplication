package Raças

abstract class Raca {
    abstract val bonusHabilidades: Map<String, Int>

    fun obterHabilidadesIniciais(): MutableMap<String, Int> {
        return mutableMapOf(
            "Força" to 8,
            "Destreza" to 8,
            "Constituição" to 8,
            "Inteligência" to 8,
            "Sabedoria" to 8,
            "Carisma" to 8
        )
    }

    fun aplicarBonusRaca(habilidadesBase: MutableMap<String, Int>): MutableMap<String, Int> {
        val habilidadesComBonus = habilidadesBase.toMutableMap()
        for ((habilidade, bonus) in bonusHabilidades) {
            habilidadesComBonus[habilidade] = (habilidadesComBonus[habilidade] ?: 0) + bonus
        }
        return habilidadesComBonus
    }
}
