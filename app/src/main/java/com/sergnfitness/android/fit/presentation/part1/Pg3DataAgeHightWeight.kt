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
import com.sergnfitness.android.fit.presentation.part1.part1viewModel.Pg3DataAgeHightWeightViewModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class Pg3DataAgeHightWeightFrafment : Fragment() {

    var list = mutableMapOf<String, String>()
    private val args: Pg3DataAgeHightWeightFrafmentArgs by navArgs<Pg3DataAgeHightWeightFrafmentArgs>()

    val taG = "Fragment Page3 DataAgeHightWeight"
    lateinit var binding: Pg3DataAgeHightWeightBinding
    private val viewModel: Pg3DataAgeHightWeightViewModel by viewModels<Pg3DataAgeHightWeightViewModel>()


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
viewModel.dataUser = args.currentDataUser
viewModel.userClass = args.currentUser
        viewModel.makeList()
        showParamOnDisplay()

        fun String.toEditable(): Editable = Editable.Factory.getInstance().newEditable(this)

        binding.dataHeartAgePage3.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }
            override fun afterTextChanged(p0: Editable?) {
                list["age"] = p0.toString()
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
            }
        }
        )

        binding.dataWeightPage3.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }
            override fun afterTextChanged(p0: Editable?) {
                list["weight"] = p0.toString()
            }
        }
        )

//        binding.dataHeartAgePage3.onFocusChangeListener.let { it ->
//        }

        binding.dataDiceweightPage3.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }
            override fun afterTextChanged(p0: Editable?) {
                list["desired_weight"] = p0.toString()
            }
        }
        )

        viewModel.live_age.observe(viewLifecycleOwner, Observer { age ->
            binding.dataHeartAgePage3.text = age.toString().toEditable()
            list["age"] = age.toString()
            Log.e(taG, "$list  ")
        })

        viewModel.live_height.observe(viewLifecycleOwner, Observer { height ->
            binding.dataHeartAgePage3.text = height.toString().toEditable()
            list["height"] = height.toString()
            Log.e(taG, "$list  ")
        })

        viewModel.live_weight.observe(viewLifecycleOwner, Observer { weight ->
            binding.dataHeartAgePage3.text = weight.toString().toEditable()
            list["weight"] = weight.toString()
            Log.e(taG, "$list  ")
        })

        viewModel.live_desired_weight.observe(viewLifecycleOwner, Observer { desired_weight ->
            binding.dataHeartAgePage3.text = desired_weight.toString().toEditable()
            list["desired_weight"] = desired_weight.toString()
            Log.e(taG, "$list  ")
        })
        binding.textBack.setOnClickListener {
//            if (modifiedButton){viewModel.createLocalDataPage4()}
            findNavController().popBackStack()
        }

        binding.textNext.setOnClickListener {
            if (
                (binding.dataHeartAgePage3.text.isNotEmpty()) and
                (binding.dataHightPage3.text.isNotEmpty()) and
                (binding.dataWeightPage3.text.isNotEmpty()) and
                (binding.dataDiceweightPage3.text.isNotEmpty())
            ) {
                Log.e(taG, "$list  ")
                Log.e(taG, "viewModel.dataUser   ${viewModel.dataUser}")
                viewModel.creatUserClass(list)
                val action: NavDirections =
                    Pg3DataAgeHightWeightFrafmentDirections.actionDataAgeHightWeight2ToPg4PhysicalActiveFragment(
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

    private fun showParamOnDisplay() {
        binding.dataHeartAgePage3.setText(args.currentDataUser.age.toString())
        binding.dataHightPage3.setText(args.currentDataUser.height.toString())
        binding.dataWeightPage3.setText(args.currentDataUser.weight.toString())
        binding.dataDiceweightPage3.setText(args.currentDataUser.desired_weight.toString())
    }
}