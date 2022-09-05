package com.sergnfitness.domain.models.user

import android.os.Parcelable
import kotlinx.parcelize.Parcelize


data class MenuDayList(val listMenuDay: List<MenuDay> )
@Parcelize
data class MenuDay(
    var id: Int?,
    var id_note:Int,
    var user: String,
    var menu: List<String>,
    var data: String,
    var weight: Double,
):Parcelable
