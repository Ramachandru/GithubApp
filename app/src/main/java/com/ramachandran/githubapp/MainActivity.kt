package com.ramachandran.githubapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.ramachandran.githubapp.databinding.ActivityMainBinding
import com.ramachandran.githubapp.model.Repos

class MainActivity : AppCompatActivity() {

    private lateinit var activityMainBinding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityMainBinding=DataBindingUtil.setContentView(this,R.layout.activity_main);
        activityMainBinding.activitInstance=this
        activityMainBinding.executePendingBindings()
        val repoViewModel = ViewModelProviders.of(this).get(RepoViewModel::class.java)
        repoViewModel.getLivedata().observe(this,Observer()
        { mapList->
            RepoSingleTon.getInstance().setDataList(mapList)
        })
    }
    fun forkBtnClicked(isflag : Boolean){
        Toast.makeText(this@MainActivity,isflag.toString(),Toast.LENGTH_SHORT).show()
       startActivity(Intent(this@MainActivity,ReposActivity::class.java).putExtra("flag",isflag.toString()))
    }
}
