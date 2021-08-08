package com.example.calcy

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class HistoryAdapter(var context: Context):RecyclerView.Adapter<HistoryAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v= LayoutInflater.from(parent.context).inflate(R.layout.cardlayout,parent,false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.tvRecy.text=data[position]
        holder.tvRecy.setOnClickListener {
            Toast.makeText(context,data[position],Toast.LENGTH_SHORT).show()
        }


    }

    override fun getItemCount(): Int {
        return data.size
    }
    class ViewHolder(itemView: View) :RecyclerView.ViewHolder(itemView){
        var tvRecy:TextView = itemView.findViewById(R.id.single_card)


    }
}