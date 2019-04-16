package com.example.fiszki

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_adding_fiszka.*
import java.io.FileWriter

class AdddingFiszka : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_adding_fiszka)
        var gson = Gson()
        saveButton.setOnClickListener {
           // gson.toJson(Fiszka(polishWord.toString(),englishWord.toString()),FileWriter("list.json"))

        }
    }
}