package com.sergnfitness.domain.repository

import android.app.DownloadManager
import com.sergnfitness.domain.models.UserMenuDay
import com.sergnfitness.domain.models.user.DataUser
import com.sergnfitness.domain.models.user.MenuDayList
import com.sergnfitness.domain.models.user.User
import retrofit2.Call
import retrofit2.Response


interface ApiRepository {
    suspend fun getUserOfIdRepos(id:Int) : Call<User>
    suspend fun getUserOfEmailPasswordRepos(emailQuery:String, passwQuery:String) : Call<User>
    suspend fun getDataUserOfEmailPasswordRepos(
        idQuery: Int,
//        emailQuery:String,
//        passwQuery:String
    ) : Call<DataUser>
    suspend fun saveNewUserOfEmailPasswordRepos(user: User) : Call<User>
    suspend fun postQueryCreateUserRepos( email:String, user: DataUser): Call<DataUser>

    suspend fun getMenuDayStrings(id:Int,  startDate:String, endDate:String): Call<MenuDayList>
    suspend fun pathUpdateWeigth(user_id: Int, userData3: DataUser): Call<DataUser>
    suspend fun postQueryCreateMenuDay(menuDay:UserMenuDay, position:Int): Call<UserMenuDay>
}