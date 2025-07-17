package ikbal.mulalic.data.ui

import ikbal.mulalic.data.LumiType

open class BaseUiModel(
    open val type: LumiType,
    open val title: String,

    open val items: List<BaseUiModel>? = emptyList(),

    open val imageUrl: String? = null
)
