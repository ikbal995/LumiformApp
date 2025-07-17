package ikbal.mulalic.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import ikbal.mulalic.data.LumiType
import ikbal.mulalic.data.ui.Section
import java.util.UUID

@Entity
data class SectionEntity(
    @PrimaryKey(autoGenerate = true)
    override val id: Long? = 0,
    override val type: LumiType,
    override val title: String,
    val items: List<BaseEntity>? = emptyList()
) : BaseEntity(type = type, title = title, id = id)

fun SectionEntity.toUiModel() =
    Section(
        type = this.type,
        title = this.title,
        items = this.items?.map { it.toUiModel() }.orEmpty()
    )