package com.example.islamapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.islamapp.R

class SuraContentAdapter(var contentList:List<String>?=null):Adapter<SuraContentAdapter.ContentViewHolder>() {

    class ContentViewHolder(val view: View):ViewHolder(view){
        val contentTextView:TextView=view.findViewById(R.id.verse_text)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContentViewHolder {
        return ContentViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.sura_content,parent,false))
    }

    override fun getItemCount(): Int {
        return contentList?.size ?:0
    }

    override fun onBindViewHolder(holder: ContentViewHolder, position: Int) {
        holder.contentTextView.text=contentList?.get(position)
    }

    fun updateData(contentList: List<String>){
        this.contentList=contentList
        notifyDataSetChanged()   //Adapter -->Reload

    }
}