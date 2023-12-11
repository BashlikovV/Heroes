package by.bashlikovvv.heroes.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Hero(
    override val id: Int,
    val films: List<String>,
    val games: List<String>,
    val sourceUrl: String,
    val name: String,
    val imageUrl: String
) : Parcelable, Item()