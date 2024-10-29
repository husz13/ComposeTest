package com.hus.core.network.models

import com.google.gson.annotations.SerializedName

data class Result<T>(
    @SerializedName("message") val message : String,
    @SerializedName("data") val data : T?,

)
