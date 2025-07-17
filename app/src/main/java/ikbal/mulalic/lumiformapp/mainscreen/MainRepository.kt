package ikbal.mulalic.lumiformapp.mainscreen

import ikbal.mulalic.data.local.entity.BaseEntity
import kotlinx.coroutines.flow.Flow

interface MainRepository {
    fun getItems(): Flow<List<BaseEntity>>
    suspend fun fetchOrRefresh()
}