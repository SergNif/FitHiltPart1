package com.sergnfitness.android.fit.presentation.part1

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.sergnfitness.android.fit.R
import com.sergnfitness.android.fit.databinding.FragmentPg9TypicalDayBinding
import com.sergnfitness.android.fit.presentation.viewModelPart1.Pg9TypicalDayViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class Pg9TypicalDayFragment : Fragment() {

    companion object {
        fun newInstance() = Pg9TypicalDayFragment()
    }

    private  val viewModel: Pg9TypicalDayViewModel by viewModels<Pg9TypicalDayViewModel>()
private lateinit var binding: FragmentPg9TypicalDayBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        return inflater.inflate(R.layout.fragment_pg9_typical_day, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentPg9TypicalDayBinding.bind(view)

        //        binding.lifecycleOwner = this
//
//        binding.page9WorkOffice.setOnClickListener { viewModel.changeColorButtonPage9("1")
//                    val navController = findNavController()
//            navController.run {
//                popBackStack()
//                navigate(R.id.page9Data2Fragment)
//            }
//        }
//        binding.page9InTravel.setOnClickListener { viewModel.changeColorButtonPage9("2")
//                    val navController = findNavController()
//            navController.run {
//                popBackStack()
//                navigate(R.id.page9Data2Fragment)
//            }
//        }
//        binding.page9DayFoot.setOnClickListener { viewModel.changeColorButtonPage9("3")
//                    val navController = findNavController()
//            navController.run {
//                popBackStack()
//                navigate(R.id.page9Data2Fragment)
//            }
//        }
//        binding.page9InHouse.setOnClickListener { viewModel.changeColorButtonPage9("4")
//                    val navController = findNavController()
//            navController.run {
//                popBackStack()
//                navigate(R.id.page9Data2Fragment)
//            }
//        }

//        viewModel.livepage9Button1.observe(viewLifecycleOwner, Observer { color ->
//            modifiedButton = true
//            binding.page9WorkOffice.setBackgroundResource(color)
//        })
//        viewModel.livepage9Button2.observe(viewLifecycleOwner, Observer { color ->
//            modifiedButton = true
//            binding.page9InTravel.setBackgroundResource(color)
//        })
//        viewModel.livepage9Button3.observe(viewLifecycleOwner, Observer { color ->
//            modifiedButton = true
//            binding.page9DayFoot.setBackgroundResource(color)
//        })
//        viewModel.livepage9Button4.observe(viewLifecycleOwner, Observer { color ->
//            modifiedButton = true
//            binding.page9InHouse.setBackgroundResource(color)
//        })

//        binding.textBack.setOnClickListener{
//
//            findNavController().popBackStack()
//        }
//        binding.textNext.setOnClickListener{
//
//            findNavController().navigate(R.id.action_page9Data2Fragment_to_page10Data2Fragment)
//        }
//    }
//    companion object {
//        /**
//         * Use this factory method to create a new instance of
//         * this fragment using the provided parameters.
//         *
//         * @param param1 Parameter 1.
//         * @param param2 Parameter 2.
//         * @return A new instance of fragment Page9Data2Fragment.
//         */
//        // TODO: Rename and change types and number of parameters
//        @JvmStatic
//        fun newInstance(param1: String, param2: String) =
//            Pg9TypicalDayFragment().apply {
//                arguments = Bundle().apply {
//                    putString(ARG_PARAM1, param1)
//                    putString(ARG_PARAM2, param2)
//                }
//            }

    }

}