package com.raqun.dctracker.model

import com.google.gson.annotations.SerializedName

/**
 * Created by tyln on 12/09/2017.
 */
data class Diff(@SerializedName("currency") val currency: String?,
                @SerializedName("value") val value: Double?)