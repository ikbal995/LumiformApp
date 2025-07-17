package ikbal.mulalic.data.local

import androidx.room.TypeConverter
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import com.squareup.moshi.adapters.PolymorphicJsonAdapterFactory
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import ikbal.mulalic.data.LumiType
import ikbal.mulalic.data.local.entity.BaseEntity
import ikbal.mulalic.data.remote.dto.BaseDto
import ikbal.mulalic.data.remote.dto.PageDto
import ikbal.mulalic.data.remote.dto.QuestionDto
import ikbal.mulalic.data.remote.dto.SectionDto


class Converters {

    private val moshi = Moshi.Builder()
        .add(
            PolymorphicJsonAdapterFactory.of(BaseDto::class.java, "type")/*
                .withSubtype(PageDto::class.java, LumiType.PAGE.name)
                .withSubtype(SectionDto::class.java, LumiType.SECTION.name)
                .withSubtype(QuestionDto::class.java, LumiType.TEXT.name)
                .withSubtype(QuestionDto::class.java, LumiType.IMAGE.name)*/
        )
        .add(KotlinJsonAdapterFactory())
        .build()
    private val baseEntityListType =
        Types.newParameterizedType(List::class.java, BaseEntity::class.java)
    private val baseEntityListAdapter: JsonAdapter<List<BaseEntity>> =
        moshi.adapter(baseEntityListType)

    @TypeConverter
    fun fromBaseEntityArray(value: List<BaseEntity>?): String? {
        return value?.let { baseEntityListAdapter.toJson(it) }
    }

    @TypeConverter
    fun toBaseEntityArray(value: String?): List<BaseEntity>? {
        return value?.let { baseEntityListAdapter.fromJson(it) }
    }
}