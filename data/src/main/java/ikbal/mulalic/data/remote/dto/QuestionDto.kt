package ikbal.mulalic.data.remote.dto

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import ikbal.mulalic.data.LumiType
import ikbal.mulalic.data.local.entity.QuestionEntity

@JsonClass(generateAdapter = false)
data class QuestionDto(
    override val type: LumiType,
    override val title: String,
    @Json(name = "src")
    val imageUrl: String?
) : BaseDto(type = type, title = title)

fun QuestionDto.toEntity() = QuestionEntity(
    type = this.type,
    title = this.title,
    imageUrl = this.imageUrl
)
