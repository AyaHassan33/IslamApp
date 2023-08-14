package com.example.islamapp.fragments



import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.islamapp.Constants
import com.example.islamapp.HadethDetailsActivity

import com.example.islamapp.R
import com.example.islamapp.SuraDetailsActivity
import com.example.islamapp.adapter.HadethAdapter
import com.example.islamapp.interfaces.OnHadethClickListener
import com.example.islamapp.model.HadethData


class HadethFragment : Fragment() {

    lateinit var recyclerView: RecyclerView
    lateinit var adapter:HadethAdapter
    val ahadethObjectsList = mutableListOf<HadethData>()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_hadeth, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView= view.findViewById(R.id.hadeth_recycler_view)
        adapter= HadethAdapter(null)
        adapter.onHadethClickListener=object:OnHadethClickListener{
            override fun onHadethClick(hadethData: HadethData, position: Int) {
                val intent = Intent(requireActivity(), HadethDetailsActivity::class.java)
                intent.putExtra(Constants.HADETH_NAME_KEY,hadethData.title)
                intent.putExtra(Constants.HADETH_CONTENT_KEY,hadethData.hadethContent?.toTypedArray())
                startActivity(intent)

            }

        }
        //read from ahadeth.txt file
        readHadethFile()
        recyclerView.adapter=adapter
    }

    private fun readHadethFile(){
        val fileContent= requireActivity().assets.open("ahadeth.txt").bufferedReader()
            .use { it.readText() }
        val ahadethList= fileContent.trim().split("#")
        ahadethList.forEach {
            val hadeth = it.trim().split("\n")
            val title = hadeth.get(0)
            val content = hadeth
            ahadethObjectsList.add(HadethData(title, content))

        }
        adapter.updateData(ahadethObjectsList)

    }


}