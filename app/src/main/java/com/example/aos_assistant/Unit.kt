package com.example.aos_assistant

import com.google.gson.annotations.SerializedName

data class Unit (val abilities: List<Ability>)

data class Ability ( @SerializedName("ability_name") val name: String,
                     @SerializedName("phase_applicable") val phaseApplicable: String,
                     val effects: List<Effect>,
                     @SerializedName("is_passive") val isPassive: Boolean,
                     val description: String){
    override fun toString(): String {
        return buildString {
            appendLine("Phase Applicable: $phaseApplicable")
            appendLine("Is Passive: $isPassive")
            appendLine("Description: $description")
            appendLine()
            appendLine("Effects:")
            effects.forEach { effect ->
                appendLine(effect.toString().prependIndent("  ")) // Indent effects for readability
            }
        }.trimEnd() // Remove unnecessary trailing whitespace
    }

}

data class Effect(val number: Int, val type: String, val value: String,
                  @SerializedName("affected_units") val affectedUnits: String,
                  val duration: String,
                  val conditions: List<Condition>,
                  val misc: String)
{
    override fun toString(): String {
        return """
            Effect #$number:
            Type: $type
            Value: $value
            Affected Units: $affectedUnits
            Duration: $duration
            Conditions: ${conditions.joinToString("\n") { "- ${it.condition}" }}
            Misc: $misc
            
        """.trimIndent()
    }
}

data class Condition (val condition: String)
