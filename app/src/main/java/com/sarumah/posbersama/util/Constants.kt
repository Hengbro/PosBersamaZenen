package com.sarumah.posbersama.util

object Constants {

    //    const val urlBase = "https://lite.zenenta.com/"
    const val urlBase = "https://litedev.zenenta.com/"

    var urlStorage = urlBase + "storage"
    //    const val urlStorage = urlBase + "public/storage"

    const val DEFAULT_ERROR: String = "Terjadi kesalahan"
    const val DB_NAME = "DB_ZENENTA"
    const val DB_VERSION = 4

    const val LAUNDRY_MODE = false
    const val BOOKING_MODE = false
    private val mToken = "official"

    val TOKEN_CLIENT = mToken
    val SLUG_CLIENT = mToken

    const val AUTH_TOKEN = "token"
    const val STORE_ID = "storeId"
    const val OUTLET_ID = "outletId"
    const val AUTH_TOKO = "tokenToko"

}