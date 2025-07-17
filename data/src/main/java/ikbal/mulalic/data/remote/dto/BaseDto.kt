package ikbal.mulalic.data.remote.dto

import com.squareup.moshi.JsonClass
import ikbal.mulalic.data.LumiType
import ikbal.mulalic.data.local.entity.BaseEntity

@JsonClass(generateAdapter = true)
data class BaseDto(
    val title: String,
    val type: LumiType,
    val items: List<BaseDto>? = emptyList(),
    val src: String? = null
)

fun BaseDto.toEntity(): BaseEntity = BaseEntity(
    type = this.type,
    title = this.title,
    src = this.src,
    items = this.items?.map { it.toEntity() }.orEmpty()
)