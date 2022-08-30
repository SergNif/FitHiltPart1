package com.sergnfitness.android.fit.presentation.part1

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.NavDirections
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.sergnfitness.android.fit.R
import com.sergnfitness.android.fit.databinding.Pg1FragmentMaFemale1Binding
import com.sergnfitness.android.fit.databinding.Pg2NextBinding
import com.sergnfitness.android.fit.presentation.part1.Pg2NextFragmentDirections.Companion.actionNext2ToDataAgeHightWeight2
import com.sergnfitness.android.fit.presentation.viewModelPart1.Pg2NextViewModel
import com.sergnfitness.data.storage.storageModel.DataUserStorage
import com.sergnfitness.domain.models.user.DataUser
import com.sergnfitness.domain.models.user.User
import dagger.hilt.android.AndroidEntryPoint


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [Pg2NextFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
@AndroidEntryPoint
class Pg2NextFragment : Fragment(R.layout.pg2_next) {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    private val args by navArgs<Pg2NextFragmentArgs>()


    val TAG = "Fragment Page3 DataAgeHightWeight MaFemale1"
    lateinit var binding: Pg2NextBinding
    private val viewModel: Pg2NextViewModel by viewModels<Pg2NextViewModel>()

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
        return inflater.inflate(R.layout.pg2_next, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = Pg2NextBinding.bind(view)

        Log.e(TAG, "budle bundle ${this.args}")
        binding.textBack.setOnClickListener {
//            if (modifiedButton){viewModel.createLocalDataPage5()}
            findNavController().popBackStack()
        }
        binding.textNext.setOnClickListener {
            val action: NavDirections =
                Pg2NextFragmentDirections.actionNext2ToDataAgeHightWeight2(currentUser = args.currentUser, currentDataUser = args.currentDataUser)        //.actionNext2ToDataAgeHightWeight2(args.currentUser as User)       //actionNext2ToDataAgeHightWeight2
//        if (modifiedButton){viewModel.createLocalDataPage5()}
            findNavController().navigate(action)
        }
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment Next.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            Pg2NextFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}