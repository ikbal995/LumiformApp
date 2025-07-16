package ikbal.mulalic.lumiformapp.ui.model

import ikbal.mulalic.data.LumiType
import kotlinx.parcelize.Parcelize

@Parcelize
data class Question(
    override val type: LumiType,
    override val title: String,
    val imageUrl: String?
) : BaseUiModel(type = type, title = title)
