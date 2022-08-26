package com.sergnfitness.android.fit.presentation.part1

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.sergnfitness.android.fit.R
import com.sergnfitness.android.fit.databinding.FragmentPage4PhysicalActiveBinding
import com.sergnfitness.android.fit.presentation.viewModelPart1.Pg4PhysicalActiveFragmentViewModel
import dagger.hilt.android.AndroidEntryPoint


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [Pg4PhysicalActiveFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
@AndroidEntryPoint
class Pg4PhysicalActiveFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    //    lateinit var viewModel: MainViewModel
    private val viewModel: Pg4PhysicalActiveFragmentViewModel by viewModels<Pg4PhysicalActiveFragmentViewModel>()


    val TAG = "Fragment Page4"

    //    private lateinit var bindi  //FragmentPage4Data2Binding
    private lateinit var binding: FragmentPage4PhysicalActiveBinding
//private lateinit var binding: com.sergnfitness.android.fit.databinding.FragmentPg4PhysicalActiveBinding
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        arguments?.let {
//            param1 = it.getString(ARG_PARAM1)
//            param2 = it.getString(ARG_PARAM2)
//        }
//    }

//    override fun onCreateView(
//        inflater: LayoutInflater, container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View? {
//        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_page4_data2, container, false)
//    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        viewModel = (activity as MainActivity).viewModel
//        binding = FragmentPage4Data2Binding.bind(view)
        var modifiedButton: Boolean = false
//
//        binding.vmod = viewModel
//        binding.imgLoad = ImageLoader()
//        binding.lifecycleOwner = this


//        binding.page4ButtonMinActiv.setClickable(true)
//        binding.page4ButtonFastWalk.setClickable(true)
//        binding.page4Button12PerWeek.setClickable(true)
//        binding.page4Button35PerWeek.setClickable(true)
//        binding.page4ButtonEveryDayFitness.setClickable(true)

//        binding.page4ButtonMinActiv.setOnClickListener {
//            binding.page4ButtonMinActiv.setBackgroundResource(R.drawable.ic_fon_text_page_4)
//            binding.page4ButtonFastWalk.setBackgroundResource(R.drawable.ic_fon_text_page_4_no_press)
//            binding.page4Button12PerWeek.setBackgroundResource(R.drawable.ic_fon_text_page_4_no_press)
//            binding.page4Button35PerWeek.setBackgroundResource(R.drawable.ic_fon_text_page_4_no_press)
//            binding.page4ButtonEveryDayFitness.setBackgroundResource(R.drawable.ic_fon_text_page_4_no_press)
//        }
//        binding.page4ButtonFastWalk.setOnClickListener {
//            binding.page4ButtonMinActiv.setBackgroundResource(R.drawable.ic_fon_text_page_4_no_press)
//            binding.page4ButtonFastWalk.setBackgroundResource(R.drawable.ic_fon_text_page_4)
//            binding.page4Button12PerWeek.setBackgroundResource(R.drawable.ic_fon_text_page_4_no_press)
//            binding.page4Button35PerWeek.setBackgroundResource(R.drawable.ic_fon_text_page_4_no_press)
//            binding.page4ButtonEveryDayFitness.setBackgroundResource(R.drawable.ic_fon_text_page_4_no_press)
//        }
//        binding.page4Button12PerWeek.setOnClickListener {
//            binding.page4ButtonMinActiv.setBackgroundResource(R.drawable.ic_fon_text_page_4_no_press)
//            binding.page4ButtonFastWalk.setBackgroundResource(R.drawable.ic_fon_text_page_4_no_press)
//            binding.page4Button12PerWeek.setBackgroundResource(R.drawable.ic_fon_text_page_4)
//            binding.page4Button35PerWeek.setBackgroundResource(R.drawable.ic_fon_text_page_4_no_press)
//            binding.page4ButtonEveryDayFitness.setBackgroundResource(R.drawable.ic_fon_text_page_4_no_press)
//        }
//        binding.page4Button35PerWeek.setOnClickListener {
//            binding.page4ButtonMinActiv.setBackgroundResource(R.drawable.ic_fon_text_page_4_no_press)
//            binding.page4ButtonFastWalk.setBackgroundResource(R.drawable.ic_fon_text_page_4_no_press)
//            binding.page4Button12PerWeek.setBackgroundResource(R.drawable.ic_fon_text_page_4_no_press)
//            binding.page4Button35PerWeek.setBackgroundResource(R.drawable.ic_fon_text_page_4)
//            binding.page4ButtonEveryDayFitness.setBackgroundResource(R.drawable.ic_fon_text_page_4_no_press)
//        }
//        binding.page4ButtonEveryDayFitness.setOnClickListener {
//            binding.page4ButtonMinActiv.setBackgroundResource(R.drawable.ic_fon_text_page_4_no_press)
//            binding.page4ButtonFastWalk.setBackgroundResource(R.drawable.ic_fon_text_page_4_no_press)
//            binding.page4Button12PerWeek.setBackgroundResource(R.drawable.ic_fon_text_page_4_no_press)
//            binding.page4Button35PerWeek.setBackgroundResource(R.drawable.ic_fon_text_page_4_no_press)
//            binding.page4ButtonEveryDayFitness.setBackgroundResource(R.drawable.ic_fon_text_page_4)
//        }

//        binding.page4ButtonMinActiv.setOnClickListener {
//            viewModel.changeColorButton("1")
//            val navController = findNavController()
//            navController.run {
//                popBackStack()
//                navigate(R.id.page4Data2Fragment)
//            }
//        }
//        binding.page4ButtonFastWalk.setOnClickListener {
//            this.viewModel.changeColorButton("2")
//            val navController = findNavController()
//            navController.run {
//                popBackStack()
//                navigate(R.id.page4Data2Fragment)
//            }
//        }
//        binding.page4Button12PerWeek.setOnClickListener {
//            this.viewModel.changeColorButton("3")
//            val navController = findNavController()
//            navController.run {
//                popBackStack()
//                navigate(R.id.page4Data2Fragment)
//            }
//        }
//        binding.page4Button35PerWeek.setOnClickListener {
//            this.viewModel.changeColorButton("4")
//            val navController = findNavController()
//            navController.run {
//                popBackStack()
//                navigate(R.id.page4Data2Fragment)
//            }
//        }
//        binding.page4ButtonEveryDayFitness.setOnClickListener {
//            this.viewModel.changeColorButton("5")
//            val navController = findNavController()
//            navController.run {
//                popBackStack()
//                navigate(R.id.page4Data2Fragment)
//            }
//        }

//        viewModel.dataPage5
        //*********************************************************************************
//        var dw = getResources().getDrawable(R.drawable.ic_fon_text_page_4)
//        var dwNo = getResources().getDrawable(R.drawable.ic_fon_text_page_4_no_press)
//
//        dw.setBounds(0, 0, dw.getMinimumWidth(), dw.getMinimumHeight())
//        dwNo.setBounds(0, 0, dwNo.getMinimumWidth(), dwNo.getMinimumHeight())

//        binding.page4ButtonMinActiv.setCompoundDrawables(null, dw, null, null)
//        binding.page4ButtonFastWalk.setCompoundDrawables(null, dwNo, null, null)
// *********************************************************************************

//                viewModel.liveButton1.observe(viewLifecycleOwner, Observer { color ->
//                    modifiedButton = true
//                    binding.page4ButtonMinActiv.setBackgroundResource(color)
//                })
//                viewModel.liveButton2.observe(viewLifecycleOwner, Observer { color ->
//                    modifiedButton = true
//                    binding.page4ButtonFastWalk.setBackgroundResource(color)
//                })
//                viewModel.liveButton3.observe(viewLifecycleOwner, Observer { color ->
//                    modifiedButton = true
//                    binding.page4Button12PerWeek.setBackgroundResource(color)
//                })
//                viewModel.liveButton4.observe(viewLifecycleOwner, Observer { color ->
//                    modifiedButton = true
//                    binding.page4Button35PerWeek.setBackgroundResource(color)
//                })
//                viewModel.liveButton5.observe(viewLifecycleOwner, Observer { color ->
//                    modifiedButton = true
//                    binding.page4ButtonEveryDayFitness.setBackgroundResource(color)
//                })

//        binding.textBack.setOnClickListener {
////            if (modifiedButton){viewModel.createLocalDataPage4()}
//            findNavController().popBackStack()
//        }
//        binding.textNext.setOnClickListener {
////            if (modifiedButton){viewModel.createLocalDataPage4()}
//
//
//            findNavController().navigate(R.id.action_page4Data2Fragment_to_page5Data2Fragment)
//        }
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment Page4Data2Fragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            Pg4PhysicalActiveFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}