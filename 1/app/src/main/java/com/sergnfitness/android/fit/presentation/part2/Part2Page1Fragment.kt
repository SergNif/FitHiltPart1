package com.sergnfitness.android.fit.presentation.part2

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.sergnfitness.android.fit.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class Part2Page1Fragment : Fragment() {

    companion object {
        fun newInstance() = Part2Page1Fragment()
    }

    private lateinit var viewModel: Part2Page1ViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        return inflater.inflate(R.layout.fragment_part2_page8, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

}