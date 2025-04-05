import com.example.aos_assistant.Ability
import com.example.aos_assistant.Condition
import com.example.aos_assistant.Effect

val previewAbility = Ability(
    name = "Fireball",
    phaseApplicable = "Combat",
    effects = listOf(
        Effect(
            number = 1,
            type = "Damage",
            value = "50",
            affectedUnits = "Enemies",
            duration = "Instant",
            conditions = listOf(
                Condition(condition = "Target must be within range")
            ),
            misc = "Ignores armor"
        )
    ),
    isPassive = false,
    description = "A powerful fireball that deals damage to enemies in range."
)
val previewAbility2 = Ability(
    name = "Heal",
    phaseApplicable = "Support",
    effects = listOf(
        Effect(
            number = 1,
            type = "Healing",
            value = "30",
            affectedUnits = "Allies",
            duration = "Instant",
            conditions = listOf(
                Condition(condition = "Target must be below 50% health")
            ),
            misc = "Can target multiple allies"
        ),
        Effect(
            number = 2,
            type = "Shield",
            value = "20",
            affectedUnits = "Allies",
            duration = "5 seconds",
            conditions = listOf(
                Condition(condition = "Target must be in range")
            ),
            misc = "Grants a temporary shield"
        )
    ),
    isPassive = false,
    description = "Restores health to allies and shields them from incoming damage."
)



