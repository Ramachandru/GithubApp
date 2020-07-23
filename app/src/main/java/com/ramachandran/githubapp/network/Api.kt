package com.ramachandran.githubapp.network

import com.ramachandran.githubapp.model.Repos
import retrofit2.Call
import retrofit2.http.GET

interface Api {
    companion object{
        const val BASE_URL : String ="https://api.github.com/users/zellwk/"
    }
    @GET("repos")
    fun getReposList() : Call<MutableList<Repos>>
}
