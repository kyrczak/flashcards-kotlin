package com.example.fiszki

import android.app.Activity
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_adding_fiszka.*
import java.io.File
import java.io.FileWriter

class AdddingFiszka : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_adding_fiszka)
        val context = applicationContext
        val file = File(context.filesDir,"list.json")
        textView5.text = file.absolutePath
        val gson = Gson()
        saveButton.setOnClickListener {
            gson.toJson(Fiszka(polishWord.toString(),englishWord.toString()), FileWriter(file))
            this.finish()
        }
    }
}