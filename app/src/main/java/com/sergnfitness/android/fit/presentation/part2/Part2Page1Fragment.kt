package com.sergnfitness.android.fit.presentation.part2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.sergnfitness.android.fit.R
import com.sergnfitness.android.fit.databinding.FragmentPart2Page1Binding
import com.sergnfitness.android.fit.databinding.FragmentPg8WaterDrinkBinding
import com.sergnfitness.android.fit.presentation.controlUI.ChangeFonButtonPage5
import com.sergnfitness.android.fit.presentation.controlUI.ChangeFonButtonPage5NoPress
import com.sergnfitness.android.fit.presentation.part1.Pg8WaterDrinkFragmentArgs
import com.sergnfitness.android.fit.presentation.part2.part2viewModel.Part2Page1ViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class Part2Page1Fragment : Fragment() {

    companion object {
        fun newInstance() = Part2Page1Fragment()
    }
    private val taG = "Part2Page1Fragment "

    private val viewModel: Part2Page1ViewModel by viewModels()
private lateinit var binding: FragmentPart2Page1Binding
    private val args: Part2Page1FragmentArgs by navArgs()

    private val changeFonButtonPage5NoPress = ChangeFonButtonPage5()
    private val changeFonButtonPage5 = ChangeFonButtonPage5NoPress()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        return inflater.inflate(R.layout.fragment_part2_page8, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentPart2Page1Binding.bind(view)
        viewModel.dataUser = args.currentDataUser
        viewModel.userClass = args.currentUser

        viewModel.initLive()
    }

}