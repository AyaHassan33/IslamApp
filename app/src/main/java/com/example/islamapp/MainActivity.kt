package com.example.islamapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.islamapp.fragments.HadethFragment
import com.example.islamapp.fragments.QuranFragment
import com.example.islamapp.fragments.RadioFragment
import com.example.islamapp.fragments.SebhaFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    lateinit var bottomNavigationView :BottomNavigationView
    var sebhaFragment: SebhaFragment = SebhaFragment()
    var quranFragment:QuranFragment= QuranFragment()
    var hadethFragment:HadethFragment= HadethFragment()
    var radioFragment:RadioFragment=RadioFragment()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViews()


    }
    private fun initViews(){
        bottomNavigationView=findViewById(R.id.bottom_navigation_view)
        bottomNavigationView.setOnItemSelectedListener {
            if(it.itemId==R.id.navigation_quran){
                pushFragment(quranFragment)

            }else if(it.itemId==R.id.navigation_hadeth){
                pushFragment(hadethFragment)

            }else if(it.itemId==R.id.navigation_sebha){
                pushFragment(sebhaFragment)

            }else if(it.itemId==R.id.navigation_radio){
                pushFragment(radioFragment)


            }
            return@setOnItemSelectedListener true
        }
        bottomNavigationView.selectedItemId=R.id.navigation_quran
    }

    private fun pushFragment(fragment: Fragment){
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.islami_fragment_container,fragment)
            .commit()

    }
}