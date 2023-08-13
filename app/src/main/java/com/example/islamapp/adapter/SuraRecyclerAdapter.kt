package com.example.islamapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.islamapp.R
import com.example.islamapp.interfaces.OnSuraClickListener
import com.example.islamapp.model.SuraNameData

class SuraRecyclerAdapter(
    val suraNameList:List<SuraNameData>
) : Adapter<SuraRecyclerAdapter.SuraViewHolder>() {

    var onSuraClickListener:OnSuraClickListener?=null


    class SuraViewHolder(val view:View):ViewHolder(view){
        val suraNameText:TextView=view.findViewById(R.id.sura_name)
        val suraPositionText:TextView=view.findViewById(R.id.sura_position)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SuraViewHolder {
        val view= LayoutInflater.from(parent.context).inflate(R.layout.item_sura_name,parent,false)
        return SuraViewHolder(view)
    }

    override fun getItemCount(): Int {
        return suraNameList.size
    }

    override fun onBindViewHolder(holder: SuraViewHolder, position: Int) {
        val item=suraNameList.get(position)
        holder.suraNameText.text=item.name
        holder.suraPositionText.text= "${item.position}"     //---> == item.position.toString()
        holder.view.setOnClickListener{
            onSuraClickListener?.onSuraClick(item)
        }
    }


}