package com.sergnfitness.android.fit.presentation.part1

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.sergnfitness.android.fit.R
import com.sergnfitness.android.fit.presentation.viewModelPart1.Pg8WaterDrinkViewModel
import dagger.hilt.android.AndroidEntryPoint

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [Pg8WaterDrinkFragment.newInstance] factory method to
 * create an instance of this fragment.
 */

@AndroidEntryPoint
class Pg8WaterDrinkFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

  private val viewModel: Pg8WaterDrinkViewModel by viewModels<Pg8WaterDrinkViewModel>()
    val TAG = "Fragment Page8"

//    private lateinit var binding: FragmentPage8Data2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_page8_water_drink, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        viewModel = (activity as MainActivity).viewModel
//        binding = FragmentPage8Data2Binding.bind(view)
//        var modifiedButton: Boolean = false
//
//
//        binding.vmPage8 = viewModel
//        binding.imgLoadPage8 = ImageLoader()
//        binding.lifecycleOwner = this
//
//        binding.page8ButtonWaterWithoutGas.setOnClickListener { viewModel.changeColorButtonPage8("1")
//                    val navController = findNavController()
//            navController.run {
//                popBackStack()
//                navigate(R.id.page8Data2Fragment)
//            }
//        }
//        binding.page8ButtonWaterShugar.setOnClickListener { viewModel.changeColorButtonPage8("2")
//                    val navController = findNavController()
//            navController.run {
//                popBackStack()
//                navigate(R.id.page8Data2Fragment)
//            }
//        }
//        binding.page8ButtonMoreCofee.setOnClickListener { viewModel.changeColorButtonPage8("3")
//                    val navController = findNavController()
//            navController.run {
//                popBackStack()
//                navigate(R.id.page8Data2Fragment)
//            }
//        }
//        binding.page8ButtonOnlyTea.setOnClickListener { viewModel.changeColorButtonPage8("4")
//                    val navController = findNavController()
//            navController.run {
//                popBackStack()
//                navigate(R.id.page8Data2Fragment)
//            }
//        }

//        viewModel.livepage8Button1.observe(viewLifecycleOwner, Observer { color ->
//             modifiedButton = true
////            binding.page8ButtonWaterWithoutGas.setBackgroundColor(Color.parseColor(color))
//            binding.page8ButtonWaterWithoutGas.setBackgroundResource(color)
//        })
//        viewModel.livepage8Button2.observe(viewLifecycleOwner, Observer { color ->
//             modifiedButton = true
////            binding.page8ButtonWaterShugar.setBackgroundColor(Color.parseColor(color))
//            binding.page8ButtonWaterShugar.setBackgroundResource(color)
//        })
//        viewModel.livepage8Button3.observe(viewLifecycleOwner, Observer { color ->
//             modifiedButton = true
////            binding.page8ButtonMoreCofee.setBackgroundColor(Color.parseColor(color))
//            binding.page8ButtonMoreCofee.setBackgroundResource(color)
//        })
//        viewModel.livepage8Button4.observe(viewLifecycleOwner, Observer { color ->
//             modifiedButton = true
////            binding.page8ButtonOnlyTea.setBackgroundColor(Color.parseColor(color))
//            binding.page8ButtonOnlyTea.setBackgroundResource(color)
//        })


//        binding.textBack.setOnClickListener{
////            if (modifiedButton){viewModel.createLocalDataPage8()}
//            findNavController().popBackStack()
//        }
//        binding.textNext.setOnClickListener{
////            if (modifiedButton){viewModel.createLocalDataPage8()}
//            findNavController().navigate(R.id.action_page8Data2Fragment_to_page9Data2Fragment)
//        }
//    }
//    companion object {
//        /**
//         * Use this factory method to create a new instance of
//         * this fragment using the provided parameters.
//         *
//         * @param param1 Parameter 1.
//         * @param param2 Parameter 2.
//         * @return A new instance of fragment Page8Data2Fragment.
//         */
//        // TODO: Rename and change types and number of parameters
//        @JvmStatic
//        fun newInstance(param1: String, param2: String) =
//            Pg8WaterDrinkFragment().apply {
//                arguments = Bundle().apply {
//                    putString(ARG_PARAM1, param1)
//                    putString(ARG_PARAM2, param2)
//                }
//            }
    }
}