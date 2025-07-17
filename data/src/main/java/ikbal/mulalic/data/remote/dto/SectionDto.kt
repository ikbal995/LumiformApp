package ikbal.mulalic.data.remote.dto

import com.squareup.moshi.JsonClass
import ikbal.mulalic.data.LumiType
import ikbal.mulalic.data.local.entity.SectionEntity

@JsonClass(generateAdapter = false)
data class SectionDto(
    val title: String,
    val type: LumiType,
    val items: List<BaseDto>
)

/*fun SectionDto.toEntity() = SectionEntity(
    type = this.type,
    title = this.title,
    items = this.items.map { dto -> dto.toEntity() }
)*/

