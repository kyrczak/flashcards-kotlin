package com.example.fiszki

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)
        val fiszki = mutableListOf<Fiszka>()
        val json: String = Gson().toJson(fiszki)
        addButton.setOnClickListener {
            val i = Intent(this, AdddingFiszka::class.java)
            i.putExtra("dane", json)
            startActivity(i)
        }
        fiszki.add(Fiszka("osoba", "person", fiszki.size))
        fiszki.add(Fiszka("koło", "wheel", fiszki.size))
        fiszki.add(Fiszka("jeden", "one", fiszki.size))
        fiszki.add(Fiszka("dwa", "two", fiszki.size))


        // @miloszratajczyk (https://github.com/miloszratajczyk)
        // Look at the list.json file
        // Also updated User.kt
        val jsonString = applicationContext.assets.open("list.json").bufferedReader().use { it.readText() }
        val flashcardsType = object : TypeToken<MutableList<Fiszka>>() {}.type
        val flashcards = Gson().fromJson<MutableList<Fiszka>>(jsonString, flashcardsType)

        // GO HERE TO LEARN MORE: https://www.baeldung.com/kotlin-json-convert-data-class
        // Good luck


        friendsList.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            //Also here fiszki -> flashcards
            adapter = FriendsAdapter(flashcards)
        }

    }
}
