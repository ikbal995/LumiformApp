package ikbal.mulalic.lumiformapp

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ikbal.mulalic.data.local.LumiDao
import ikbal.mulalic.data.remote.ApiService
import ikbal.mulalic.lumiformapp.mainscreen.MainRepository
import ikbal.mulalic.lumiformapp.mainscreen.MainRepositoryImpl
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object MainModule {
    @Provides
    @Singleton
    fun provideRepository(dao: LumiDao, api: ApiService): MainRepository =
        MainRepositoryImpl(api = api, dao = dao)
}