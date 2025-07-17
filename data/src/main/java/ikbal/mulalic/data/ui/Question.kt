package ikbal.mulalic.data.ui

import ikbal.mulalic.data.LumiType

data class Question(
    override val type: LumiType,
    override val title: String,
    val imageUrl: String?
) : BaseUiModel(type = type, title = title)
