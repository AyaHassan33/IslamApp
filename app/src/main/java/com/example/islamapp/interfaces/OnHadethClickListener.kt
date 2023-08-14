package com.example.islamapp.interfaces

import com.example.islamapp.model.HadethData
import java.text.FieldPosition

interface OnHadethClickListener {
    fun onHadethClick(hadethData:HadethData,position: Int)
}