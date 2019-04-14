package com.example.fiszki

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager
import com.google.gson.Gson

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
            val i = Intent(this,AdddingFiszka::class.java)
            i.putExtra("dane",json)
            startActivity(i)
        }
        fiszki.add(Fiszka("osoba","person",fiszki.size))
        fiszki.add(Fiszka("koło","wheel",fiszki.size))
        fiszki.add(Fiszka("jeden","one",fiszki.size))
        fiszki.add(Fiszka("dwa","two",fiszki.size))

        friendsList.apply {
            layoutManager  = LinearLayoutManager(this@MainActivity)
            adapter = FriendsAdapter(fiszki)
        }
    }
}
