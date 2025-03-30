import android.content.Context
import com.example.aos_assistant.Effect
import com.example.aos_assistant.Unit
import com.google.gson.Gson
import com.google.gson.JsonParser
import java.io.IOException

class JsonHandler(private val context: Context) {

    fun getAllFilesFromAssets(context: Context, folderName: String = ""): List<String> {
        return try {
            context.assets.list(folderName)?.toList() ?: emptyList()
        } catch (e: Exception) {
            e.printStackTrace()
            emptyList()
        }
    }

    fun loadJSON(filepath: String): String? {
        return try {
            context.assets.open(filepath).bufferedReader().use { it.readText() }
        } catch (ex: IOException) {
            ex.printStackTrace()
            null
        }
    }

    fun parseJSON(json: String?): Unit {
        val gson = Gson()
        val unit: Unit = gson.fromJson(json, Unit::class.java)
        return unit
    }
}
