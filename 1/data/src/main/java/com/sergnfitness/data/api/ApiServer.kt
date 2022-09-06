package com.sergnfitness.data.api


import com.sergnfitness.data.storage.storageModel.DataUserStorage
import com.sergnfitness.data.storage.storageModel.UserStorage
import com.sergnfitness.domain.models.user.DataUser
import com.sergnfitness.domain.models.user.User
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.*


interface ApiServer {

    @POST("fit_new_user_hilt/{user_email}")
    fun postDataUser(
        @Path("user_email") user_email:String,
        @Body params: DataUser
    ): Call<DataUser>

    @GET("/get_one_data_user/{user_id}")
    fun getDataUserOfEmail(
        @Path("user_id") user_id: Int
//        @Query("emailQuery")
//        emailQuery: String,
//        @Query("passwQuery")
//        passwQuery: String,
    ): Call<DataUser>




    @POST("new_user/")
    fun newUserOfEmailPassword(
        @Body params: User
    ): Call<User>

    @GET("/fit_get_one_user_email/")
    fun getUserOfEmailPassword(
//        @Path("user_id") id: Int
        @Query("emailQuery")
        emailQuery: String,
        @Query("passwQuery")
        passwQuery: String,
    ): Call<User>

    @GET("/get_one_user/{user_id}")
    fun getUserOfId(
        @Path("user_id") id: Int
//        @Query("emailQuery")
//        emailQuery: String,
//        @Query("passwQuery")
//        passwQuery: String,
    ): Call<User>

//    @GET("/fit_get_menu_string/")

//    ): Response<User>

    //    @GET("/get_one1_user/{user_id}")
//    suspend fun getUserOfId(
//        @Path("user_id") id: Int
////        @Query("emailQuery")
////        emailQuery: String,
////        @Query("passwQuery")
////        passwQuery: String,
//    ): Response<User>


    //    ): Response<MenuDayListStorage>
//        @Query("dataMenu") date: String
//        @Query("userMenuQiery") id: Int,
//    suspend fun getHeadLines(
//    @GET("/fit_get_one_user_email/")
//    suspend fun getUserOfEmailPassword(
////        @Path("user_id") id: Int
//        @Query("emailQuery")
//        emailQuery: String,
//        @Query("passwQuery")
//        passwQuery: String,


}