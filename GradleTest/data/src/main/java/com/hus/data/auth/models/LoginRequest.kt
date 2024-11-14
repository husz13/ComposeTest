package com.hus.data.auth.models

import com.google.gson.annotations.SerializedName


data class LoginRequest(
    @SerializedName("password") val password: String? = null,
    @SerializedName("phone") val phone: String? = null
)