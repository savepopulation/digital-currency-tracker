package com.raqun.dctracker.model

import com.google.gson.annotations.SerializedName

/**
 * Created by tyln on 12/09/2017.
 */
data class Diff(@SerializedName("id") val id: Int?,
                @SerializedName("name") val name: String?,
                @SerializedName("tl_buy_rate") val buyRate: Double?,
                @SerializedName("tl_sell_rate") val sellRate: Double?)