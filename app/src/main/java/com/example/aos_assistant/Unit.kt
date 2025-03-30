package com.example.aos_assistant

import com.google.gson.annotations.SerializedName

data class Unit (val abilities: List<Ability>)

data class Ability ( @SerializedName("ability_name") val name: String,
                     @SerializedName("phase_applicable") val phaseApplicable: String,
                     val effects: List<Effect>,
                     @SerializedName("is_passive") val isPassive: Boolean,
                     val description: String)

data class Effect(val number: Int, val type: String, val value: String,
                  @SerializedName("affected_units") val affectedUnits: String,
                  val duration: String,
                  val conditions: List<Condition>,
                  val misc: String)

data class Condition (val condition: String)
