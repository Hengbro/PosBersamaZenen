package com.sarumah.posbersama.core.source.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class User(
    var id: Int = 0,
    var name: String = "",
    var phone: String? = null,
    var email: String = "",
    var password: String = "",
    var token: String? = null,
    var status: String = "",
    var type: String = "",
    var role: String = "",
    var updated_at: String = "",
    var created_at: String = "",
    var photo: String = "",
    var isReseller: Boolean = false,
    var image: String? = null,
    var fcm: String? = null,
    var referral: String? = null,
    var pin: String? = null,
    var dummy: String? = null,
) : Parcelable