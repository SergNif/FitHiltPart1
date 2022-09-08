package com.sergnfitness.android.fit.presentation.part2

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.text.Editable
import android.text.method.PasswordTransformationMethod
import android.text.method.SingleLineTransformationMethod
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.NavDirections
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.sergnfitness.android.fit.R
import com.sergnfitness.android.fit.databinding.FragmentPart2Fragment1ToUserBinding
import com.sergnfitness.android.fit.presentation.controlUI.ChangeFonButtonPage5
import com.sergnfitness.android.fit.presentation.controlUI.ChangeFonButtonPage5NoPress
import com.sergnfitness.android.fit.presentation.part2.part2viewModel.Part2Fragment1ToUserViewModel
import com.sergnfitness.domain.models.UserMenuDay
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class Part2Fragment1ToUser : Fragment() {


    private val taG = "Part2Fragment1ToUser "
    private val viewModel: Part2Fragment1ToUserViewModel by viewModels()
    private lateinit var binding: FragmentPart2Fragment1ToUserBinding
    private val args: Part2Fragment1ToUserArgs by navArgs()

    private val changeFonButtonPage5NoPress = ChangeFonButtonPage5()
    private val changeFonButtonPage5 = ChangeFonButtonPage5NoPress()
    lateinit var oneMenuDay: UserMenuDay

    var open_old_password = 0
    var open_new_password = 0

    companion object {
        fun newInstance() = Part2Fragment1ToUser()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        return inflater.inflate(R.layout.fragment_part2_fragment1_to_user, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentPart2Fragment1ToUserBinding.bind(view)

        var newPassword: String = ""

        binding.eyeOldPassword.setBackgroundResource(R.drawable.shut_eye)
        binding.eyeNewPassword.setBackgroundResource(R.drawable.shut_eye)
        binding.part2page1TextOldPassword.transformationMethod = PasswordTransformationMethod.getInstance()
        binding.part2page1TextNewPassword.transformationMethod = PasswordTransformationMethod.getInstance()

        fun String.toEditable(): Editable = Editable.Factory.getInstance().newEditable(this)
        viewModel.fullName.observe(viewLifecycleOwner, Observer { fullName ->
            binding.textNameUserPart2Page1.text = fullName.toString()

//            com.bignerdranch.android.finnesretrofitmvvm.presentation.fragments.ARG_AGE = age.toString()
        })

        viewModel.password.observe(viewLifecycleOwner, Observer { password ->
            binding.part2page1TextOldPassword.text = password.toEditable()
            //            com.bignerdranch.android.finnesretrofitmvvm.presentation.fragments.ARG_AGE = age.toString()
        })
        binding.houseButton.setOnClickListener {
            onClickHouse()
        }
        binding.eyeNewPassword.setOnClickListener{
            onClickNewPassw()
        }
        binding.eyeOldPassword.setOnClickListener{
            onClickOldPassw()
        }
        binding.part2page1ToUserSaveParam.setOnClickListener{
            onClickSaveChange()
        }
    }

    private fun onClickHouse() {
        val action: NavDirections =
            Part2Fragment1ToUserDirections.actionPart2Fragment1ToUserToPart2Page1Fragment(
                viewModel.userClass, viewModel.dataUser
            )
        findNavController().navigate(action)
    }

    private fun onClickOldPassw() {
        if (open_old_password == 0) {
            binding.part2page1TextOldPassword.transformationMethod = SingleLineTransformationMethod.getInstance()
            binding.eyeOldPassword.setBackgroundResource(R.drawable.eye)
            open_old_password = 1
        } else {
            binding.eyeOldPassword.setBackgroundResource(R.drawable.shut_eye)
            binding.part2page1TextOldPassword.transformationMethod = PasswordTransformationMethod.getInstance()
            open_old_password = 0
        }
    }

    private fun onClickNewPassw() {
        if (open_new_password == 0) {
            binding.part2page1TextNewPassword.transformationMethod = SingleLineTransformationMethod.getInstance()
            binding.eyeNewPassword.setBackgroundResource(R.drawable.eye)
            open_new_password = 1
        } else {
            binding.part2page1TextNewPassword.transformationMethod = PasswordTransformationMethod.getInstance()
            binding.eyeNewPassword.setBackgroundResource(R.drawable.shut_eye)
            open_new_password = 0
        }
    }

    private fun onClickSaveChange() {
        viewModel.saveChangeNamePassword(binding.part2page1TextNewPassword.toString())
    }


}