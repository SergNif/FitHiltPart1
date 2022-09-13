package com.sergnfitness.android.fit.presentation.part2.part2viewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sergnfitness.domain.models.user.DataUser
import com.sergnfitness.domain.models.user.User
import com.sergnfitness.domain.repository.ApiRepository
import com.sergnfitness.domain.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class Part2Fragment1ToUserViewModel @Inject constructor(
    private val apiRepository: ApiRepository,
) : ViewModel() {

    val taG = "Part2Fragment1ToUserViewModel "

    lateinit var userClass: User
    lateinit var dataUser: DataUser


    private var _id: MutableLiveData<Int> = MutableLiveData(0)
    val id: LiveData<Int> = _id
    private var _fullName: MutableLiveData<String> = MutableLiveData("fulName")
    val fullName: LiveData<String> = _fullName
    private var _email: MutableLiveData<String> = MutableLiveData("f@f.rt")
    val email: LiveData<String> = _email
    private var _password: MutableLiveData<String> = MutableLiveData("pasw")
    val password: LiveData<String> = _password


    private val _toUserResourceLiveData = MutableLiveData<Resource<Any>>()
    val toUserResourceLiveData: LiveData<Resource<Any>> = _toUserResourceLiveData

    private val _toUserLiveData = MutableLiveData<User>()
    val toUserLiveData: LiveData<User> = _toUserLiveData


    fun saveChangeNamePassword(newPassword: String?) {

        if (newPassword != null) {
            userClass.password =
                if (newPassword != "null" && newPassword.isNotEmpty()) newPassword else userClass.password
        } else {
            userClass.password = userClass.password
        }
        launchUpdateNamePassword(userClass)
    }


    fun launchUpdateNamePassword(userName: User) = viewModelScope.launch {
        updateNamePassword(userName)
    }

    private suspend fun updateNamePassword(userName: User) {
        _toUserResourceLiveData.postValue(Resource.Loading())
        userName.id?.let {
            apiRepository.updateNamePassword(user_id = it,
                userName = userName)
        }?.enqueue(object : Callback<User> {
            override fun onFailure(call: Call<User>, t: Throwable) {
                Log.e(taG, "Data Page3 NULL")
                _toUserResourceLiveData.postValue(Resource.Error(t.message.toString()))
                _toUserLiveData.postValue(null)
            }

            override fun onResponse(call: Call<User>, response: Response<User>) {
                _toUserResourceLiveData.postValue(Resource.Loading(response))
                if (response.isSuccessful && response.body() != null) {
                    userClass = response.body()!!
                    Log.e(taG, "Data Page3 IS ${response.body()} ${userClass}")
                    _toUserLiveData.postValue(response.body())
                } else {
                    Log.e(taG, "Data Page3 ELSE ${response.body()}")
                    _toUserResourceLiveData.postValue(Resource.Error("${response.message()} No this data"))
                    _toUserLiveData.postValue(null)
                }
            }
        }
        )
    }
}