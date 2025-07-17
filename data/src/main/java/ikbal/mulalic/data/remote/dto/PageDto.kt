package ikbal.mulalic.data.remote.dto

import com.squareup.moshi.JsonClass
import ikbal.mulalic.data.LumiType
import ikbal.mulalic.data.local.entity.PageEntity

@JsonClass(generateAdapter = true)
data class PageDto(
    val type: LumiType,
    val title: String,
    val items: List<BaseDto>
)

/*fun PageDto.toEntity() = PageEntity(
    type = this.type,
    title = this.title,
    items = this.items.map { dto -> dto.toEntity() }
)*/
