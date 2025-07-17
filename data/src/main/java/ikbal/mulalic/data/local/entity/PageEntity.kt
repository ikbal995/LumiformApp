package ikbal.mulalic.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import ikbal.mulalic.data.LumiType
import ikbal.mulalic.data.ui.Page

@Entity
data class PageEntity(
    @PrimaryKey(autoGenerate = true) val id: Long? = 0,
    val type: LumiType,
    val title: String,
    val items: List<BaseEntity>? = emptyList()
)

fun PageEntity.toUiModel() =
    Page(type = this.type, title = this.title, items = this.items?.map { it.toUiModel() }.orEmpty())
