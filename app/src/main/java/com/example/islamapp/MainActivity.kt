package com.example.islamapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    lateinit var bottomNavigationView :BottomNavigationView
    var sebhaFragment:SebhaFragment=SebhaFragment()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViews()


    }
    private fun initViews(){
        bottomNavigationView=findViewById(R.id.bottom_navigation_view)
        bottomNavigationView.setOnItemSelectedListener {
            if(it.itemId==R.id.navigation_quran){

            }else if(it.itemId==R.id.navigation_hadeth){

            }else if(it.itemId==R.id.navigation_sebha){
                pushFragment(sebhaFragment)

            }else if(it.itemId==R.id.navigation_radio){

            }
            return@setOnItemSelectedListener true
        }
    }

    private fun pushFragment(fragment: Fragment){
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.islami_fragment_container,fragment)
            .commit()

    }
}