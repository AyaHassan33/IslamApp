package com.example.islamapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {

    lateinit var btn_sebha : Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        btn_sebha=findViewById(R.id.btn_tasbeh)
        btn_sebha.setOnClickListener{
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.fragment_container,SebhaFragment())
                .commit()

        }


    }
}