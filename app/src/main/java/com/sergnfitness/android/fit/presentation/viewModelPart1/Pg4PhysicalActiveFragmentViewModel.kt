package com.sergnfitness.android.fit.presentation.viewModelPart1

import androidx.lifecycle.ViewModel
import com.sergnfitness.domain.repository.ApiRepository
import com.sergnfitness.domain.repository.UserRepository
import com.sergnfitness.domain.usecase.GetUserOfEmailPasswordApiUseCase
import com.sergnfitness.domain.usecase.GetUserOfIdApiUseCase
import com.sergnfitness.domain.usecase.GetUserSharedPreferenceUseCase
import com.sergnfitness.domain.usecase.SaveUserSharedPreferenceUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class Pg4PhysicalActiveFragmentViewModel @Inject constructor(
    private val gGetUserOfEmailPasswordApiUseCase: GetUserOfEmailPasswordApiUseCase,
    private val getUserOfIdApiUseCase: GetUserOfIdApiUseCase,
    private val apiRepository: ApiRepository,
    private val userRepository: UserRepository,
    private val getUserSharedPreferenceUseCase: GetUserSharedPreferenceUseCase,
    private val saveUserSharedPreferenceUseCase: SaveUserSharedPreferenceUseCase,

    ): ViewModel(){


}