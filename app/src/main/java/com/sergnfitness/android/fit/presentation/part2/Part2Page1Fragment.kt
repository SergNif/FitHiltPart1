package com.sergnfitness.android.fit.presentation.part2

import android.app.DatePickerDialog
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.util.Pair
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.navigation.NavDirections
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.github.mikephil.charting.data.LineData
import com.google.android.material.datepicker.MaterialDatePicker
import com.google.android.material.snackbar.Snackbar
import com.sergnfitness.android.fit.R
import com.sergnfitness.android.fit.databinding.FragmentPart2Page1Binding
import com.sergnfitness.android.fit.presentation.controlUI.ChangeFonButtonPage5
import com.sergnfitness.android.fit.presentation.controlUI.ChangeFonButtonPage5NoPress
import com.sergnfitness.android.fit.presentation.part1.Pg10BadHabbitsFragmentDirections
import com.sergnfitness.android.fit.presentation.part2.part2viewModel.Part2Page1ViewModel
import com.sergnfitness.domain.models.UserMenuDay
import com.sergnfitness.domain.models.user.MenuDayList
import dagger.hilt.android.AndroidEntryPoint
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.*

@AndroidEntryPoint
class Part2Page1Fragment : Fragment() {

    companion object {
        fun newInstance() = Part2Page1Fragment()
    }

    private val taG = "Part2Page1Fragment "
    private val viewModel: Part2Page1ViewModel by viewModels()
    private lateinit var binding: FragmentPart2Page1Binding
    private val args: Part2Page1FragmentArgs by navArgs()

    private val changeFonButtonPage5NoPress = ChangeFonButtonPage5()
    private val changeFonButtonPage5 = ChangeFonButtonPage5NoPress()
    lateinit var oneMenuDay: UserMenuDay
    val c: Calendar = Calendar.getInstance()
    var dd = c.get(Calendar.DAY_OF_MONTH)
    var mn = c.get(Calendar.MONTH)
    var ye = c.get(Calendar.YEAR)
    val hh = c.get(Calendar.HOUR_OF_DAY)
    var mm = c.get(Calendar.MINUTE)

    var dyear: String = LocalDateTime.now().toString().split("T")[0].split("-")[0]
    var dmonth: String = LocalDateTime.now().toString().split("T")[0].split("-")[1]
    var dday: String = LocalDateTime.now().toString().split("T")[0].split("-")[2]
    var new_weigt_today: String = ""

