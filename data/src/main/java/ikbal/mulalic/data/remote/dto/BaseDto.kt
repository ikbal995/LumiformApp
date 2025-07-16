package ikbal.mulalic.data.remote.dto

import ikbal.mulalic.data.LumiType
import ikbal.mulalic.data.local.entity.BaseEntity

open class BaseDto(
    open val title: String,
    open val type: LumiType
) {
    fun BaseDto.toEntity() = BaseEntity(
        type = this.type,
        title = this.title
    )
}