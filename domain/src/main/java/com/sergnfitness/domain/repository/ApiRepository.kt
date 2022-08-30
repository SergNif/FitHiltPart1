package com.sergnfitness.domain.repository

import com.sergnfitness.domain.models.user.DataUser
import com.sergnfitness.domain.models.user.User
import retrofit2.Call
import retrofit2.Response


interface ApiRepository {
    suspend fun getUserOfIdRepos(id:Int) : Call<User>
    suspend fun getUserOfEmailPasswordRepos(emailQuery:String, passwQuery:String) : Call<User>
    suspend fun saveNewUserOfEmailPasswordRepos(user: User) : Call<User>
    suspend fun postQueryCreateUserRepos( email:String, user: DataUser): Call<DataUser>

}