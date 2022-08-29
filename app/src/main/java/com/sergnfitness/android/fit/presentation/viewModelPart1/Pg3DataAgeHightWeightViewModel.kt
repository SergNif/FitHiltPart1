package com.sergnfitness.android.fit.presentation.viewModelPart1

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.sergnfitness.domain.repository.ApiRepository
import com.sergnfitness.domain.usecase.GetUserOfIdApiUseCase
import com.sergnfitness.domain.usecase.GetUserSharedPreferenceUseCase
import com.sergnfitness.domain.usecase.SaveUserSharedPreferenceUseCase
import com.sergnfitness.domain.usecase.putGetUserClass.CreateExemplarClassDataUserStorageUseCase
import com.sergnfitness.domain.usecase.putGetUserClass.CreateExemplarClassDataUserStorageUseCase_Factory
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class Pg3DataAgeHightWeightViewModel @Inject constructor(
//    private val getUserOfIdApiUseCase: GetUserOfIdApiUseCase,
//    private val apiRepository: ApiRepository,
////    private val NOTuSEsGetUserOfIdApiUseCase: NOTuSEsGetUserOfIdApiUseCase,
//    private val getUserSharedPreferenceUseCase: GetUserSharedPreferenceUseCase,
//    private val saveUserSharedPreferenceUseCase: SaveUserSharedPreferenceUseCase,
//    private val createExemplarClassDataUserStorageUseCase: CreateExemplarClassDataUserStorageUseCase,

    ):ViewModel() {
        val TAG = "Pg3DataAgeHightWeightViewModel"

    private val _age = MutableLiveData<Int>()
    val live_age: LiveData<Int> = _age

    private val _height = MutableLiveData<Int>()
    val live_height: LiveData<Int> = _height

        private val _weight = MutableLiveData<String>()
    val live_weight: LiveData<String> = _weight

        private val _desired_weight = MutableLiveData<String>()
    val live_desired_weight: LiveData<String> = _desired_weight


}