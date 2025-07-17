package ikbal.mulalic.data.ui

import ikbal.mulalic.data.LumiType

data class Section(
    override val title: String,
    override val type: LumiType,
    override val items: List<BaseUiModel>? = emptyList()
) : BaseUiModel(title = title, type = type)