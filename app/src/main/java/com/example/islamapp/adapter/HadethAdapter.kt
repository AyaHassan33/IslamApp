package com.example.islamapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.islamapp.R
import com.example.islamapp.interfaces.OnHadethClickListener
import com.example.islamapp.model.HadethData

class HadethAdapter(var hadethDataList: List<HadethData>?=null) :Adapter<HadethAdapter.HadethViewHolder>() {

    var onHadethClickListener:OnHadethClickListener?=null



    class HadethViewHolder(var view:View):ViewHolder(view){
        val hadethTitleText:TextView=view.findViewById(R.id.hadeth_title)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HadethViewHolder {
        return HadethViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_hadeth_name,parent,false))
    }

    override fun getItemCount(): Int {
        return hadethDataList?.size ?:0
    }

    override fun onBindViewHolder(holder: HadethViewHolder, position: Int) {
        val item=hadethDataList?.get(position)
        holder.hadethTitleText.text=item?.title
        holder.view.setOnClickListener{
            onHadethClickListener?.onHadethClick(item?:return@setOnClickListener,position)
        }
    }
    fun updateData(ahadethObjectsList: List<HadethData>) {
        this.hadethDataList = ahadethObjectsList
        notifyDataSetChanged() // Reload
    }
}