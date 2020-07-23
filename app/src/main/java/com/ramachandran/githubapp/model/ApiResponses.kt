package com.ramachandran.githubapp.model


data class Repos(val id: Long,
                 val node_id : String,
                 val name : String,
                 val full_name:  String,
                 val fork : Boolean,
                 val url : String)