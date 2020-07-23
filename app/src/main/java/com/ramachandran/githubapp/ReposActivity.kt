package com.ramachandran.githubapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ReposActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.reposactivity)
        val keyFlag = intent.getStringExtra("flag")
        val recycler = findViewById<RecyclerView>(R.id.recycler)
        val repoadapter=ReposAdapter()
        val list =RepoSingleTon.getInstance().getDataList()!!.get(keyFlag)
        repoadapter.setList(list!!)
        val linearLayoutManager= LinearLayoutManager(this)
        recycler.layoutManager=linearLayoutManager
        recycler.adapter=repoadapter
    }
}