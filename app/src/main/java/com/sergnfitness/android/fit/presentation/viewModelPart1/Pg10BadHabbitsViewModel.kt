package com.sergnfitness.android.fit.presentation.viewModelPart1

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.sergnfitness.domain.models.user.DataUser
import com.sergnfitness.domain.models.user.User
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class Pg10BadHabbitsViewModel @Inject constructor() : ViewModel() {
    val taG = "Pg10BadHabbitsViewModel"

    lateinit var userClass: User
    lateinit var dataUser: DataUser

    private var _page10_fast_food = MutableLiveData<Boolean>(false)
    val live_page10_fast_food: LiveData<Boolean> = _page10_fast_food

    private var _page10_eat_nigth = MutableLiveData<Boolean>(false)
    val live_page10_eat_nigth: LiveData<Boolean> = _page10_eat_nigth

    private var _page10_fast_shugar = MutableLiveData<Boolean>(false)
    val live_page10_fast_shugar: LiveData<Boolean> = _page10_fast_shugar

    private var _page10_nothing_of_list = MutableLiveData<Boolean>(false)
    val live_page10_nothing_of_list: LiveData<Boolean> = _page10_nothing_of_list

    fun initLive() {
        _page10_fast_food.value = dataUser.fastFood
        _page10_eat_nigth.value = dataUser.laterNight
        _page10_fast_shugar.value = dataUser.fastSugar
        _page10_nothing_of_list.value = dataUser.Nothing
    }

    fun changeFastFood() {
        _page10_fast_food.value = true
        _page10_eat_nigth.value = false
        _page10_fast_shugar.value = false
        _page10_nothing_of_list.value = false

        dataUser.fastFood = true
        dataUser.laterNight = false
        dataUser.fastSugar = false
        dataUser.Nothing = false
    }

    fun changeEatNigth() {
        _page10_fast_food.value = false
        _page10_eat_nigth.value = true
        _page10_fast_shugar.value = false
        _page10_nothing_of_list.value = false

        dataUser.fastFood = false
        dataUser.laterNight = true
        dataUser.fastSugar = false
        dataUser.Nothing = false
    }

    fun changeFastShugar() {
        _page10_fast_food.value = false
        _page10_eat_nigth.value = false
        _page10_fast_shugar.value = true
        _page10_nothing_of_list.value = false

        dataUser.fastFood = false
        dataUser.laterNight = false
        dataUser.fastSugar = true
        dataUser.Nothing = false
    }

    fun changeNothingOfList() {
        _page10_fast_food.value = false
        _page10_eat_nigth.value = false
        _page10_fast_shugar.value = false
        _page10_nothing_of_list.value = true

        dataUser.fastFood = false
        dataUser.laterNight = false
        dataUser.fastSugar = false
        dataUser.Nothing = true
    }

}