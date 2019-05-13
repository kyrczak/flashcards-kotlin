package com.example.fiszki

import android.app.Activity
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.android.synthetic.main.activity_adding_fiszka.*
import java.io.File
import java.io.FileWriter

class AdddingFiszka() : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_adding_fiszka)
        val context = applicationContext
        val file = File(filesDir,"list.json")
        textView5.text = file.absolutePath
        var jsonString= file.readText()
        val flashcardsType = object : TypeToken<MutableList<Fiszka>>() {}.type
        val flashcards = Gson().fromJson<MutableList<Fiszka>>(jsonString, flashcardsType)
        saveButton.setOnClickListener {
            flashcards.add(Fiszka(polishWord.text.toString(),englishWord.text.toString()))
            jsonString = Gson().toJson(flashcards)
            file.writeText(jsonString)
            this.finish()
        }
    }
}