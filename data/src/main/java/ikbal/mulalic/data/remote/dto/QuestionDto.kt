package ikbal.mulalic.data.remote.dto

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import ikbal.mulalic.data.LumiType
import ikbal.mulalic.data.local.entity.QuestionEntity

@JsonClass(generateAdapter = false)
data class QuestionDto(
    val type: LumiType,
    val title: String,
    @Json(name = "src")
    val imageUrl: String?
)

/*fun QuestionDto.toEntity() = QuestionEntity(
    type = this.type,
    title = this.title,
    imageUrl = this.imageUrl
)*/
