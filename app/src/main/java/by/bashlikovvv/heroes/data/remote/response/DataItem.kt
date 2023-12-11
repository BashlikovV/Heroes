package by.bashlikovvv.heroes.data.remote.response

import com.google.gson.annotations.SerializedName

data class DataItem(
    @SerializedName("films") val films: List<String?>?,
    @SerializedName("tvShows") val tvShows: List<String?>?,
    @SerializedName("url") val url: String? = "",
    @SerializedName("videoGames") val videoGames: List<String?>?,
    @SerializedName("sourceUrl") val sourceUrl: String? = "",
    @SerializedName("createdAt") val createdAt: String? = "",
    @SerializedName("imageUrl") val imageUrl: String? = "",
    @SerializedName("__v") val V: Int? = 0,
    @SerializedName("name") val name: String? = "",
    @SerializedName("_id") val Id: Int? = 0,
    @SerializedName("updatedAt") val updatedAt: String? = ""
)