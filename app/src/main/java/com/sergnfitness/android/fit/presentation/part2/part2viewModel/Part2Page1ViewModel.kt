package com.sergnfitness.android.fit.presentation.part2.part2viewModel

import android.util.Log
import androidx.core.util.Pair
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineDataSet
import com.sergnfitness.android.fit.presentation.adapter.RecyclerViewAdapter
import com.sergnfitness.domain.models.user.DataUser
import com.sergnfitness.domain.models.user.MenuDay
import com.sergnfitness.domain.models.user.MenuDayList
import com.sergnfitness.domain.models.user.User
import com.sergnfitness.domain.repository.ApiRepository
import com.sergnfitness.domain.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.text.SimpleDateFormat
import java.time.LocalDateTime
import java.util.*
import javax.inject.Inject

@HiltViewModel
class Part2Page1ViewModel @Inject constructor(
    private val apiRepository: ApiRepository,
) : ViewModel() {


    val taG = "Part2Page1ViewModel "

    lateinit var userClass: User
    lateinit var dataUser: DataUser
    lateinit var listMenuDay: List<MenuDay>
    lateinit var recyclerViewAdapter: RecyclerViewAdapter
    private var _startData: MutableLiveData<String> =
        MutableLiveData(LocalDateTime.now().plusDays(0).toString().split("T")[0])
    val startData: LiveData<String>
        get() = _startData

    private var _endData: MutableLiveData<String> =
        MutableLiveData(LocalDateTime.now().plusDays(1).toString().split("T")[0])
    val endData: LiveData<String>
        get() = _endData

    private var _startDataAPI: MutableLiveData<String> =
        MutableLiveData(LocalDateTime.now().plusDays(0).toString().split("T")[0])
    val startDataAPI: LiveData<String>
        //    formatterDD_MMM_YYYY.format(formatterYYYY_MM_DD.parse(_startDataAPI.value.toString()))
        get() = _startDataAPI

    private var _endDataAPI: MutableLiveData<String> =
        MutableLiveData(LocalDateTime.now().plusDays(1).toString().split("T")[0])
    val endDataAPI: LiveData<String>
        get() = _endDataAPI

    private var _pickerCalendarData = MutableLiveData<Pair<Long, Long>>()
    val pickerCalendarData: MutableLiveData<Pair<Long, Long>>
        get() = _pickerCalendarData

    private var _listWeightForChart = mutableListOf<Entry>()
    val listWeightForChart: MutableList<Entry>
        get() = _listWeightForChart

    private val CHART_LABEL = "DAY_CHART"
    private val _lineDataSet = MutableLiveData(LineDataSet(listWeightForChart, CHART_LABEL))
    val lineDataSet: LiveData<LineDataSet> = _lineDataSet


    private val _userResourceLiveData = MutableLiveData<Resource<Any>>()
    val userResourceLiveData: LiveData<Resource<Any>> = _userResourceLiveData

    private val _dataUserResourceLiveData = MutableLiveData<Resource<Any>>()
    val dataUserResourceLiveData: LiveData<Resource<Any>> = _dataUserResourceLiveData

    private val _menuDayResourceLiveData = MutableLiveData<Resource<Any>>()
    val menuDayResourceLiveData: LiveData<Resource<Any>> = _menuDayResourceLiveData

    private val _menuDayListLiveData = MutableLiveData<MenuDayList?>()
    val menuDayListLiveData: LiveData<MenuDayList?> = _menuDayListLiveData

    lateinit var recyclerListData: MutableLiveData<MenuDayList>

    val sdf = SimpleDateFormat("dd/M/yyyy hh:mm:ss")
    init {
        recyclerListData = MutableLiveData<MenuDayList>()
    }
    fun getMenuListObserverable():MutableLiveData<MenuDayList>{
        return recyclerListData
    }

    fun formatDataPickerAPI(picker: Pair<Long, Long>? = pickerCalendarData.value) {
        if (picker != null) {
            _startDataAPI.value = outputDateFormatAPI.format(picker.first)
            Log.e(taG, " PICKER  ${_startDataAPI.value.toString()}")
        }
        if (picker != null) {
            _endDataAPI.value = outputDateFormatAPI.format(picker.second)
            Log.e(taG, " PICKER  ${_endDataAPI.value.toString()}")
        }
    }
//    fun saveDataStartDataCalendar(startData: String, endData: String) {
//        val saveDataShared: Boolean =
//            saveUserNameUseCase.executeSaveData(startData = startData, endData = endData)
//    }

    val outputDateFormat = SimpleDateFormat("dd MMM yyyy", Locale.getDefault()).apply {
        timeZone = TimeZone.getTimeZone("UTC")
    }

    val outputDateFormatAPI = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).apply {
        timeZone = TimeZone.getTimeZone("UTC")
    }

    fun formatDataPicker(picker: Pair<Long, Long>?) {

        if (picker != null) {
            _startData.value = outputDateFormat.format(picker.first).toString()
        }
        if (picker != null) {
            _endData.value = outputDateFormat.format(picker.second).toString()
        }
        _pickerCalendarData.value = picker
    }

    //*******  RETROFIT *****
    fun launchGetMenuList(startData: String, endData: String) = viewModelScope.launch {
        delay(500)
        userClass.id?.let { getMenuList(it, startData, endData) }
    }


    private suspend fun getMenuList(id: Int, startData: String, endData: String) {
        _menuDayResourceLiveData.postValue(Resource.Loading())
        Log.e(taG, " API query startData ${startData}  endData ${endData}")

        val call =
            apiRepository.getMenuDayStrings(id = id, startDate = startData, endDate = endData)


//        val retrofitInstance = RetrofitInstance.getRetroInstance().create(RetroService::class.java)
//        val call = retrofitInstance.getMenuStrings(id = getIdFromSharedPreferenses(), date = LocalDateTime.now().plusDays(dateMenuRecyle).toString().split("T")[0])
//        val call = retrofitInstance.getMenuStrings(id = getIdFromSharedPreferenses(), startDate = startData, endDate = endData)
        call.enqueue(object : Callback<MenuDayList> {
            override fun onFailure(call: Call<MenuDayList>, t: Throwable) {
                Log.e(taG, "Get Menu List NULL")
                _menuDayResourceLiveData.postValue(Resource.Error(t.message.toString()))
                _menuDayListLiveData.postValue(null)
                recyclerListData.postValue(null)
            }

            override fun onResponse(call: Call<MenuDayList>, response: Response<MenuDayList>) {
                _menuDayResourceLiveData.postValue(Resource.Loading(response))
                Log.e(taG, "Get Menu List IS ${response.body()}")
                if (response.isSuccessful && response.body() != null) {
                    response.body().let { res ->
                        _menuDayListLiveData.postValue(res)
                        recyclerListData.postValue(res)
                    }
                } else {
                    Log.e(taG, "Get Menu List ELSE ${response.body()}")
                    _menuDayListLiveData.postValue(null)
                    _menuDayResourceLiveData.postValue(Resource.Error("${response.message()} No this data"))
                    recyclerListData.postValue(null)
                }
            }
        }
        )
    }
    //*******  RETROFIT *****

    fun funListWeightForChart(listMenuDay: List<MenuDay>): MutableList<Entry> {
        this.listMenuDay = listMenuDay
        Log.e(taG, "Wiegth ${listMenuDay}")
        listMenuDay.forEachIndexed { index, e ->
            _listWeightForChart.add(Entry(index.toFloat(), e.weight.toFloat()))
            Log.e(taG, "Wiegth ${e.weight.toFloat()}")
        }
        _lineDataSet.value = LineDataSet(listWeightForChart, CHART_LABEL)
        return _listWeightForChart
    }


}

