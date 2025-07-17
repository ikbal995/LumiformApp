package ikbal.mulalic.data

import com.squareup.moshi.Json

enum class LumiType {
    @Json(name = "page")
    PAGE,
    @Json(name = "section")
    SECTION,
    @Json(name = "text")
    TEXT,
    @Json(name = "image")
    IMAGE
}