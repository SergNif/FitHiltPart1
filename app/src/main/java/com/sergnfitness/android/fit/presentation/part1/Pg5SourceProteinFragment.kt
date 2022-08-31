package com.sergnfitness.android.fit.presentation.part1

import android.os.Bundle
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
import com.sergnfitness.android.fit.databinding.FragmentPg5SourceProteinBinding
import com.sergnfitness.android.fit.presentation.controlUI.ChangeFonButtonPage5
import com.sergnfitness.android.fit.presentation.controlUI.ChangeFonButtonPage5NoPress
import com.sergnfitness.android.fit.presentation.viewModelPart1.Pg5SourceProteinViewModel
import dagger.hilt.android.AndroidEntryPoint

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

@AndroidEntryPoint
class Pg5SourceProteinFragment : Fragment() {

    private var param1: String? = null
    private var param2: String? = null

    companion object {
        fun newInstance() = Pg5SourceProteinFragment()
    }
    val TAG = "Fragment Pg5SourceProteinFragment"
    private val viewModel: Pg5SourceProteinViewModel by viewModels<Pg5SourceProteinViewModel>()
    private lateinit var binding: FragmentPg5SourceProteinBinding
    private val args:Pg5SourceProteinFragmentArgs by navArgs<Pg5SourceProteinFragmentArgs>()

