package com.sarumah.posbersama.core.source.remote.request

/**
 * Created by Tisto on 3/11/2021.
 */

class LoginRequest(
    var name: String? = null,
    var email: String? = null,
    var phone: String? = null,
    var password: String? = null,
    var fcm: String? = null
)