package com.example.aos_assistant

import JsonHandler
import android.content.Context

class GameManager (context: Context){
    var units: MutableList<Unit> = mutableListOf()

    init {
        loadData(context)
    }

    fun loadData(context: Context) {
        val folderName = "army_data/"
        val jsonHandler = JsonHandler(context = context)
        val fileNames = jsonHandler.getAllFilesFromAssets(context = context, folderName)

        fileNames.forEach {
            fileName ->
            val json = jsonHandler.loadJSON(folderName + fileName)
            val unit = jsonHandler.parseJSON(json)
            units.add(unit)
        }
    }
}