package ikbal.mulalic.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import ikbal.mulalic.data.local.entity.PageEntity
import ikbal.mulalic.data.local.entity.QuestionEntity
import ikbal.mulalic.data.local.entity.SectionEntity

@Database(
    entities = [PageEntity::class, SectionEntity::class, QuestionEntity::class],
    version = 1,
    exportSchema = false
)
@TypeConverters(Converters::class)
abstract class LumiDatabase : RoomDatabase() {
    abstract fun baseEntityDao(): LumiDao
}