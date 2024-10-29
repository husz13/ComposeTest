package com.hus.data.auth.models

import com.google.gson.annotations.SerializedName

data class LoginResponse(
    @SerializedName("id") val id: Int? = null,
    @SerializedName("avatar") val avatar: String? = null,
    @SerializedName("name") val name: String? = null,
    @SerializedName("phone") val phone: String? = null,
    @SerializedName("zone_id") val zoneId: Int? = null
)
