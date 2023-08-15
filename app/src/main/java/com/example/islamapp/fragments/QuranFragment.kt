package com.example.islamapp.fragments


import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.appcompat.app.AppCompatDelegate
import androidx.recyclerview.widget.RecyclerView
import com.example.islamapp.Constants
import com.example.islamapp.R
import com.example.islamapp.SuraDetailsActivity
import com.example.islamapp.adapter.SuraRecyclerAdapter
import com.example.islamapp.interfaces.OnSuraClickListener
import com.example.islamapp.model.SuraNameData
import com.example.islamapp.model.arSuras

class QuranFragment : Fragment() {
    lateinit var recyclerView: RecyclerView
    lateinit var suraRecyclerAdapter:SuraRecyclerAdapter
    lateinit var switchMoodButton:ImageView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_quran, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView=view.findViewById(R.id.sura_names_recycler_View)
        // use map Fun to convert from list of string (data type) to list of data type another

        suraRecyclerAdapter=SuraRecyclerAdapter(arSuras.mapIndexed { index, name ->
            SuraNameData(name= name , position = index+1)
        })
        suraRecyclerAdapter.onSuraClickListener=object :OnSuraClickListener{
            override fun onSuraClick(suraName: SuraNameData) {
                val intent = Intent(requireActivity(), SuraDetailsActivity::class.java)
                intent.putExtra(Constants.SURA_NAME_KEY,suraName.name)
                intent.putExtra(Constants.SURA_POSITION_KEY,suraName.position)
                startActivity(intent)
            }

        }
        recyclerView.adapter=suraRecyclerAdapter
        switchMoodButton=view.findViewById(R.id.switch_mood_button)
        switchMoodButton.tag="image"


        if(AppCompatDelegate.getDefaultNightMode() == AppCompatDelegate.MODE_NIGHT_YES){
            switchMoodButton.setImageResource(R.drawable.ic_light_mode)
            switchMoodButton.tag=R.drawable.ic_light_mode
        }else{
            switchMoodButton.setImageResource(R.drawable.ic_night_mood)
            switchMoodButton.tag=R.drawable.ic_night_mood
        }


        switchMoodButton.setOnClickListener {
            if(switchMoodButton.tag == R.drawable.ic_night_mood){
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)

            }else if(switchMoodButton.tag == R.drawable.ic_light_mode){
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
            }
        }

    }


}