package ikbal.mulalic.lumiformapp

import ikbal.mulalic.data.LumiType
import ikbal.mulalic.data.local.LumiDao
import ikbal.mulalic.data.local.entity.BaseEntity
import ikbal.mulalic.data.remote.ApiService
import ikbal.mulalic.data.remote.dto.PageDto
import ikbal.mulalic.data.remote.dto.QuestionDto
import ikbal.mulalic.data.remote.dto.SectionDto
import ikbal.mulalic.data.remote.dto.toEntity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.distinctUntilChanged
import javax.inject.Inject

class MainRepositoryImpl @Inject constructor(
    private val api: ApiService,
    private val dao: LumiDao
): MainRepository {
    override fun getItems(): Flow<List<BaseEntity>> = dao.getItems().distinctUntilChanged()

    override suspend fun fetchOrRefresh() {
        val page = listOf(api.getPages()).map { dto ->
            when (dto.type) {
                LumiType.PAGE -> (dto as PageDto).toEntity()
                LumiType.SECTION -> (dto as SectionDto).toEntity()
                LumiType.TEXT, LumiType.IMAGE -> (dto as QuestionDto).toEntity()
            }
        }
        dao.insertItems(page)
    }
}