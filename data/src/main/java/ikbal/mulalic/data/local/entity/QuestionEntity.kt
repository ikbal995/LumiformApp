package ikbal.mulalic.data.local.entity

import androidx.room.Entity
import ikbal.mulalic.data.LumiType

@Entity
data class QuestionEntity(
    override val title: String,
    override val type: LumiType,
    val imageUrl: String?
) : BaseEntity(type = type, title = title)
