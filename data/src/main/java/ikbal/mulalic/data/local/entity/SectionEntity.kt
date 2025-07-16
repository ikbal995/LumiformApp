package ikbal.mulalic.data.local.entity

import androidx.room.Entity
import ikbal.mulalic.data.LumiType

@Entity
data class SectionEntity(
    override val type: LumiType,
    override val title: String,
    val items: List<BaseEntity>? = emptyList()
): BaseEntity(type = type, title = title)
