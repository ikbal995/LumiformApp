package ikbal.mulalic.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import ikbal.mulalic.data.LumiType
import ikbal.mulalic.data.ui.Section

@Entity
data class SectionEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long? = 0,
    val type: LumiType,
    val title: String,
    val items: List<BaseEntity>? = emptyList()
)

fun SectionEntity.toUiModel() =
    Section(
        type = this.type,
        title = this.title,
        items = this.items?.map { it.toUiModel() }.orEmpty()
    )