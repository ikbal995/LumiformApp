package ikbal.mulalic.lumiformapp.ui.model

import android.os.Parcelable
import ikbal.mulalic.data.LumiType
import kotlinx.parcelize.Parcelize

@Parcelize
open class BaseUiModel(
    open val type: LumiType,
    open val title: String
): Parcelable
