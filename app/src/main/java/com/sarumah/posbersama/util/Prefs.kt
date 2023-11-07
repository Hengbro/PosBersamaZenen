package com.sarumah.posbersama.util

import com.chibatching.kotpref.KotprefModel

object Prefs : KotprefModel() {
    var isLogin by booleanPref(false)
    var token by nullableStringPref()
    var storeId by stringPref("1")
    var outletId by stringPref("1")
}