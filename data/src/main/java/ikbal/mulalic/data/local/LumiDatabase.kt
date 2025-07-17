package ikbal.mulalic.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import ikbal.mulalic.data.local.entity.BaseEntity

@Database(
    entities = [BaseEntity::class],
    version = 1,
    exportSchema = false
)
@TypeConverters(Converters::class)
abstract class LumiDatabase : RoomDatabase() {
    abstract fun baseEntityDao(): LumiDao
}