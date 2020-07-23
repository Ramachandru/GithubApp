package com.ramachandran.githubapp

import com.ramachandran.githubapp.model.Repos
typealias mapList=  HashMap<String,MutableList<Repos>>
class RepoSingleTon private constructor(){
    private var hashMap :mapList?=null
    companion object{
        private var repoSingleton : RepoSingleTon?=null
        fun getInstance() : RepoSingleTon{
            if(repoSingleton == null){
                synchronized(RepoSingleTon::class.java){
                    if(repoSingleton == null){
                        repoSingleton = RepoSingleTon()
                    }
                }
            }
            return repoSingleton!!
        }
    }
    fun setDataList(map : mapList){
        hashMap = map
    }
    fun getDataList() = hashMap
}