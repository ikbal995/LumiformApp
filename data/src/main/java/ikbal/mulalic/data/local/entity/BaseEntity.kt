package ikbal.mulalic.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.squareup.moshi.JsonClass
import ikbal.mulalic.data.LumiType
import ikbal.mulalic.data.ui.BaseUiModel

@JsonClass(generateAdapter = true)
@Entity
data class BaseEntity(
    @PrimaryKey(autoGenerate = true) val id: Long? = 0,
    val type: LumiType,
    val title: String,
    val items: List<BaseEntity>? = emptyList(),
    val src: String? = null
)

fun BaseEntity.toUiModel(): BaseUiModel =
    BaseUiModel(
        type = this.type,
        title = this.title,
        items = items?.map { it.toUiModel() }.orEmpty(),
        imageUrl = src
    )