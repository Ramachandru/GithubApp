package com.ramachandran.githubapp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ramachandran.githubapp.databinding.ReposadapterBinding
import com.ramachandran.githubapp.model.Repos

class ReposAdapter : RecyclerView.Adapter<ReposAdapter.ReposViewHolder>() {
    private lateinit var reposadapterBinding: ReposadapterBinding
    var reposList : MutableList<Repos>? =null
    fun setList(reposeList : MutableList<Repos>){
        this.reposList = reposeList
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):ReposViewHolder {
        reposadapterBinding = ReposadapterBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ReposViewHolder(reposadapterBinding)
    }

    override fun getItemCount(): Int {
       return reposList!!.size
    }

    override fun onBindViewHolder(holder: ReposViewHolder, position: Int) {
       val repo = reposList!!.get(position)
        holder.bindData(repo)
    }
    class ReposViewHolder(repoBinding : ReposadapterBinding) : RecyclerView.ViewHolder(repoBinding.root){
        var repoBind =repoBinding;
        fun bindData(repo : Repos){
            repoBind.repos = repo
            repoBind.executePendingBindings()
        }
    }

}