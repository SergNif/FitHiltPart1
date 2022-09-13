package com.sergnfitness.android.fit.presentation.part2.part2viewModel

import androidx.lifecycle.ViewModel
import com.sergnfitness.domain.models.user.DataUser
import com.sergnfitness.domain.models.user.User

class Part2Page1ViewModel : ViewModel() {

    val TAG = "Part2Page1ViewModel "

    lateinit var userClass: User
    lateinit var dataUser: DataUser
}