package ikbal.mulalic.lumiformapp.mainscreen

import ikbal.mulalic.data.local.LumiDao
import ikbal.mulalic.data.local.entity.BaseEntity
import ikbal.mulalic.data.remote.ApiService
import ikbal.mulalic.data.remote.dto.toEntity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class MainRepositoryImpl @Inject constructor(
    private val api: ApiService,
    private val dao: LumiDao
) : MainRepository {
    override fun getData(): Flow<NetworkState<List<BaseEntity>>> = flow {
        emit(NetworkState.Loading)
        runCatching { api.getPages() }
            .onSuccess {
                dao.insertItems(it.toEntity())
                val items = dao.getItems().first()
                emit(NetworkState.Success(items))
            }
            .onFailure {
                val items = dao.getItems().first()
                if (items.isEmpty()) {
                    emit(NetworkState.Error(it))
                } else {
                    emit(NetworkState.Success(items))
                }
            }
    }
}