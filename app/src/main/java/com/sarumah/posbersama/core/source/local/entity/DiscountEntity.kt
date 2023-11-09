package com.sarumah.posbersama.core.source.local.entity


import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity
data class DiscountEntity (

    @PrimaryKey
    var id: Int = 0,
    var clientId: Int = 0,
    var storeId: Int = 0,
    var name : String? = null,
    var type : String? = null,
    var discount : String? = null,
    var maxDiscount : String? = null,

): Parcelable