    val changeFonButtonPage5NoPress = ChangeFonButtonPage5()
    val changeFonButtonPage5 = ChangeFonButtonPage5NoPress()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        return inflater.inflate(R.layout.fragment_pg5_source_protein, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentPg5SourceProteinBinding.bind(view)
        viewModel.dataUser = args.currentDataUser
        viewModel.userClass = args.currentUser

        viewModel.initLive()

        with(binding){
            textPage5Chiken.setOnCheckedChangeListener{_, isChecked->
                if (isChecked){
                    viewModel.changeChiken(true)
//                    textPage5Chiken.setBackgroundResource(changeFonButtonPage5.execute())
                }else{
                    viewModel.changeChiken(false)
//                    textPage5Chiken.setBackgroundResource(changeFonButtonPage5NoPress.execute())
                }
            }
            textPage5Turkey.setOnCheckedChangeListener{_, isChecked->
                if (isChecked){
                    viewModel.changeTurkey(true)
//                    textPage5Turkey.setBackgroundResource(changeFonButtonPage5.execute())
                }else{
                    viewModel.changeTurkey(false)
//                    textPage5Turkey.setBackgroundResource(changeFonButtonPage5NoPress.execute())
                }
            }
            page5ButtonPork.setOnCheckedChangeListener{_, isChecked->
                if (isChecked){
                    viewModel.changePork(true)
//                    page5ButtonPork.setBackgroundResource(changeFonButtonPage5.execute())
                }else{
                    viewModel.changePork(false)
//                    page5ButtonPork.setBackgroundResource(changeFonButtonPage5NoPress.execute())
                }
            }
            page5Beef.setOnCheckedChangeListener{_, isChecked->
                if (isChecked){
                    viewModel.changeBeef(true)
//                    page5Beef.setBackgroundResource(changeFonButtonPage5.execute())
                }else{
                    viewModel.changeBeef(false)
//                    page5Beef.setBackgroundResource(changeFonButtonPage5NoPress.execute())
                }
            }
            page5ButtonFish.setOnCheckedChangeListener{_, isChecked->
                if (isChecked){
                    viewModel.changeFish(true)
//                    page5ButtonFish.setBackgroundResource(changeFonButtonPage5.execute())
                }else{
                    viewModel.changeFish(false)
//                    page5ButtonFish.setBackgroundResource(changeFonButtonPage5NoPress.execute())
                }
            }
            page5Seafood.setOnCheckedChangeListener{_, isChecked->
                if (isChecked){
                    viewModel.changeSeafood(true)
//                    page5Seafood.setBackgroundResource(changeFonButtonPage5.execute())
                }else{
                    viewModel.changeSeafood(false)
//                    page5Seafood.setBackgroundResource(changeFonButtonPage5NoPress.execute())
                }
            }
            page5ButtonWithoutMeat.setOnCheckedChangeListener{_, isChecked->
                if (isChecked){
                    viewModel.changeWithoutMeat(true)
//                    page5ButtonWithoutMeat.setBackgroundResource(changeFonButtonPage5.execute())
//                    textPage5Chiken.setBackgroundResource(changeFonButtonPage5NoPress.execute())
//                    textPage5Turkey.setBackgroundResource(changeFonButtonPage5NoPress.execute())
//                    page5ButtonPork.setBackgroundResource(changeFonButtonPage5NoPress.execute())
//                    page5Beef.setBackgroundResource(changeFonButtonPage5NoPress.execute())
                }else{
                    viewModel.changeWithoutMeat(false)
//                    page5ButtonWithoutMeat.setBackgroundResource(changeFonButtonPage5NoPress.execute())
                }
            }
            textPage5WithoutFish.setOnCheckedChangeListener{_, isChecked->
                if (isChecked){
                    viewModel.changeWithoutFish(true)
//                    textPage5WithoutFish.setBackgroundResource(changeFonButtonPage5.execute())
//                    page5ButtonFish.setBackgroundResource(changeFonButtonPage5NoPress.execute())
//                    page5Seafood.setBackgroundResource(changeFonButtonPage5NoPress.execute())
                }else{
                    viewModel.changeWithoutFish(false)
//                    textPage5WithoutFish.setBackgroundResource(changeFonButtonPage5NoPress.execute())
                }
            }
        }
//        binding.page5ButtonWithoutMeat.setBackgroundResource(changeFonButtonPage5.execute())
//        binding.textPage5Chiken.setBackgroundResource(changeFonButtonPage5NoPress.execute())
//        binding.textPage5Turkey.setBackgroundResource(changeFonButtonPage5NoPress.execute())
//        binding.page5ButtonPork.setBackgroundResource(changeFonButtonPage5NoPress.execute())
//        binding.page5Beef.setBackgroundResource(changeFonButtonPage5NoPress.execute())
//
//        binding.textPage5WithoutFish.setBackgroundResource(changeFonButtonPage5.execute())
//        binding.page5ButtonFish.setBackgroundResource(changeFonButtonPage5NoPress.execute())
//        binding.page5Seafood.setBackgroundResource(changeFonButtonPage5NoPress.execute())

        viewModel.live_text_page5_chiken.observe(viewLifecycleOwner, Observer{
            if (it){
                binding.textPage5Chiken.setBackgroundResource(changeFonButtonPage5.execute())
            }else{
                binding.textPage5Chiken.setBackgroundResource(changeFonButtonPage5NoPress.execute())
            }
        })
        viewModel.live_text_page5_turkey.observe(viewLifecycleOwner, Observer{
            if (it){
                binding.textPage5Turkey.setBackgroundResource(changeFonButtonPage5.execute())
            }else{
                binding.textPage5Turkey.setBackgroundResource(changeFonButtonPage5NoPress.execute())
            }
        })
        viewModel.live_page5_button_pork.observe(viewLifecycleOwner, Observer{
            if (it){
                binding.page5ButtonPork.setBackgroundResource(changeFonButtonPage5.execute())
            }else{
                binding.page5ButtonPork.setBackgroundResource(changeFonButtonPage5NoPress.execute())
            }
        })
        viewModel.live_page5_beef.observe(viewLifecycleOwner, Observer{
            if (it){
                binding.page5Beef.setBackgroundResource(changeFonButtonPage5.execute())
            }else{
                binding.page5Beef.setBackgroundResource(changeFonButtonPage5NoPress.execute())
            }
        })
        viewModel.live_page5_button_fish.observe(viewLifecycleOwner, Observer{
            if (it){
                binding.page5ButtonFish.setBackgroundResource(changeFonButtonPage5.execute())
            }else{
                binding.page5ButtonFish.setBackgroundResource(changeFonButtonPage5NoPress.execute())
            }
        })
        viewModel.live_page5_seafood.observe(viewLifecycleOwner, Observer{
            if (it){
                binding.page5Seafood.setBackgroundResource(changeFonButtonPage5.execute())
            }else{
                binding.page5Seafood.setBackgroundResource(changeFonButtonPage5NoPress.execute())
            }
        })
        viewModel.live_page5_button_without_meat.observe(viewLifecycleOwner, Observer{
            if (it){
                binding.page5ButtonWithoutMeat.setBackgroundResource(changeFonButtonPage5.execute())
                binding.textPage5Chiken.setBackgroundResource(changeFonButtonPage5NoPress.execute())
                binding.textPage5Turkey.setBackgroundResource(changeFonButtonPage5NoPress.execute())
                binding.page5ButtonPork.setBackgroundResource(changeFonButtonPage5NoPress.execute())
                binding.page5Beef.setBackgroundResource(changeFonButtonPage5NoPress.execute())
            }else{
                binding.page5ButtonWithoutMeat.setBackgroundResource(changeFonButtonPage5NoPress.execute())
            }
        })
        viewModel.live_text_page5_without_fish.observe(viewLifecycleOwner, Observer{
            if (it){
                binding.textPage5WithoutFish.setBackgroundResource(changeFonButtonPage5.execute())
                binding.page5ButtonFish.setBackgroundResource(changeFonButtonPage5NoPress.execute())
                binding.page5Seafood.setBackgroundResource(changeFonButtonPage5NoPress.execute())
            }else{
                binding.textPage5WithoutFish.setBackgroundResource(changeFonButtonPage5NoPress.execute())
            }
        })


        binding.textBack.setOnClickListener {
//            if (modifiedButton){viewModel.createLocalDataPage4()}
            findNavController().popBackStack()
        }
        binding.textNext.setOnClickListener {
            val action: NavDirections =
                Pg5SourceProteinFragmentDirections.actionPg5SourceProteinFragmentToPg6SourceFiberFragment(
                    args.currentUser, viewModel.dataUser)
            findNavController().navigate(action)
        }

    }

}