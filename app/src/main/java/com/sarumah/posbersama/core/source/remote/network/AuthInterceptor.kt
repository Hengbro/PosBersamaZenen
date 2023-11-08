package com.sarumah.posbersama.core.source.remote.network

import com.inyongtisto.myhelper.extension.def
import com.sarumah.posbersama.util.Constants
import com.sarumah.posbersama.util.Prefs
import okhttp3.Interceptor
import okhttp3.Response

/**
 * Interceptor to add auth token to requests
 */
class AuthInterceptor : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val originalRequest = chain.request()
        val requestBuilder = originalRequest.newBuilder()
            .header(Constants.AUTH_TOKO, Constants.TOKEN_CLIENT)
            .header(Constants.AUTH_TOKEN, Prefs.token.def("token"))
            .header(Constants.STORE_ID, Prefs.storeId)
            .header(Constants.OUTLET_ID, Prefs.outletId)
        val request = requestBuilder.build()
        return chain.proceed(request)
    }
}