package ikbal.mulalic.lumiformapp.ui.model

import ikbal.mulalic.data.LumiType
import kotlinx.parcelize.Parcelize

@Parcelize
data class Page(
    override val type: LumiType,
    override val title: String,
    val items: List<BaseUiModel>? = emptyList()
) : BaseUiModel(type = type, title = title)
