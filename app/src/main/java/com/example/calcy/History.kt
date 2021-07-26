package com.example.calcy

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class History : AppCompatActivity() {
    private var layoutManager :RecyclerView.LayoutManager?=null
    private var adapter :RecyclerView.Adapter<HistoryAdapter.ViewHolder>?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_history)
        val data=intent.getStringArrayListExtra("userHistory")
        layoutManager= LinearLayoutManager(this,)
        var recyclerView : RecyclerView =findViewById(R.id.recycler)
        recyclerView.layoutManager = layoutManager
        adapter=HistoryAdapter()
        recyclerView.adapter= adapter
    }
}