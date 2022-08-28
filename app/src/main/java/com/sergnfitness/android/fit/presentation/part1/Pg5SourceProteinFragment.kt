package com.sergnfitness.android.fit.presentation.part1

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.sergnfitness.android.fit.R
import com.sergnfitness.android.fit.databinding.FragmentPage5SouceProteinBinding
import com.sergnfitness.android.fit.presentation.viewModelPart1.Pg5SourceProteinViewModel
import dagger.hilt.android.AndroidEntryPoint

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [Pg5SourceProteinFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
@AndroidEntryPoint
class Pg5SourceProteinFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

//    lateinit var viewModel: MainViewModel
    val TAG = "Fragment Page5"
lateinit var binding : FragmentPage5SouceProteinBinding
    private val viewModel: Pg5SourceProteinViewModel by viewModels<Pg5SourceProteinViewModel>()

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
        return inflater.inflate(R.layout.fragment_page5_souce_protein, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        viewModel = (activity as MainActivity).viewModel
        binding = FragmentPage5SouceProteinBinding.bind(view)
////if (viewModel.dataPage5.isInitialized)
//        var modifiedButton: Boolean = false
//
//        binding.vmPage5 = viewModel
//        binding.imgLoadPage5 = ImageLoader()
//        binding.lifecycleOwner = this

//        binding.textPage5Chiken.setOnClickListener {
//            viewModel.changeColorButtonPage51()
//            val navController = findNavController()
//            navController.run {
//                popBackStack()
//                navigate(R.id.page5Data2Fragment)
//            }
//        }
//        binding.textPage5Turkey.setOnClickListener {
//            viewModel.changeColorButtonPage52()
//            val navController = findNavController()
//            navController.run {
//                popBackStack()
//                navigate(R.id.page5Data2Fragment)
//            }
//        }
//        binding.page5ButtonPork.setOnClickListener {
//            viewModel.changeColorButtonPage53()
//            val navController = findNavController()
//            navController.run {
//                popBackStack()
//                navigate(R.id.page5Data2Fragment)
//            }
//        }
//        binding.page5Beef.setOnClickListener {
//            viewModel.changeColorButtonPage54()
//            val navController = findNavController()
//            navController.run {
//                popBackStack()
//                navigate(R.id.page5Data2Fragment)
//            }
//        }
//        binding.page5ButtonFish.setOnClickListener {
//            viewModel.changeColorButtonPage55()
//            val navController = findNavController()
//            navController.run {
//                popBackStack()
//                navigate(R.id.page5Data2Fragment)
//            }
//        }
//        binding.page5Seafood.setOnClickListener {
//            viewModel.changeColorButtonPage56()
//            val navController = findNavController()
//            navController.run {
//                popBackStack()
//                navigate(R.id.page5Data2Fragment)
//            }
//        }
//        binding.page5ButtonWithoutMeat.setOnClickListener {
//            viewModel.changeColorButtonPage57()
//            val navController = findNavController()
//            navController.run {
//                popBackStack()
//                navigate(R.id.page5Data2Fragment)
//            }
//        }
//        binding.textPage5WithoutFish.setOnClickListener {
//            viewModel.changeColorButtonPage58()
//            val navController = findNavController()
//            navController.run {
//                popBackStack()
//                navigate(R.id.page5Data2Fragment)
//            }
//        }

//        viewModel.livepage5Button1.observe(viewLifecycleOwner, Observer { color ->
//            modifiedButton = true
////            binding.textPage5Chiken.setBackgroundColor(Color.parseColor(color))
//            binding.textPage5Chiken.setBackgroundResource(color)
//        })
//        viewModel.livepage5Button2.observe(viewLifecycleOwner, Observer { color ->
//            modifiedButton = true
////            binding.textPage5Turkey.setBackgroundColor(Color.parseColor(color))
//            binding.textPage5Turkey.setBackgroundResource(color)
//        })
//        viewModel.livepage5Button3.observe(viewLifecycleOwner, Observer { color ->
//            modifiedButton = true
////            binding.page5ButtonPork.setBackgroundColor(Color.parseColor(color))
//            binding.page5ButtonPork.setBackgroundResource(color)
//        })
//        viewModel.livepage5Button4.observe(viewLifecycleOwner, Observer { color ->
//            modifiedButton = true
////            binding.page5Beef.setBackgroundColor(Color.parseColor(color))
//            binding.page5Beef.setBackgroundResource(color)
//        })
//        viewModel.livepage5Button5.observe(viewLifecycleOwner, Observer { color ->
//            modifiedButton = true
////            binding.page5ButtonFish.setBackgroundColor(Color.parseColor(color))
//            binding.page5ButtonFish.setBackgroundResource(color)
//        })
//        viewModel.livepage5Button6.observe(viewLifecycleOwner, Observer { color ->
//            modifiedButton = true
////            binding.page5Seafood.setBackgroundColor(Color.parseColor(color))
//            binding.page5Seafood.setBackgroundResource(color)
//        })
//        viewModel.livepage5Button7.observe(viewLifecycleOwner, Observer { color ->
//            modifiedButton = true
////            binding.page5ButtonWithoutMeat.setBackgroundColor(Color.parseColor(color))
//            binding.page5ButtonWithoutMeat.setBackgroundResource(color)
//        })
//        viewModel.livepage5Button8.observe(viewLifecycleOwner, Observer { color ->
//            modifiedButton = true
////            binding.textPage5WithoutFish.setBackgroundColor(Color.parseColor(color))
//            binding.textPage5WithoutFish.setBackgroundResource(color)
//        })


//        binding.textBack.setOnClickListener {
////            if (modifiedButton){viewModel.createLocalDataPage5()}
//            findNavController().popBackStack()
//        }
//        binding.textNext.setOnClickListener {
////        if (modifiedButton){viewModel.createLocalDataPage5()}
//            findNavController().navigate(R.id.action_page5Data2Fragment_to_page6Data2Fragment)
//        }
//    }
//
//    companion object {
//        /**
//         * Use this factory method to create a new instance of
//         * this fragment using the provided parameters.
//         *
//         * @param param1 Parameter 1.
//         * @param param2 Parameter 2.
//         * @return A new instance of fragment Page5Data2Fragment.
//         */
//        // TODO: Rename and change types and number of parameters
//        @JvmStatic
//        fun newInstance(param1: String, param2: String) =
//            Pg5SourceProteinFragment().apply {
//                arguments = Bundle().apply {
//                    putString(ARG_PARAM1, param1)
//                    putString(ARG_PARAM2, param2)
//                }
//            }
    }
}