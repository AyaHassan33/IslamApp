package com.example.islamapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.islamapp.adapter.SuraContentAdapter

class SuraDetailsActivity : AppCompatActivity() {

    var suraName : String?=null
    var suraPosition:Int?=null
    lateinit var suraNameTitle:TextView
    lateinit var adapter : SuraContentAdapter
    lateinit var recyclerView: RecyclerView
    lateinit var backIcon: ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sura_details)
        suraNameTitle=findViewById(R.id.sura_of_name)
        recyclerView=findViewById(R.id.sura_content_recycler_view)
        suraName=intent.getStringExtra(Constants.SURA_NAME_KEY)
        suraPosition=intent.getIntExtra(Constants.SURA_POSITION_KEY,0)
        suraNameTitle.text="سورة $suraName"

        adapter= SuraContentAdapter(null)
        recyclerView.adapter=adapter

        readFileContents()
        backIcon=findViewById(R.id.back_icon)
        backIcon.setOnClickListener {
            finish()
        }


    }
    private fun readFileContents(){
        val fileContent= assets.open("$suraPosition.txt").bufferedReader().use { it.readText() }
        val contentList = fileContent.trim().split("\n")
        adapter.updateData(contentList)
    }
}