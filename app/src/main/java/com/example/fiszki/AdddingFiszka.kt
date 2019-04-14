package com.example.fiszki

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_adding_fiszka.*

class AdddingFiszka() : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_adding_fiszka)

        saveButton.setOnClickListener {

        }
    }
}