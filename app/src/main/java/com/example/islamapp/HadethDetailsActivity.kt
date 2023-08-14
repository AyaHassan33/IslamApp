package com.example.islamapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.islamapp.adapter.SuraContentAdapter

class HadethDetailsActivity : AppCompatActivity() {
    lateinit var recyclerView: RecyclerView
    lateinit var hadethTitle:TextView
    lateinit var adapter:SuraContentAdapter
    lateinit var backIcon:ImageView
    var hadethTitleName:String?=null
    var hadethContent= listOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hadeth_details)
        recyclerView=findViewById(R.id.hadeth_content_recycler_view)
        hadethTitle=findViewById(R.id.hadeth_name)
        hadethTitleName=intent?.getStringExtra(Constants.HADETH_NAME_KEY)
        hadethContent=intent?.getStringArrayExtra(Constants.HADETH_CONTENT_KEY)?.toList()?: listOf()
        hadethTitle.text="$hadethTitleName"
        adapter=SuraContentAdapter(hadethContent)
        recyclerView.adapter=adapter
        backIcon=findViewById(R.id.back_icon)
        backIcon.setOnClickListener {
            finish()
        }






    }
}