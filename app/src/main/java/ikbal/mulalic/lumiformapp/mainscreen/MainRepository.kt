package ikbal.mulalic.lumiformapp.mainscreen

import ikbal.mulalic.data.local.entity.BaseEntity
import kotlinx.coroutines.flow.Flow

interface MainRepository {
    fun getData(): Flow<NetworkState<List<BaseEntity>>>
}