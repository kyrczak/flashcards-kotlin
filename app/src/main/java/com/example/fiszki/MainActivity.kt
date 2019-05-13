package com.example.fiszki

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*
import java.io.BufferedReader
import java.io.File
import java.io.FileWriter

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        val context = applicationContext
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)
        val file = File(context.filesDir,"list.json")
        if(!file.exists()) {
            file.createNewFile() //Utwórz plik
            // Zapisz do pliku
        }
        else { //Dopisz do pliku
        }
        val pathtofile = file.absolutePath
        val jsonString= file.readText()
        addButton.setOnClickListener {
            startActivity(Intent(this, AdddingFiszka::class.java))
        }

        textView.text = pathtofile
        textView2.text = jsonString



        val flashcardsType = object : TypeToken<Fiszka>() {}.type
        val flashcards = Gson().fromJson<MutableList<Fiszka>>(file.readText(),flashcardsType)

        friendsList.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = FiszkiAdapter(flashcards)
        }

    }
}