    private val chartStyle by lazy(LazyThreadSafetyMode.NONE) {
        SparkLineStyle(context = requireActivity())
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        return inflater.inflate(R.layout.fragment_part2_page1, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentPart2Page1Binding.bind(view)
        viewModel.dataUser = args.currentDataUser
        viewModel.userClass = args.currentUser

        backToFragment()
        fun String.toEditable(): Editable = Editable.Factory.getInstance().newEditable(this)

        val current = LocalDateTime.now()
        val formatter = DateTimeFormatter.ofPattern("dd MMMM yyyy")
        val formatted = current.format(formatter)
        binding.textAllRightPart2Page1.text = "$formatted"
        binding.textNameUserPart2Page1.text = viewModel.userClass.fullName
        binding.textIdPart2Page1.text = "ID ${viewModel.userClass.id.toString()}"
        binding.part2page1ButtonHeight.text = "Рост ${viewModel.dataUser.height.toString()}"
        binding.part2page1ButtonAge.text = "Возраст ${viewModel.dataUser.age.toString()}"
        binding.part2page1ButtonWeight.text = "Вес ${viewModel.dataUser.weight.toString()}"
        binding.inputWeight.hint = "Вес ${viewModel.dataUser.weight.toString()}"
//        binding.inputWeight.text = "Вес $new_weigt_today".toEditable()

        binding.lynInputWeight.isVisible = false
        binding.lynLynDatePicker.isVisible = false
        binding.inputWeight.isVisible = false
        binding.okDatapicker.isVisible = false

        binding.part2page1ButtonHistoryWeight.setOnClickListener {
//            showDatePickerDialog()
            showDatePickerDialogRange()
        }
        binding.part2page1ButtonHistoryData.setOnClickListener {
//            showDatePickerDialog()
//            showDatePickerDialogOne()
            onClickHistoryWeightDiagramm(view)
        }
        binding.okInputWeight.setOnClickListener {
            onClickOkInputWeight()
        }
        binding.okDatapicker.setOnClickListener {
            onClickOkDatePicker()
        }

        binding.inputWeight.addTextChangedListener(object : TextWatcher{
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                binding.inputWeight.hint = "" //"Вес ${viewModel.dataUser.weight.toString()}"
            }
            override fun afterTextChanged(p0: Editable?) {
             if (binding.inputWeight.text.isNullOrEmpty()){
                 binding.inputWeight.hint = "Вес ${viewModel.dataUser.weight.toString()}"
             }
            }
        }
        )


        binding.textBack.setOnClickListener {
            backToFragment()
        }

        viewModel.lineDataSet.observe(viewLifecycleOwner) { lineDataSet ->
            chartStyle.styleLineDataSet(lineDataSet)
            binding.dayChart.data = LineData(lineDataSet)
            binding.dayChart.invalidate()
        }

        val today = Calendar.getInstance()
        binding.lynDatePicker.init(today.get(Calendar.YEAR), today.get(Calendar.MONTH),
            today.get(Calendar.DAY_OF_MONTH)

        ) { view, year, month, day ->
            val month = month + 1
            val msg = "You Selected: $day/$month/$year"
            dmonth = "%02d".format(month)
            dday = "%02d".format(day)
            dyear = "%02d".format(year)
            viewModel.dataUser.weight = new_weigt_today.toString()
            Toast.makeText(context, msg, Toast.LENGTH_SHORT).show()
        }
        binding.textBack.setOnClickListener {
            findNavController().popBackStack()
        }
        binding.exitButton.setOnClickListener {
            Log.e(taG, "viewModel.dataUser   ${viewModel.dataUser}")
            Log.e(taG, "${args.currentUser}")
//            args.currentUser.email?.let { it1 -> viewModel.createDataUserOnServer(it1) }
            val action: NavDirections =
                Pg10BadHabbitsFragmentDirections.actionPg10BadHabbitsFragmentToPart2Page1Fragment(
                    args.currentUser, viewModel.dataUser)
            findNavController().navigate(action)
        }
//        with(viewLifecycleOwner){
//            viewModel.endDataAPI.observe{
//                binding.textDataRightPart2Page1.setText("c ${viewModel.startData.value} по ${viewModel.endData.value}")
//            }
//            viewModel.endData.observe{
//                binding.textDataRightPart2Page1.setText("c ${viewModel.startData.value} по ${viewModel.endData.value}")
//            }
//            viewModel.startDataAPI.observe{
//                binding.textDataRightPart2Page1.setText("c ${viewModel.startData.value} по ${viewModel.endData.value}")
//            }
//            viewModel.startData.observe{
//                binding.textDataRightPart2Page1.setText("c ${viewModel.startData.value} по ${viewModel.endData.value}")
//            }
//
//        }
        Observer<LiveData<String>>() { it ->
            when (it) {
                viewModel.endData -> {
                    binding.textDataRightPart2Page1.setText("c ${viewModel.startData.value} по ${viewModel.endData.value}")
                }
                viewModel.startData -> {
                    binding.textDataRightPart2Page1.setText("c ${viewModel.startData.value} по ${viewModel.endData.value}")
                }
                viewModel.endDataAPI -> {
                    binding.textDataRightPart2Page1.setText("c ${viewModel.startData.value} по ${viewModel.endData.value}")
                }
                viewModel.startDataAPI -> {
                    binding.textDataRightPart2Page1.setText("c ${viewModel.startData.value} по ${viewModel.endData.value}")
                }
            }
        }

    }

