package ikbal.mulalic.data.ui

import ikbal.mulalic.data.LumiType

data class Page(
    override val type: LumiType,
    override val title: String,
    override val items: List<BaseUiModel>? = emptyList()
) : BaseUiModel(type = type, title = title)
