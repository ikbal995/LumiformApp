package ikbal.mulalic.lumiformapp.mainscreen

import ikbal.mulalic.data.local.LumiDao
import ikbal.mulalic.data.local.entity.BaseEntity
import ikbal.mulalic.data.remote.ApiService
import ikbal.mulalic.data.remote.dto.toEntity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.distinctUntilChanged
import javax.inject.Inject

class MainRepositoryImpl @Inject constructor(
    private val api: ApiService,
    private val dao: LumiDao
) : MainRepository {
    override fun getItems(): Flow<List<BaseEntity>> = dao.getItems().distinctUntilChanged()

    override suspend fun fetchOrRefresh() {
        val page = api.getPages().toEntity()
        dao.insertItems(entities = page)
    }
}