package com.sergnfitness.android.fit.presentation.viewModelPart1

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.sergnfitness.domain.models.user.DataUser
import com.sergnfitness.domain.models.user.User
import com.sergnfitness.domain.repository.ApiRepository
import com.sergnfitness.domain.usecase.GetUserOfIdApiUseCase
import com.sergnfitness.domain.usecase.GetUserSharedPreferenceUseCase
import com.sergnfitness.domain.usecase.SaveUserSharedPreferenceUseCase
import com.sergnfitness.domain.usecase.putGetUserClass.CreateExemplarClassDataUserStorageUseCase
import com.sergnfitness.domain.usecase.putGetUserClass.CreateExemplarClassDataUserStorageUseCase_Factory
import dagger.hilt.android.lifecycle.HiltViewModel
import java.time.LocalDateTime
import javax.inject.Inject

@HiltViewModel
class Pg3DataAgeHightWeightViewModel @Inject constructor(
//    private val getUserOfIdApiUseCase: GetUserOfIdApiUseCase,
//    private val apiRepository: ApiRepository,
////    private val NOTuSEsGetUserOfIdApiUseCase: NOTuSEsGetUserOfIdApiUseCase,
//    private val getUserSharedPreferenceUseCase: GetUserSharedPreferenceUseCase,
//    private val saveUserSharedPreferenceUseCase: SaveUserSharedPreferenceUseCase,
//    private val createExemplarClassDataUserStorageUseCase: CreateExemplarClassDataUserStorageUseCase,

) : ViewModel() {
    var userClass: User = User()
    val TAG = "Pg3DataAgeHightWeightViewModel"

    var list = mutableMapOf<String, String>()

    var dataUser: DataUser = DataUser()

    private val _age = MutableLiveData<Int>()
    val live_age: LiveData<Int> = _age

    private val _height = MutableLiveData<Int>()
    val live_height: LiveData<Int> = _height

    private val _weight = MutableLiveData<String>()
    val live_weight: LiveData<String> = _weight

    private val _desired_weight = MutableLiveData<String>()
    val live_desired_weight: LiveData<String> = _desired_weight


    fun changeAge(text: String) {
        _age.value = text.toInt()
    }

    fun changeHaight(text: String) {
        _height.value = text.toInt()
    }

    fun changeWeight(text: String) {
        _weight.value = text
    }

    fun changedesireWeight(text: String) {
        _desired_weight.value = text
    }

    //
//    fun changeAge2(text: MutableMap<String, String>) {
//        _age.value = text.get("age")?.toInt()
//        _height.value = text.get("height")?.toInt()
//        _weight.value = text.get("weight")
//        _desired_weight.value = text.get("desired_weight")
//        }
    fun creatUserClass(list: MutableMap<String, String>) {
        dataUser.age = list["age"]?.toInt()!!
        dataUser.height = list["height"]?.toInt()!!
        dataUser.weight = list["weight"]!!
        dataUser.desired_weight = list["desired_weight"]!!
    }

    fun makeList() {
        list["age"] = dataUser.age.toString()
        list["height"] = dataUser.height.toString()
        list["weight"] = dataUser.weight.toString()
        list["desired_weight"] = dataUser.desired_weight.toString()

        _age.value = list["age"]?.toInt()
        _height.value = list["height"]?.toInt()
        _weight.value = list["weight"]
        _desired_weight.value = list["desired_weight"]
    }

}