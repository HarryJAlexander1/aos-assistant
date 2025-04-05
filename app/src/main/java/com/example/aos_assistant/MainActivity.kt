package com.example.aos_assistant
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.aos_assistant.ui.theme.AosassistantTheme
import androidx.compose.foundation.border
import androidx.compose.material3.MaterialTheme
import android.content.res.Configuration
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.clickable
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import previewAbility
import previewAbility2


class MainActivity : ComponentActivity() {
    val gm = GameManager(this)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AosassistantTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    gm.units.forEach { unit ->
                        AbilityList(unit.abilities)
                    }
                }
            }
        }
    }
}

@Preview
@Composable
fun PreviewAbilityCard() {
    AosassistantTheme {
        Surface {
            AbilityCard(
                ability = previewAbility
            )
        }
    }
}

@Composable
fun AbilityCard(ability: Ability){
    var isExpanded by remember { mutableStateOf(true) }
    // surfaceColor will be updated gradually from one color to the other
    val surfaceColor by animateColorAsState(
        if (isExpanded) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.surface,
    )

    Row (modifier = Modifier.padding(all = 8.dp)){
        Image(painter = painterResource(R.drawable.killaboss_on_gnashtoof),
            contentDescription = "Unit picture",
            modifier = Modifier
                .size(50.dp)
                .border(1.5.dp, MaterialTheme.colorScheme.primary))

        Spacer(modifier = Modifier.width(8.dp))
        // We toggle the isExpanded variable when we click on this Column
        Column (modifier = Modifier.clickable { isExpanded = !isExpanded }) {
            Text(
                text = ability.name,
                color = MaterialTheme.colorScheme.secondary,
                style = MaterialTheme.typography.titleLarge
            )
            // Add a vertical space between the author and message texts
            Spacer(
                modifier = Modifier.height(4.dp)
            )

            Surface (
                shadowElevation = 3.dp,
                // surfaceColor color will be changing gradually from primary to surface
                color = surfaceColor,
                // animateContentSize will change the Surface size gradually
                modifier = Modifier.animateContentSize().padding(1.dp)
            ) {
                Text(
                    text = ability.toString(),
                    modifier = Modifier.padding(all = 4.dp),
                    // If the message is expanded, we display all its content
                    // otherwise we only display the first line
                    maxLines = if (isExpanded) Int.MAX_VALUE else 1,
                    style = MaterialTheme.typography.bodyMedium
                )
            }
        }
    }

}
@Preview
@Composable
fun PreviewAbilityList(){
    AosassistantTheme {
        Surface {
            AbilityList(
                abilities = listOf(previewAbility, previewAbility2)
            )
        }
    }
}

@Composable
fun AbilityList(abilities: List<Ability>) {
    LazyColumn {
        items(abilities) { ability ->
            AbilityCard(ability)
        }
    }
}
///////////////////////////////////////////////////////////////////////////////////////////////////
//@Preview
//@Composable
//fun PreviewMessageCard() {
//    AosassistantTheme {
//        Surface {
//            MessageCard(
//                msg = Message("Lexi", "Take a look at Jetpack Compose, it's great!")
//            )
//        }
//    }
//}
//
//data class Message(val author: String, val body: String)
//
//@Composable
//fun MessageCard(msg: Message){
//
//    // We keep track if the message is expanded or not in this
//    // variable
//    var isExpanded by remember { mutableStateOf(false) }
//    // surfaceColor will be updated gradually from one color to the other
//    val surfaceColor by animateColorAsState(
//        if (isExpanded) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.surface,
//    )
//    // Add padding around our message
//    Row (modifier = Modifier.padding(all = 8.dp)) {
//        Image(painter = painterResource(R.drawable.profile_picture),
//            contentDescription = "Contact profile picture",
//            modifier = Modifier
//                // Set image size to 40 dp
//                .size(40.dp)
//                // Clip image to be shaped as a circle
//                .clip(CircleShape)
//                .border(1.5.dp, MaterialTheme.colorScheme.primary, CircleShape))
//
//        // Add a horizontal space between the image and the column
//        Spacer(modifier = Modifier.width(8.dp))
//        // We toggle the isExpanded variable when we click on this Column
//            Column (modifier = Modifier.clickable { isExpanded = !isExpanded }) {
//                Text(
//                    text = msg.author,
//                    color = MaterialTheme.colorScheme.secondary,
//                    style = MaterialTheme.typography.titleLarge
//                )
//                // Add a vertical space between the author and message texts
//                Spacer(
//                    modifier = Modifier.height(4.dp)
//                )
//
//                Surface (
//                    shape = MaterialTheme.shapes.medium,
//                    shadowElevation = 3.dp,
//                    // surfaceColor color will be changing gradually from primary to surface
//                    color = surfaceColor,
//                    // animateContentSize will change the Surface size gradually
//                    modifier = Modifier.animateContentSize().padding(1.dp)
//                    ) {
//                    Text(
//                        text = msg.body,
//                        modifier = Modifier.padding(all = 4.dp),
//                        // If the message is expanded, we display all its content
//                        // otherwise we only display the first line
//                        maxLines = if (isExpanded) Int.MAX_VALUE else 1,
//                        style = MaterialTheme.typography.bodyMedium
//                    )
//                }
//            }
//    }
//}
//
//@Composable
//fun Conversation(messages: List<Message>) {
//    LazyColumn {
//        items(messages) { message ->
//            MessageCard(message)
//        }
//    }
//}
//
//@Preview
//@Composable
//fun PreviewConversation() {
//    AosassistantTheme {
//        Conversation(SampleData.conversationSample)
//    }
//}
