package ikbal.mulalic.data.remote

import com.squareup.moshi.Moshi
import com.squareup.moshi.adapters.PolymorphicJsonAdapterFactory
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ikbal.mulalic.data.LumiType
import ikbal.mulalic.data.remote.dto.BaseDto
import ikbal.mulalic.data.remote.dto.PageDto
import ikbal.mulalic.data.remote.dto.QuestionDto
import ikbal.mulalic.data.remote.dto.SectionDto
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RetrofitModule {
    @Provides
    @Singleton
    fun provideMoshi(): Moshi = Moshi.Builder()
        .add(
            PolymorphicJsonAdapterFactory.of(BaseDto::class.java, "type")
                .withSubtype(PageDto::class.java, LumiType.PAGE.name.lowercase())
                .withSubtype(SectionDto::class.java, LumiType.SECTION.name.lowercase())
                .withSubtype(QuestionDto::class.java, LumiType.TEXT.name.lowercase())
                .withSubtype(QuestionDto::class.java, LumiType.IMAGE.name.lowercase())
        )
        .add(KotlinJsonAdapterFactory())
        .build()

    @Provides
    @Singleton
    fun provideRetrofit(moshi: Moshi): Retrofit = Retrofit.Builder()
        .baseUrl("https://mocki.io/v1/")
        .addConverterFactory(MoshiConverterFactory.create(moshi))
        .build()

    @Provides
    @Singleton
    fun provideApi(retrofit: Retrofit): ApiService = retrofit.create(ApiService::class.java)
}