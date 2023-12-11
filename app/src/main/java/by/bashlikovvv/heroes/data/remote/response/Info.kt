package by.bashlikovvv.heroes.data.remote.response

import com.google.gson.annotations.SerializedName

data class Info(
    @SerializedName("nextPage") val nextPage: String? = "",
    @SerializedName("count") val count: Int? = 0,
    @SerializedName("totalPages") val totalPages: Int? = 0
)