    private fun showDatePickerDialogOne() {
        val month_date = SimpleDateFormat("MMMM")
        val month_name: String = month_date.format(c.getTime())
//eee
//        val timePickerDialog: TimePickerDialog =TimePickerDialog(requireContext(),TimePickerDialog.OnTimeSetListener { view, hourOfDay, minute ->
//            binding.textDataRightPart2Page1.text = " $hourOfDay :  $minute"
//        },hh,mm,true)
//        timePickerDialog.show()
//        Log.e(taG, "$mm $hh $dd $mn $ye")
        val datepickerdialog: DatePickerDialog = DatePickerDialog(requireContext(),
            DatePickerDialog.OnDateSetListener { _, year, monthOfYear, dayOfMonth ->

                // Display Selected date in textbox
                run {
                    var datte = LocalDate.of(year, monthOfYear, dayOfMonth)
                    val formater = DateTimeFormatter.ofPattern("dd MMMM yyyy")
                    binding.textDataRightPart2Page1.text = datte.format(formater)
                    dd = dayOfMonth
                    mn = monthOfYear
                    ye = year
                    Log.e(taG, "$dd $mn $ye")
                }
            },
            ye,
            mn,
            dd)

        datepickerdialog.show()
        Log.e(taG, "$dd $hh $dd $mn $ye")

    }

    private fun backToFragment() {
        Log.e(taG, "clickkkkkkkkkkk")
//        Log.e(taG, "${sharedViewModels._data3.age}")
        binding.xyPlotChart.isVisible = false
        binding.parametrsButtonsChart.isVisible = true
    }

    private fun showDatePickerDialogRange() {
        var dateRangeSelected: String
        val dateRangePicker = MaterialDatePicker.Builder.dateRangePicker()
            .setTitleText("Выберите даты")
            .setSelection(Pair(MaterialDatePicker.thisMonthInUtcMilliseconds(),
                MaterialDatePicker.todayInUtcMilliseconds()))
            .build()
        dateRangePicker.addOnPositiveButtonClickListener { it ->
            viewModel.formatDataPicker(it)
            viewModel.formatDataPickerAPI(it)
            Log.e(taG,
                " PICKER    ${viewModel.startDataAPI.value.toString()}     ${viewModel.endDataAPI.value.toString()}      ")
            Log.e(taG,
                " PICKER    ${viewModel.startData.value.toString()}     ${viewModel.endData.value.toString()}      ")
            viewModel.launchGetMenuList(viewModel.startDataAPI.value.toString(),
                viewModel.endDataAPI.value.toString())
            viewModel.recyclerListData.value?.let { it1 ->
                viewModel.funListWeightForChart(it1.listMenuDay)
            }

            viewModel.getMenuListObserverable()
                .observe(viewLifecycleOwner, Observer<MenuDayList> {
                    if (it == null) {
                        Log.e(taG, "${it}")
                    } else {
                        viewModel.funListWeightForChart(it.listMenuDay)
                    }
                })


//            dateRangeSelected = outputDateFormat.format(it.first).toString() + " - " + outputDateFormat.format(it.second).toString()
//            binding.textDataRightPart2Page1.text = "Выбраны даты: ${viewModel.startData} - ${viewModel.endData}"
            binding.xyPlotChart.isVisible = true
            binding.parametrsButtonsChart.isVisible = false
//            viewModel.saveDataStartDataCalendar(startData = viewModel.startData.value.toString(),
//                endData = viewModel.endData.value.toString())
        }

        dateRangePicker.addOnNegativeButtonClickListener {
            binding.textDataRightPart2Page1.text = ""
            Snackbar.make(binding.textDataRightPart2Page1,
                "No date is selected",
                Snackbar.LENGTH_LONG).show()
        }

        dateRangePicker.show(parentFragmentManager, "Data Picker")
    }

    //*********  DATA PICKER ************

