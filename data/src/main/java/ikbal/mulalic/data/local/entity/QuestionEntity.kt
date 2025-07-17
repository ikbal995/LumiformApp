package ikbal.mulalic.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import ikbal.mulalic.data.LumiType
import ikbal.mulalic.data.ui.Question
import java.util.UUID

@Entity
data class QuestionEntity(
    @PrimaryKey(autoGenerate = true) val id: Long? = 0,
    val title: String,
    val type: LumiType,
    val imageUrl: String?
)

fun QuestionEntity.toUiModel() =
    Question(type = this.type, title = this.title, imageUrl = this.imageUrl)