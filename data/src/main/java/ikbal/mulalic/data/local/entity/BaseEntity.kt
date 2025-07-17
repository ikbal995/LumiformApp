package ikbal.mulalic.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import ikbal.mulalic.data.LumiType
import ikbal.mulalic.data.ui.BaseUiModel

@Entity
open class BaseEntity(
    @PrimaryKey(autoGenerate = true)
    open val id: Long? = 0,
    open val type: LumiType,
    open val title: String,
)

fun BaseEntity.toUiModel() = BaseUiModel(type = this.type, title = this.title)