    fun onClickHistoryWeightDiagramm(view: View) {
//        showSmallDatePicker()
        binding.lynLynDatePicker.isVisible = true
        binding.inputWeight.isVisible = true
        binding.okDatapicker.isVisible = true
        binding.lynWeightHistory.isVisible = false
        binding.lynInputWeight.isVisible = true
        binding.footerImage.isVisible = false
        binding.parametrsButtonsChart.isVisible = false
        Toast.makeText(context, "Click", Toast.LENGTH_SHORT).show()
    }

    private fun onClickOkInputWeight() {
//        binding.lynLynDatePicker.isVisible = false
//        binding.inputWeight.isVisible = false
//        binding.lynInputWeight.isVisible = false
//        binding.okDatapicker.isVisible = false
//        binding.lynWeightHistory.isVisible = true
//        binding.footerImage.isVisible = true
//        binding.parametrsButtonsChart.isVisible = true
        new_weigt_today = binding.inputWeight.text.toString()
//        viewModel.dataUser.weight = new_weigt_today
        viewModel.changeWeght(binding.inputWeight.text.toString(), "$dyear-$dmonth-${dday}r")
        Log.e(taG, "onClickOkInputWeight  ${viewModel.dataUser.weight} ${dyear}-${dmonth}-${dday}")

        viewModel.launchUpdateDataPage3()

        setOneMenuDay()
        viewModel.launchPostMenuDay(oneMenuDay, 0)
    }

    private fun onClickOkDatePicker() {
        onClickOkInputWeight()
        binding.lynLynDatePicker.isVisible = false
        binding.inputWeight.isVisible = false
        binding.lynInputWeight.isVisible = false
        binding.okDatapicker.isVisible = false
        binding.lynWeightHistory.isVisible = true
        binding.footerImage.isVisible = true
        binding.parametrsButtonsChart.isVisible = true
    }

    fun setOneMenuDay() {
        if (new_weigt_today.isNullOrEmpty()) {
            new_weigt_today = viewModel.dataUser.desired_weight
        }
        Log.e(taG, "setOneMenuDay ssssssssss ${viewModel.dataUser.desired_weight}")
        oneMenuDay =
            viewModel.dataUser.id?.let {
                viewModel.createUserMenuDay(
                    id = it,
                    age = viewModel.dataUser.age,
                    date = "${dyear}-${dmonth}-${dday}",//funcData(),
                    time = funcTime(),
                    desired_weight = viewModel.dataUser.desired_weight.toDouble(),
                    height = viewModel.dataUser.height,
                    weight = new_weigt_today.toDouble(),//  binding.weightOneMenuDay.text.toString().toDouble(),
                    //userParam.weight.toDouble(),
                    fitness_id = it,
                    header = "weight", //binding.headerMenuDay.text.toString(),
                    menu = "weight" //binding.menuDay.text.toString(),
                )
            }!!
    }

    private fun funcTime(): String {
        return LocalDateTime.now().toString().split(".")[0].split("T")[1].split(":").slice(0..1)
            .joinToString(
                //   prefix = "[",
                separator = ":",
                // postfix = "]",
                //limit = 3,
                //truncated = "...",
                //transform = { it.uppercase() }
            )
    }
//*********  DATA PICKER ************


//    fun onClickHistoryWeightDiagramm(view: View) {
//        val c = Calendar.getInstance()
//        val year = c.get(Calendar.YEAR)
//        val month = c.get(Calendar.MONTH)
//        val day = c.get(Calendar.DAY_OF_MONTH)
//
//        val dpd = DatePickerDialog(requireContext(), DatePickerDialog.OnDateSetListener { view, year, monthOfYear, dayOfMonth ->
//            // Display Selected date in Toast
//            Toast.makeText(requireContext(), """$dayOfMonth - ${monthOfYear + 1} - $year""", Toast.LENGTH_LONG).show()
//
//        }, year, month, day)
//        dpd.show()
//    }


}
