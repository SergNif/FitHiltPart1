package com.sergnfitness.android.fit.presentation.part1

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.NavDirections
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.sergnfitness.android.fit.R
import com.sergnfitness.android.fit.databinding.Pg1FragmentMaFemale1Binding


import com.sergnfitness.android.fit.presentation.controlUI.ChangeFonButtonPage5
import com.sergnfitness.android.fit.presentation.controlUI.ChangeFonButtonPage5NoPress
import com.sergnfitness.android.fit.presentation.login.LoginFragmentArgs
import com.sergnfitness.android.fit.presentation.viewModelPart1.Pg1MaleFemaleViewModel
import com.sergnfitness.data.storage.storageModel.DataUserStorage
import com.sergnfitness.domain.models.user.DataUser
import com.sergnfitness.domain.models.user.User
import com.sergnfitness.domain.util.Resource
import dagger.hilt.android.AndroidEntryPoint


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [Pg1MaleFemale.newInstance] factory method to
 * create an instance of this fragment.
 */
@AndroidEntryPoint
class Pg1MaleFemale : Fragment() {

    // TODO: Rename and change types of parameters
    var param1: String? = null
    var param2: String? = null

    lateinit var paramUser: User

    val TAG = "Fragment Page1 MaFemale1 "
    lateinit var binding: Pg1FragmentMaFemale1Binding
    private val args: Pg1MaleFemaleArgs by navArgs<Pg1MaleFemaleArgs>()

//    lateinit var vmFactory: Pg1MaleFemaleViewModelFactory
//    lateinit var viewModel: Pg1MaleFemaleViewModel

    private val viewModel: Pg1MaleFemaleViewModel by viewModels()

//    lateinit var viewModelFactory: Pg1MaleFemaleViewModelFactory
    val changeFonButtonPage5 = ChangeFonButtonPage5()

    val changeFonButtonPage5NoPress = ChangeFonButtonPage5NoPress()

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
        return inflater.inflate(R.layout.pg1_fragment_ma_female1, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = Pg1FragmentMaFemale1Binding.bind(view)
        val bundle = Bundle()

        showParamOnDisplay()

        binding.imageViewBoy.setOnClickListener {
//            val textv = binding.editTextPage1.t ext
            viewModel.save(binding.editTextPage1.text.toString())
            binding.imageViewGirl.setBackgroundResource(changeFonButtonPage5.execute())
            binding.imageViewBoy.setBackgroundResource(changeFonButtonPage5NoPress.execute())
//            viewModel.getuserOfIdApiViewModel(5)
            viewModel.queryOfId(binding.editTextPage1.text.toString().toInt())
        }

        binding.imageViewGirl.setOnClickListener {
//            val userName: User = getUserNameUseCase.execute()

            viewModel.load()  // "Save ${userName.email} = ${userName.password}"
            binding.imageViewBoy.setBackgroundResource(changeFonButtonPage5.execute())
            binding.imageViewGirl.setBackgroundResource(changeFonButtonPage5NoPress.execute())
        }



    binding.image.setOnClickListener {
        val action: NavDirections = Pg1MaleFemaleDirections.actionPg1MaleFemale1ToNext2(args.currentUser, args.currentDataUser )
//        findNavController().navigate(R.id.action_pg1MaleFemale1_to_next2)
        findNavController().navigate(action)
    }

        viewModel.userResourceLiveData.observe(viewLifecycleOwner) { responce ->
            when(responce) {
                is Resource.Success -> {
                    Log.e(TAG, " Resource.Success  ${responce.data.toString()}")


//                    viewModel.userLiveData.value.toString().let { binding.textPage1.text = it.toString()}
                    responce.data?.let {
                        Log.e(TAG, "$it")
                        //newsAdapter.differ.submitList(it.articles)
                        paramUser = it as User
                        binding.textPage1.text = it.toString()
                    }
                    binding.loading.visibility = View.INVISIBLE
                }
                is Resource.Error -> {
                    Log.e(TAG, " Resource.Error  ${responce.message.toString()}")

                    Toast.makeText(requireContext(), responce.message, Toast.LENGTH_LONG).show()
//                    responce.data?.let {
//                        Log.e("checkData", "MainFragment: error: ${it}")
//                    }
                    binding.loading.visibility = View.INVISIBLE
                }
                is Resource.Loading -> {
                    Log.e(TAG, " Resource.Loading  $responce")
                    binding.loading.visibility = View.VISIBLE
                }
            }
        }



    }

    private fun showParamOnDisplay() {
        if(args.currentDataUser.man){
            binding.imageViewBoy.setBackgroundResource(changeFonButtonPage5.execute())
            binding.imageViewGirl.setBackgroundResource(changeFonButtonPage5NoPress.execute())
        }else{
            binding.imageViewBoy.setBackgroundResource(changeFonButtonPage5NoPress.execute())
            binding.imageViewGirl.setBackgroundResource(changeFonButtonPage5.execute())

        }

    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment MaFemale1.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            Pg1MaleFemale().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}