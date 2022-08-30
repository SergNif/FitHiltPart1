package com.sergnfitness.android.fit.presentation.part1

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.NavDirections
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.sergnfitness.android.fit.R
import com.sergnfitness.android.fit.databinding.Pg3DataAgeHightWeightBinding
import com.sergnfitness.android.fit.presentation.viewModelPart1.Pg3DataAgeHightWeightViewModel
import dagger.hilt.android.AndroidEntryPoint


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [Pg3DataAgeHightWeightFrafment.newInstance] factory method to
 * create an instance of this fragment.
 */
@AndroidEntryPoint
class Pg3DataAgeHightWeightFrafment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    var list = mutableMapOf<String, String>()
    private val args: Pg3DataAgeHightWeightFrafmentArgs by navArgs<Pg3DataAgeHightWeightFrafmentArgs>()

    val TAG = "Fragment Page3 DataAgeHightWeight"
    lateinit var binding: Pg3DataAgeHightWeightBinding
    private val viewModel: Pg3DataAgeHightWeightViewModel by viewModels<Pg3DataAgeHightWeightViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.pg3_data_age_hight_weight, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = Pg3DataAgeHightWeightBinding.bind(view)

        fun String.toEditable(): Editable = Editable.Factory.getInstance().newEditable(this)

        binding.dataHeartAgePage3.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
//               binding.dataDiceweightPage3.setText(p0)
            }

            override fun afterTextChanged(p0: Editable?) {
                list["age"] = p0.toString()
//                createList()
//                viewModel.changeAge(list)
            }
        }
        )



        binding.dataHightPage3.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun afterTextChanged(p0: Editable?) {
                list["height"] = p0.toString()
//                createList()
//                viewModel.changeAge(list)
            }
        }
        )

        binding.dataWeightPage3.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
//                binding.dataWeightPage3.setText(p0)
            }

            override fun afterTextChanged(p0: Editable?) {
                list["weight"] = p0.toString()
//                createList()
//                viewModel.changeAge(list)
            }
        }
        )

        binding.dataHeartAgePage3.onFocusChangeListener.let { it ->

        }


        binding.dataDiceweightPage3.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun afterTextChanged(p0: Editable?) {
                list["desired_weight"] = p0.toString()
//                createList()
//                viewModel.changeAge(list)
            }
        }
        )



        viewModel.live_age.observe(viewLifecycleOwner, Observer { age ->
            binding.dataHeartAgePage3.text = age.toString().toEditable()
            list["age"] = age.toString()
            Log.e(TAG, "$list  ")
        })

        viewModel.live_height.observe(viewLifecycleOwner, Observer { height ->
            binding.dataHeartAgePage3.text = height.toString().toEditable()
            list["height"] = height.toString()
            Log.e(TAG, "$list  ")
        })

        viewModel.live_weight.observe(viewLifecycleOwner, Observer { weight ->
            binding.dataHeartAgePage3.text = weight.toString().toEditable()
            list["weight"] = weight.toString()
            Log.e(TAG, "$list  ")
        })


        viewModel.live_desired_weight.observe(viewLifecycleOwner, Observer { desired_weight ->
            binding.dataHeartAgePage3.text = desired_weight.toString().toEditable()
            list["desired_weight"] = desired_weight.toString()
            Log.e(TAG, "$list  ")
        })

        binding.textNext.setOnClickListener {
            if (
                (binding.dataHeartAgePage3.text.isNotEmpty()) and
                (binding.dataHightPage3.text.isNotEmpty()) and
                (binding.dataWeightPage3.text.isNotEmpty()) and
                (binding.dataDiceweightPage3.text.isNotEmpty())
            ) {
                Log.e(TAG, "$list  ")
                viewModel.creatUserClass(list)
                val action: NavDirections =
                    Pg3DataAgeHightWeightFrafmentDirections.actionDataAgeHightWeight2ToLoginFragment2(
                        args.currentUser, viewModel.dataUser)
                findNavController().navigate(action)
            } else {
                when {
                    binding.dataHeartAgePage3.text.isEmpty() -> Toast.makeText(context,
                        "Пожалуйста, введите возраст",
                        Toast.LENGTH_SHORT).show()
                    binding.dataHightPage3.text.isEmpty() -> Toast.makeText(context,
                        "Пожалуйста, введите рост",
                        Toast.LENGTH_SHORT).show()
                    binding.dataWeightPage3.text.isEmpty() -> Toast.makeText(context,
                        "Пожалуйста, введите вес",
                        Toast.LENGTH_SHORT).show()
                    binding.dataDiceweightPage3.text.isEmpty() -> Toast.makeText(context,
                        "Пожалуйста, введите желаемый вес",
                        Toast.LENGTH_SHORT).show()
                }
            }
        }

    }

//    private fun createList() {
//        list["age"] = binding.dataHeartAgePage3.toString()
//        list["height"] = binding.dataHightPage3.toString()
//        list["weight"] = binding.dataWeightPage3.toString()
//        list["desired_weight"] = binding.dataDiceweightPage3.toString()
//        Log.e(TAG, "list list  $list")
//    }


    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment DataAgeHightWeight.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            Pg3DataAgeHightWeightFrafment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}