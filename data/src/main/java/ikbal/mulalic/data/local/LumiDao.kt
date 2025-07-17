package ikbal.mulalic.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import ikbal.mulalic.data.local.entity.BaseEntity
import ikbal.mulalic.data.local.entity.PageEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface LumiDao {
    @Query("SELECT * FROM BaseEntity")
    fun getItems(): Flow<List<BaseEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertItems(entities: BaseEntity)
}