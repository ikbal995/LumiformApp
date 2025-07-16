package ikbal.mulalic.lumiformapp.ui.model

import ikbal.mulalic.data.LumiType
import kotlinx.parcelize.Parcelize

@Parcelize
data class Section(
    override val title: String,
    override val type: LumiType,
    val items: List<BaseUiModel>? = emptyList()
) : BaseUiModel(title = title, type = type)