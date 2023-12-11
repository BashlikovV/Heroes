package by.bashlikovvv.heroes.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
open class Item(open val id: Int = 0) : Parcelable