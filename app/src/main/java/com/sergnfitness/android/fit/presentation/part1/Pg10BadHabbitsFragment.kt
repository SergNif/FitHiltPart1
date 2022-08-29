package com.sergnfitness.android.fit.presentation.part1

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.sergnfitness.android.fit.R
import com.sergnfitness.android.fit.databinding.FragmentPg10BadHabbitsBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class Pg10BadHabbitsFragment : Fragment() {

    companion object {
        fun newInstance() = Pg10BadHabbitsFragment()
    }

    private  val viewModel: Pg10BadHabbitsViewModel by viewModels<Pg10BadHabbitsViewModel>()
private lateinit var binding: FragmentPg10BadHabbitsBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        return inflater.inflate(R.layout.fragment_pg10_bad_habbits, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentPg10BadHabbitsBinding.bind(view)
    }

}