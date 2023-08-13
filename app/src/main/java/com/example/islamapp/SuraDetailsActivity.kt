package com.example.islamapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class SuraDetailsActivity : AppCompatActivity() {

    var suraName : String?=null
    var suraPosition:Int?=null
    lateinit var suraNameTitle:TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sura_details)
        suraNameTitle=findViewById(R.id.sura_of_name)
        suraName=intent.getStringExtra(Constants.SURA_NAME_KEY)
        suraPosition=intent.getIntExtra(Constants.SURA_POSITION_KEY,0)
        suraNameTitle.text="سورة $suraName"


    }
}