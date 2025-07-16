package ikbal.mulalic.data.remote.dto

import com.squareup.moshi.JsonClass
import ikbal.mulalic.data.LumiType
import ikbal.mulalic.data.local.entity.PageEntity

@JsonClass(generateAdapter = true)
data class PageDto(
    override val type: LumiType,
    override val title: String,
    val items: List<BaseDto>
) : BaseDto(type = type, title = title)

fun PageDto.toEntity() = PageEntity(
    type = this.type,
    title = this.title,
    items = this.items.map { dto -> dto.toEntity() }
)
