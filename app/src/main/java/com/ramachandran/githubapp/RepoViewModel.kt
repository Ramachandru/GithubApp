package com.ramachandran.githubapp

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ramachandran.githubapp.model.Repos
import com.ramachandran.githubapp.network.Api
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

typealias mapListLive = HashMap<String,MutableList<Repos>>
class RepoViewModel : ViewModel() {
    private val mutableLiveData : MutableLiveData<mapListLive> by lazy{
        getDatas()
        MutableLiveData<mapListLive>()
    }
    fun getLivedata() = mutableLiveData
    private fun getRetrofit() : Retrofit {
        return Retrofit.Builder()
            .baseUrl(Api.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
    private fun getDatas() : Unit{
        val apiCall= getRetrofit().create(Api::class.java)
        val callData =apiCall.getReposList();
        callData.enqueue(object : Callback<MutableList<Repos>> {
            override fun onFailure(call: Call<MutableList<Repos>>, t: Throwable) {
                Log.v("Error ","Error "+t.message)
            }

            override fun onResponse(call: Call<MutableList<Repos>>, response: Response<MutableList<Repos>>) {
                mutableLiveData.value=(getHashList(response.body()!!))
            }

        })
    }
    private fun getHashList(github:  MutableList<Repos>) : mapListLive{
        val map : mapListLive= mapListLive()
        for(git in github){
            geList(map,git)
        }
        return map
    }
    private fun geList(map : mapListLive, git : Repos) : Unit{
        if(map.containsKey(git.fork.toString())){
            val list : MutableList<Repos>? =map.get(git.fork.toString())
            list!!.add(git)
            map.put(git.fork.toString(), list!!)
        }
        else{
            val list : MutableList<Repos> = ArrayList<Repos>()
            list.add(git)
            map.put(git.fork.toString(),list!!)
        }
    }
}