package ikbal.mulalic.lumiformapp.mainscreen

import ikbal.mulalic.data.local.entity.BaseEntity
import ikbal.mulalic.data.local.entity.PageEntity
import kotlinx.coroutines.flow.Flow

interface MainRepository {
    fun getItems(): Flow<List<BaseEntity>>
    suspend fun fetchOrRefresh()
}